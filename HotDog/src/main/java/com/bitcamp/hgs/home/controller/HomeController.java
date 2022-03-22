package com.bitcamp.hgs.home.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.hgs.home.domain.Breed;
import com.bitcamp.hgs.home.domain.LoginFormInfo;
import com.bitcamp.hgs.home.service.LoginService;
import com.bitcamp.hgs.home.service.SearchService;
import com.bitcamp.hgs.home.service.BreedService;
import com.bitcamp.hgs.home.service.HomePlaceService;
import com.bitcamp.hgs.home.service.HomeService;


@Controller
public class HomeController {

	HomeService homeService;
	BreedService breedService;
	LoginService loginService;
	HomePlaceService homePlaceService;
	SearchService searchService;
	
	HomeController (SearchService searchService,HomeService homeService, BreedService breedService, LoginService loginService, HomePlaceService homePlaceService){
		this.breedService = breedService;
		this.homeService = homeService;
		this.searchService = searchService;
		this.loginService = loginService;
		this.homePlaceService = homePlaceService;
	}
	
	
	
	@GetMapping("/home")
	public String home(Model model, HttpSession session) {
		return homeService.getHomeContent(model, session);
	}
	
	
	// 회원가입
	@GetMapping("/join")
	public String join( Model model ) {
		return breedService.getDogTypeList(model);
	}
	
	
	// 회원가입 형식 선택 페이지
	@GetMapping("/joinType")
	public String joinType() {
		return "home/joinType";
	}
	
	@GetMapping("/join/breed")
	@ResponseBody
	public ArrayList<Breed> searchDogType() {
		return breedService.getDogTypeList();
	}
	
	@PostMapping("/join/breed")
	@ResponseBody
	public int isDogTypeExist( @RequestParam("dogType") String dogType) {
		return breedService.isDogTypeExist(dogType);
	}
	
	// ログイン確認  - 로그인 확인 
	@PostMapping("/login")
	public String login(LoginFormInfo loginFormInfo, HttpSession session, HttpServletResponse res) {
		return loginService.checkMember(loginFormInfo, session, res);
	}
	
		// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("logger");
		return "home/login";
	}

	// Search 
	@PostMapping("/search")
	public String search(@RequestParam("q") String q, HttpSession session, Model model) {
		return searchService.selectAllTable(q, session, model);
	}

	// mypage
	@GetMapping("/member/mypage")
	public String showMyPage() {
		return "member/mypage";
	}

}

