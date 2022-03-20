package com.bitcamp.hgs.board.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.hgs.board.domain.RegBoardInfo;
import com.bitcamp.hgs.board.service.BoardRegService;

@Controller
@RequestMapping("/board/register")
public class BoardRegController {
	
	@Autowired
	private BoardRegService regService;
	
	@GetMapping
	public String regBoard() {
		
		return "board/register";
	}
	
	@PostMapping
	public String regBoard(RegBoardInfo regBoardInfo, HttpServletRequest request) throws IllegalStateException, IOException {
		
		
		regService.registBoard(regBoardInfo, request);
		
		
		return "redirect:/board/list";
	}
}
