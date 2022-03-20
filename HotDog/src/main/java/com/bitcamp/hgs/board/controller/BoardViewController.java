package com.bitcamp.hgs.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.board.service.BoardReplyService;
import com.bitcamp.hgs.board.service.BoardViewService;

@Controller
public class BoardViewController {

	@Autowired
	private BoardViewService viewService;
	
	@Autowired
	private BoardReplyService replyService;
	
	@GetMapping("/board/view")
	public void getViewPage(@RequestParam("boardIdx") int boardIdx, Model model) {
		
		model.addAttribute("pageView", viewService.getPageView(boardIdx));
		model.addAttribute("replyList", replyService.getList(boardIdx));
		
		System.out.println(replyService.getList(boardIdx));
		
	}
}
