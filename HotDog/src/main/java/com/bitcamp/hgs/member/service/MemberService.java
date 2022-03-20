package com.bitcamp.hgs.member.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.hgs.member.dao.MemberDao;
import com.bitcamp.hgs.member.domain.BasicTagList;
import com.bitcamp.hgs.member.domain.InsertMember;
import com.bitcamp.hgs.member.domain.Member;
import com.bitcamp.hgs.member.domain.MemberHashtag;
import com.bitcamp.hgs.member.domain.PutMember;
import com.bitcamp.hgs.member.domain.RegMember;
import com.bitcamp.hgs.member.domain.UpdatePutMember;

@Service
public class MemberService {
	
	private SqlSessionTemplate template;
	private BCryptPasswordEncoder encoder;
	private MailSenderService senderService;
	private BreedService breedService;

	MemberService(	SqlSessionTemplate template,BCryptPasswordEncoder encoder,	MailSenderService senderService, BreedService breedService){
		this.template = template;
		this.encoder = encoder;
		this.senderService = senderService;
		this.breedService = breedService;
	}
	
	// Create - Member SAVE
	public void insertMember(RegMember regMember, HttpServletRequest request) throws IllegalStateException, IOException  {
		File newFile = null;
		String savePath = request.getSession().getServletContext().getRealPath("/uploadfile");
		
		if(!regMember.getProfile().isEmpty() && regMember.getProfile().getSize() > 0) {
			String[] files = regMember.getProfile().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			regMember.getProfile().transferTo(newFile);
		} 
		
		else newFile = new File("noProfile.jpg");
		
		regMember.setPassword(encoder.encode(regMember.getPassword()));		// password Hash化
		
		int snsType = 0; // 아니면 0  0은 일반이메일 회원
		if(regMember.getSnsId() != null ) 	{
			regMember.setEmail(regMember.getSnsId());
			snsType = regMember.getSnsType().equals("kakao") ? 1 : 2;
		}
		
		InsertMember insertMember = new InsertMember(
				regMember.getEmail(),	
				regMember.getPassword(), 
				regMember.getName(), 	 
				regMember.getPetNumber(),
				newFile.getName(),
				regMember.getAddress(),  
				regMember.getBirthday(), 
				Integer.parseInt(regMember.getSex()),		
				Integer.parseInt(regMember.getNeutering()),
				Integer.parseInt(regMember.getBreedIdx()), 
				regMember.getSnsId(),
				snsType
		);

		template.insert("com.bitcamp.hgs.member.dao.MemberDao.insertMemberInfo", insertMember);
		
		// Save DB when user have Hashtag Data.
		if(!regMember.getHashtagIdx().isEmpty()) {
			
			System.out.println(insertMember.getMemberIdx()+"의 해쉬태그 정보를 저장하겠습니다. ");
		
			// Save Member Idx and hastag in List
			List<MemberHashtag> memberHashtagList = new ArrayList<MemberHashtag>();
			for (int i = 0; i < regMember.getHashtagIdx().size(); i++) {
				int hashtagIdx = Integer.parseInt(regMember.getHashtagIdx().get(i));
				memberHashtagList.add(new MemberHashtag(insertMember.getMemberIdx(),hashtagIdx));
			}
		
			// Save in DB.
			template.insert("com.bitcamp.hgs.member.dao.MemberDao.insertMemberHashtag", memberHashtagList);
			System.out.println(insertMember.getMemberIdx()+"의 해쉬태그들 저장완료 ");
		}
		
		// Send mail
		if(senderService.send(insertMember.getEmail(), insertMember.getName()) > 0) {
			System.out.printf("%s님에게 메일을 발송했습니다.",insertMember.getName());
		}else{
			System.out.printf("%s님에게 메일 발송이 실패했습니다.",insertMember.getName());
		};
	}

	// Read - SNS Member
	public Member selectOauthId(String email) {
		return template.getMapper(MemberDao.class).selectMember(email);
	}

	// Update - Member Edit
	public void editMember(PutMember putMember, int memberIdx, HttpServletRequest request) {
		int resultCnt = 0;
		File newFile = null;
		
		// File save when File is exist.
		if (!putMember.getProfile().isEmpty() && putMember.getProfile().getSize() > 0) {
			String savePath = request.getSession().getServletContext().getRealPath("/uploadfile");
			String[] files = putMember.getProfile().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			try {
				putMember.getProfile().transferTo(newFile);
				UpdatePutMember updatePutMember = putMember.getUpdatePutMember();
				updatePutMember.setMemberIdx(memberIdx);
				updatePutMember.setFileName(newFileName);
				System.out.println(updatePutMember);
				
				resultCnt = template.getMapper(MemberDao.class).editMember(updatePutMember);
				
				template.getMapper(MemberDao.class).deleteMemberHashtags(memberIdx);
				
				List<MemberHashtag> hashList = new ArrayList<MemberHashtag>();
				for (int i = 0; i < putMember.getHashtags().size(); i++) {
					hashList.add(new MemberHashtag(memberIdx, putMember.getHashtags().get(i)));
				}
				template.getMapper(MemberDao.class).insertMemberHashtag(hashList);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// When file saved error! : Delete Saved File
		if (newFile != null && newFile.exists()) {
			newFile.delete();
		}
	}

	// Delete - remove Member and return send URL. when success, go to Login. when fail, go to Mypage.
	public String deleteMember(int memberIdx, HttpSession session) {
		template.getMapper(MemberDao.class).deleteByIdx(memberIdx);
		session.removeAttribute("logger");
		return  "/hgs/member/mypage";
	}

	// Read - Get infomation of Member and return URL.
	public String getMember(int memberIdx, Model model) {
		model.addAttribute("member", template.getMapper(MemberDao.class).selectByIdx(memberIdx));
		model.addAttribute("breedList", breedService.getDogTypeList());
		model.addAttribute("hashtags", template.getMapper(MemberDao.class).selectMemberHashtags(memberIdx));
		model.addAttribute("basicTagList", new BasicTagList().getBTL());
		return "/hgs/member/mypage";
	}
	
}
