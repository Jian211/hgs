package com.bitcamp.hgs.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.board.domain.BoardReplys;
import com.bitcamp.hgs.board.service.BoardReplyService;

@RestController
@RequestMapping("/board/reply")
public class BoardReplyController {

	@Autowired
	private BoardReplyService replyService;

	// 후기 등록
	@PostMapping
	public String registReply(BoardReplys reply) {

		replyService.registReply(reply);

		return String.valueOf(reply.getBoardReplyIdx());
	}

	

	// 후기 삭제
	@DeleteMapping("/{boardReplyIdx}")
	public String deleteReply(@PathVariable("boardReplyIdx") int boardReplyIdx) {
		
		replyService.deleteReply(boardReplyIdx);
	
		return String.valueOf(replyService.deleteReply(boardReplyIdx));
	}
	

}
