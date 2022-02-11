package com.bitcamp.hgs.member.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.member.service.BreedService;

@RestController
@RequestMapping("/join/breed")
public class BreedController {
	
	@Autowired
	BreedService breedService;
	
	// ajax를 통해, 유저의 값을 받아 관련 강아지 정보를 리스트로 전달
	@GetMapping
	public ArrayList<String> searchDogType( @RequestParam("word") String word) {
		return breedService.getDogTypeList(word);
	}
	
	@PostMapping
	public int isDogTypeExist( @RequestParam("dogType") String dogType) {
		return breedService.isDogTypeExist(dogType);
	}
	
	
}
