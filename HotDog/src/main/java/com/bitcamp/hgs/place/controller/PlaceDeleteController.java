package com.bitcamp.hgs.place.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.place.service.PlaceDeleteService;

@Controller
public class PlaceDeleteController {

	@Autowired
	private PlaceDeleteService deleteService;
	
	@PostMapping("/place/delete")
	public String deletePlace(@RequestParam("placeIdx") int placeIdx) {
		
		
		deleteService.deletePlace(placeIdx);
		
		return "redirect:/place/list";
	}
}
