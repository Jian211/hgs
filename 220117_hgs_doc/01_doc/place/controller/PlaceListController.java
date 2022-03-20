package com.bitcamp.hgs.place.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.hgs.place.service.PlaceListService;

@Controller
public class PlaceListController {
	
	@Autowired
	private PlaceListService listService;
	
	@RequestMapping("/place/list")
	public void getListPage(
			@RequestParam(value = "p", defaultValue = "1") int pageNum,
			Model model) throws SQLException{
		
		 model.addAttribute("listView", listService.getPage(pageNum));
		
	}
	
}
