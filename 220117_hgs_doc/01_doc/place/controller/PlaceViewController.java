package com.bitcamp.hgs.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.place.service.PlaceViewService;

@Controller
public class PlaceViewController {

	@Autowired
	private PlaceViewService viewService;
	
	@RequestMapping("/place/view")
	public void getViewPage(@RequestParam("idx") int idx, Model model) {
		
		model.addAttribute("pageView", viewService.getPageView(idx));
	}
}
