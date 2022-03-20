package com.bitcamp.hgs.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.board.service.BoardPageViewService;
import com.bitcamp.hgs.board.service.ReplyListService;



@Controller
public class BoardViewController {
	@Autowired
	private BoardPageViewService viewService;
	
	@Autowired
	private ReplyListService replyListService;
	

	@GetMapping("/board/view")
	public void getViewPage(
			@RequestParam("idx") int idx,
			Model model
			) {
		model.addAttribute("pageView", viewService.getPageView(idx));
		model.addAttribute("replyList", replyListService.getReplyList(idx));
	}
}
