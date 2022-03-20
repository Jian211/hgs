package com.bitcamp.hgs.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.place.domain.Places;
import com.bitcamp.hgs.place.service.PlaceUpdateService;
import com.bitcamp.hgs.place.service.PlaceViewService;

@Controller
@RequestMapping("/place/update")
public class PlaceUpdateController {

	@Autowired
	private PlaceUpdateService updateService;
	
	@Autowired
	private PlaceViewService viewService;
	
	@GetMapping
	public void updatePlace(@RequestParam("placeIdx") int placeIdx, Model model) {
		
		model.addAttribute("pageView", viewService.getPageView(placeIdx));
	}
	
	@PostMapping
	public String updatePlace(Places place) {
		
		System.out.println(place);
		
		updateService.updatePlace(place);
		
		return "redirect:/place/list";
	}
}
