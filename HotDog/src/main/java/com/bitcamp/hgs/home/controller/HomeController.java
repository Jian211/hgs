package com.bitcamp.hgs.home.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

//	@GetMapping("/join")
//	public String join() {
//		return "home/join";
//		
//	}
	
	KakaoAPI kakaoApi = new KakaoAPI();
	
	@RequestMapping(value = "/oauth")
	public ModelAndView test(	@RequestParam("code") String code, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		System.out.println("1.인증코드 요청 전달");
		// 1. 인증코드 요청 전달
		String accessToken = kakaoApi.getAccessToken(code);
		
		System.out.println("2.인증코드 토큰 전달");
		System.out.println("accessToken : "+ accessToken);
		// 2. 인증코드로 토큰 전달
		HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);
		
		System.out.println("login info : " + userInfo.toString());
		
		if(userInfo.get("email") != null) {
			session.setAttribute("userId", userInfo.get("email"));
			session.setAttribute("accessToken", accessToken);
		}
		
		mav.addObject(userInfo.get("email"));
		mav.setViewName("index");
		
		return mav;
	}
	
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		kakaoApi.kakaoLogout((String)session.getAttribute("access_token"));
		session.removeAttribute("accses_token");
		session.removeAttribute("userId");
		
		mav.setViewName("index");
		
		return mav;
	}

	

	
	
}
