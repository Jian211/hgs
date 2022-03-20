package com.bitcamp.hgs.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bitcamp.hgs.board.domain.Boards;
import com.bitcamp.hgs.board.service.BoardUpdateService;

@Controller
public class BoardUpdateController {

	@Autowired
	private BoardUpdateService updateService;
	
	@GetMapping("board/update")
	public void updateBoard() {
		
	}
	
	@PostMapping("board/update")
	public String updateBoard(Boards board) {
		
		updateService.updateBoard(board);
		
		return "redirect:/board/list";
	}
}
