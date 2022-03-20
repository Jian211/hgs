package com.bitcamp.hgs.home.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.domain.LoginFormInfo;
import com.bitcamp.hgs.member.dao.MemberDao;
import com.bitcamp.hgs.member.domain.Logger;
import com.bitcamp.hgs.member.domain.Member;

@Service
public class LoginService {
	
	SqlSessionTemplate template;
	BCryptPasswordEncoder encoder;
	
	LoginService (SqlSessionTemplate template, BCryptPasswordEncoder encoder){
		this.template = template;
		this.encoder = encoder;
	}
	
	// 조인만
	public String checkMember(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
		String viewName = "redirect:/";
		
		// 멤버말고 해쉬태그 정보까지 갖고와야한다. 새로운 클래스를 만들어야함
		System.out.println(loginFormInfo.getEmail());
		Member member = template.getMapper(MemberDao.class).selectMember(loginFormInfo.getEmail());
		
		// 등록된 유저가 없을 때
		if(member == null) 	System.out.println("등록된 유저가 없습니다.");
		
		// 패스워드가 일치하는지 확인 후 맞을 시, 세션에 유저 정보 등록 및 메인페이지로 가는 주소 삽입
		else {
			if(encoder.matches(loginFormInfo.getPassword(), member.getPassword())) {
				Logger logger = member.getLoggerInfo();

				// 해시태그 리스트도 추가 
				logger.setHashtags(template.getMapper(MemberDao.class).selectMemberHashtags(logger.getMemberIdx()));
				System.out.println("logger.getHashtags() : " + logger.getHashtags());
				session.setAttribute("logger", logger);
				viewName += "home";
			} else System.out.println("패스워드가 일치하지 않습니다.");
				
			// saveEmail버튼이 체크 되어있다면, 쿠키를 이용하여 저장
			if(loginFormInfo.getSaveEmail() != null && loginFormInfo.getSaveEmail().equals("on")) {
				Cookie cookie = new Cookie("saveEmail", loginFormInfo.getSaveEmail());
				res.addCookie(cookie);
			}
		}
		
		return viewName;
	}


	// sns login
	public String loginOauth(Member member, HttpSession session) {
		session.setAttribute("logger", member.getLoggerInfo());
		return "redirect:/home";
	}


	
	
	
	
}
