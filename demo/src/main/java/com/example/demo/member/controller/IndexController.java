package com.example.demo.member.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.member.domain.Member;
import com.example.demo.member.mapper.MemberDao;

@Controller
public class IndexController {
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	@RequestMapping("/")
	@ResponseBody
	public String getIndex() {
		return "index";
	}
	
	
	@RequestMapping("/members")
	@ResponseBody
	public String getList( Model model){
		
		model.addAttribute("list", template.getMapper(MemberDao.class).selectList(null));
		
		return "member/list";
	}
	
}
