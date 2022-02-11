package com.bitcamp.hgs.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.hgs.home.domain.EmailType;
import com.bitcamp.hgs.home.service.OauthService;


@RestController
@RequestMapping("/oauth")
public class OauthController {
	
	@Autowired
	OauthService oauthService;

	@GetMapping("/{snsType}") 
	public ModelAndView snsLoginType(
			@PathVariable("snsType") String snsType,
			@RequestParam("code") String code) {
		ModelAndView mav = new ModelAndView();
		System.out.println(snsType);
		
		// 인증코드로 토큰 요청 -> 토큰으로 유저 email GET
		String accessToken = oauthService.getAccessToken(snsType ,code);	 
		String email = oauthService.getEmail(snsType, accessToken);
		
		// Join Page에 전달할 유저 email과 SNS Type객체 
		EmailType emailType = new EmailType(email, snsType);
		
		// Model에 위 객체 전달
		mav.addObject("emailType", emailType); 
		mav.setViewName("home/join");
		return mav;
	}
	
}
