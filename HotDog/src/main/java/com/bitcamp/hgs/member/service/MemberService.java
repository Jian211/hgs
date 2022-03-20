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
	
	// 유저 저장 create
	public void insertMember(RegMember regMember, HttpServletRequest request) throws IllegalStateException, IOException  {
		System.out.println("regMember = "+ regMember);
		// DB관련 예외 발생 시  삭제처리를 위한 File 객체 변수 선언
		File newFile = null;
		String savePath = request.getSession().getServletContext().getRealPath("/uploadfile");
		
		// 파일이 있다면 저장
		if(!regMember.getProfile().isEmpty() && regMember.getProfile().getSize() > 0) {
			String[] files = regMember.getProfile().getOriginalFilename().split("\\.");
			String exet = files[files.length - 1];
			String newFileName = System.nanoTime() + "." + exet;
			newFile = new File(savePath, newFileName);
			regMember.getProfile().transferTo(newFile);
		} 
		
		// 파일이 없다면 기본 이미지
		else newFile = new File("noProfile.jpg");
		
		
		// 비밀번호 암호화
		regMember.setPassword(encoder.encode(regMember.getPassword()));
		
		// sns계정 이용하는 분이라면, email = snsId 
		int snsType = 0; // 아니면 0  0은 일반이메일 회원
		if(regMember.getSnsId() != null ) 	{
			regMember.setEmail(regMember.getSnsId());
			snsType = regMember.getSnsType().equals("kakao") ? 1 : 2;
		}
		
		// DB에 저장할 유저정보 생성 및 DB에 저장
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
		

		// 유저의 hashtag Data가 있을 때, DB에 저장한다.
		if(!regMember.getHashtagIdx().isEmpty()) {
			
			System.out.println(insertMember.getMemberIdx()+"의 해쉬태그 정보를 저장하겠습니다. ");
		
			// 리스트에 유저id와 hashtag 아이디 저장
			List<MemberHashtag> memberHashtagList = new ArrayList<MemberHashtag>();
			for (int i = 0; i < regMember.getHashtagIdx().size(); i++) {
				int hashtagIdx = Integer.parseInt(regMember.getHashtagIdx().get(i));
				memberHashtagList.add(new MemberHashtag(insertMember.getMemberIdx(),hashtagIdx));
			}
		
			// DB저장
			template.insert("com.bitcamp.hgs.member.dao.MemberDao.insertMemberHashtag", memberHashtagList);
			System.out.println(insertMember.getMemberIdx()+"의 해쉬태그들 저장완료 ");
		}
		
		// 메일발송
		if(senderService.send(insertMember.getEmail(), insertMember.getName()) > 0) {
			System.out.printf("%s님에게 메일을 발송했습니다.",insertMember.getName());
		}else{
			System.out.printf("%s님에게 메일 발송이 실패했습니다.",insertMember.getName());
		};
	}

	// sns유저의 이메일 정보가 있는지 확인
	public Member selectOauthId(String email) {
		return template.getMapper(MemberDao.class).selectMember(email);
	}

	
	public void editMember(PutMember putMember, int memberIdx, HttpServletRequest request) {

		// 파일 저장
		int resultCnt = 0;

		// DB 관련 예외 발생 시 삭제 처리를 위한 File 객체 변수 선언
		File newFile = null;

		// 파일이 있다면 -> 파일 저장
		if (!putMember.getProfile().isEmpty() && putMember.getProfile().getSize() > 0) {
			// 시스템의 경로
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
				
				// 해시태그도 저장해야함 해시태그 저장
				// 1. 해시태그 정보 삭제
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

		// 파일이 저장된 후 DB관련 예외가 발생했을 때 : 저장했던 파일을 삭제
		if (newFile != null && newFile.exists()) {
			newFile.delete();
		}

		System.out.println(resultCnt);
	
	}

	// 유저삭제 실행 후 페이지 주소를 전달함. 성공시 로그인 페이지, 실패시 내정보 페이지
	public String deleteMember(int memberIdx, HttpSession session) {
		String url = "/hgs";
		
		// 멤버 삭제 후 성공시 1 반환
		int result = template.getMapper(MemberDao.class).deleteByIdx(memberIdx);
		
		if(result > 0) {
			session.removeAttribute("logger");
		} else {
			url = "/hgs/member/mypage";
		}
		
		return url;
	}

	// 유저의 정보를 받아서 저장 후 url전달
	public String getMember(int memberIdx, Model model) {
		model.addAttribute("member", template.getMapper(MemberDao.class).selectByIdx(memberIdx));
		model.addAttribute("breedList", breedService.getDogTypeList());
		model.addAttribute("hashtags", template.getMapper(MemberDao.class).selectMemberHashtags(memberIdx));
		model.addAttribute("basicTagList", new BasicTagList().getBTL());
		return "/hgs/member/mypage";
	}
	
}
