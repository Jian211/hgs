package com.bitcamp.hgs.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.board.service.BoardDeleteService;

@Controller
public class BoardDeleteController {

	@Autowired
	private BoardDeleteService deleteService;
	
	@PostMapping("/delete")
	public String deleteBoard(@RequestParam("boardIdx") int boardIdx) {
	
		deleteService.deleteBoard(boardIdx);
		
		return "redirect:/board/list";
	}
}
