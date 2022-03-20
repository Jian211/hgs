package com.bitcamp.hgs.member.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.member.domain.Breed;
import com.bitcamp.hgs.member.service.BreedService;

@RestController
@RequestMapping("/join/breed")
public class BreedController {
	
	@Autowired
	BreedService breedService;
	
	@GetMapping
	public ArrayList<Breed> searchDogType() {
		return breedService.getDogTypeList();
	}
	
	@PostMapping
	public int isDogTypeExist( @RequestParam("dogType") String dogType) {
		return breedService.isDogTypeExist(dogType);
	}
	
	
}
