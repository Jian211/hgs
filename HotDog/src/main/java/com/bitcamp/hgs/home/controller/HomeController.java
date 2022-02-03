package com.bitcamp.hgs.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String login() {
		return "home/loginForm";
	}
	
	
}
