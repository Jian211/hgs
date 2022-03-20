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
	
	public String checkMember(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
		String viewName = "redirect:/";
		
		Member member = template.getMapper(MemberDao.class).selectMember(loginFormInfo.getEmail());
		
		if(encoder.matches(loginFormInfo.getPassword(), member.getPassword())) {
			Logger logger = member.getLoggerInfo();
			logger.setHashtags(template.getMapper(MemberDao.class).selectMemberHashtags(logger.getMemberIdx()));
			session.setAttribute("logger", logger);
			viewName += "home";
		} else System.out.println("パスワードが正しくありません。"); // 패스워드가 틀립니다.
			
		// Cookie
		if(loginFormInfo.getSaveEmail() != null && loginFormInfo.getSaveEmail().equals("on")) {
			Cookie cookie = new Cookie("saveEmail", loginFormInfo.getSaveEmail());
			res.addCookie(cookie);
		}
		
		return viewName;
	}


	// sns login
	public String loginOauth(Member member, HttpSession session) {
		session.setAttribute("logger", member.getLoggerInfo());
		return "redirect:/home";
	}


	
	
	
	
}
