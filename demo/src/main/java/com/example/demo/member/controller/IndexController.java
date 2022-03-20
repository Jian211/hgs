package com.example.demo.member.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.member.mapper.MemberDao;

@Controller
public class IndexController {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@RequestMapping("/")
	public String getIndex() {
		return "index";
		//return "INDEX Page";
	}
	
	@RequestMapping("/members")	
	public String getList(
			Model model
			){
		
		model.addAttribute("memberList", template.getMapper(MemberDao.class).selectList(null));
		return "member/list";
		
	}

}