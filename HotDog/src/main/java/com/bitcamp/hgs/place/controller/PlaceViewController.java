package com.bitcamp.hgs.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.place.service.PlaceReplyService;
import com.bitcamp.hgs.place.service.PlaceViewService;

@Controller
public class PlaceViewController {

	@Autowired
	private PlaceViewService viewService;
	
	@Autowired
	private PlaceReplyService replyService;
	
	@GetMapping("/place/view")
	public void getViewPage(@RequestParam("placeIdx") int placeIdx, Model model) {
		
		model.addAttribute("pageView", viewService.getPageView(placeIdx));
		model.addAttribute("replyList", replyService.getList(placeIdx));
		
		System.out.println(replyService.getList(placeIdx));
		
	}
}
