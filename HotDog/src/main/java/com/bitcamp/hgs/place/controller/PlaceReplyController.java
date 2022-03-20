package com.bitcamp.hgs.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.place.domain.PlaceReplys;
import com.bitcamp.hgs.place.service.PlaceReplyService;

@RestController
@RequestMapping("/place/reply")
public class PlaceReplyController {

	@Autowired
	private PlaceReplyService replyService;

	// 후기 등록
	@PostMapping
	public String registReply(PlaceReplys reply) {

		replyService.registReply(reply);

		return String.valueOf(reply.getPlaceReplyIdx());
	}

	// 후기 삭제
	@DeleteMapping("/{placeReplyIdx}")
	public String deleteReply(@PathVariable("placeReplyIdx") int placeReplyIdx) {

		replyService.deleteReply(placeReplyIdx);

		System.out.println("placeReplyIdx확인:" + placeReplyIdx);
		return String.valueOf(replyService.deleteReply(placeReplyIdx));
	}

}
