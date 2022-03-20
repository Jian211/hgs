package com.bitcamp.hgs.place.controller;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.hgs.place.domain.RegPlaceInfo;
import com.bitcamp.hgs.place.service.PlaceRegService;

@Controller
@RequestMapping("/place/register")
public class PlaceRegController {
	
	@Autowired
	private PlaceRegService regService;
	
	@GetMapping
	public String regPlace() {
		
		return "place/register";
	}
	
	@PostMapping
	public String regPlace(RegPlaceInfo regPlaceInfo, HttpServletRequest request) throws IllegalStateException, IOException {
		
		regService.registPlace(regPlaceInfo, request);
		
		
		return "redirect:/place/list";
	}
}
