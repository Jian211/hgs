package com.bitcamp.hgs.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.place.domain.PlaceReplys;
import com.bitcamp.hgs.place.service.PlaceReplyDeleteService;
import com.bitcamp.hgs.place.service.PlaceReplyListService;
import com.bitcamp.hgs.place.service.PlaceReplyRegService;

@RestController
@RequestMapping("/place/reply")
public class PlaceReplyController {
	
	@Autowired
	private PlaceReplyListService listService;
	
	@Autowired
	private PlaceReplyRegService regService;
	
	@Autowired
	private PlaceReplyDeleteService delService;
	
	// 후기 리스트 출력
	//@GetMapping
	//public void getReplyList()
	
	
	// 후기 입력
	@PostMapping
	public String regReply(PlaceReplys replys) {
		
		regService.insertReply(replys);
		System.out.println("입력된 idx" + replys.getPlaceReplyIdx());
		return String.valueOf(replys.getPlaceReplyIdx());
	}
	
	// 후기 삭제
	@DeleteMapping("/{placeReplyIdx}")
	public String deleteReply(@PathVariable("placeReplyIdx") int idx) {
		
		System.out.println("idx" + idx);
		
		return String.valueOf(delService.deleteReply(idx));
	}
}
