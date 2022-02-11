package com.bitcamp.hgs.home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
	
	// 회원가입 형식 선택 페이지
	@GetMapping("/joinType")
	public String joinType() {
		return "home/joinType";
	}

	// 회원가입 페이지
	@GetMapping("/join")
	public String join() {
		return "home/join";
	}

	
}

