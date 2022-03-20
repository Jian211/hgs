package com.bitcamp.hgs.home.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.home.domain.AllTableList;
import com.bitcamp.hgs.home.service.SearchService;
import com.bitcamp.hgs.member.domain.Logger;

@Controller
@RequestMapping("/search")
public class SearchController {
	
	SearchService searchService;
	
	SearchController(SearchService searchService){
		this.searchService = searchService;
	}
	
	
	// 홈 검색 Bar
	// 병원, 카페, 공원, 게시글 기준으로 잡았다.
	@PostMapping
	public String aa(@RequestParam("q") String q, HttpSession session, Model model) {
		System.out.println("q = "+q );
		Logger logger = (Logger)session.getAttribute("logger");
		AllTableList allPlaces = searchService.selectAllTable(q, logger.getMemberIdx());
		model.addAttribute("allPlaces", allPlaces);
		return "home/search";
	}
}
