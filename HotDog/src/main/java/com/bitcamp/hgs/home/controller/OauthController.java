package com.bitcamp.hgs.home.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.hgs.home.domain.Breed;
import com.bitcamp.hgs.home.domain.EmailType;
import com.bitcamp.hgs.home.service.BreedService;
import com.bitcamp.hgs.home.service.LoginService;
import com.bitcamp.hgs.home.service.OauthService;
import com.bitcamp.hgs.member.domain.Member;
import com.bitcamp.hgs.member.service.MemberService;


@RestController
@RequestMapping("/member/oauth")
public class OauthController {

	OauthService oauthService;
	MemberService memberService;
	LoginService loginService;
	BreedService breedService;
	
	OauthController(OauthService oauthService, MemberService memberService, LoginService loginService, BreedService breedService){
		this.oauthService = oauthService;
		this.memberService = memberService;
		this.loginService = loginService;
		this.breedService =  breedService;
	}
	

	@GetMapping("/{snsType}") 
	public ModelAndView snsLoginType(@PathVariable("snsType") String snsType,ModelAndView mav , @RequestParam("code") String code,  HttpSession session) {
		System.out.println(snsType);
		
		// 인증코드로 토큰 요청 -> 토큰으로 유저 email GET
		String accessToken = oauthService.getAccessToken(snsType ,code);	 
		String email = oauthService.getEmail(snsType, accessToken);
		
		// DB에 이메일 정보가 있는지 확인 후, 로그인 처리 or 회원가입
		Member member = memberService.selectOauthId(email);
		
		if(member != null) {
			// 이미 있는 회원 -> 로그인 처리 -> return view경로
			mav.setViewName(loginService.loginOauth(member,session));
			return mav;
		}
		
		// Join Page에 전달할 유저 email과 SNS Type객체 
		EmailType emailType = new EmailType(email, snsType);
		
		// Model에 위 객체 전달
		mav.addObject("emailType", emailType); 
		mav.setViewName("home/join");
		
		ArrayList<Breed> breedList = breedService.getDogTypeList();
		System.out.println("breedList = "+ breedList);
		mav.addObject("breedList", breedList);
		return mav;
	}
	
}
