package com.bitcamp.hgs.home.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.home.domain.HomePlace;
import com.bitcamp.hgs.home.service.HomePlaceService;

@RestController
@RequestMapping("/home/places")
public class PlacesController {
	
	HomePlaceService placeScrapService;

	PlacesController(HomePlaceService placeScrapService){
		this.placeScrapService = placeScrapService;
	}


	/*
	 	유저의 현재 위치 정보를 받아 주변 가게들의 정보를 
	 	list타입으로 반환
	 */
	@GetMapping
	public List<HomePlace> getPlaces(@RequestParam("address") String address) {
		System.out.println("address = " + address);
		return placeScrapService.selectPlaces(address);
	}
	
	
}
