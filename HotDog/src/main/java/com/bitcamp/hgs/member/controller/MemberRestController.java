package com.bitcamp.hgs.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.hgs.member.domain.PutMember;
import com.bitcamp.hgs.member.domain.RegMember;
import com.bitcamp.hgs.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberRestController {
	
	private MemberService service;

	MemberRestController(MemberService service){
		this.service = service;
	}
	
	@GetMapping("/{idx}") 
	public String getMember(@PathVariable("idx") int memberIdx, Model model) {
		System.out.println("memberIdx = "+ memberIdx);
		return service.getMember(memberIdx, model);
	}
	
	@PostMapping
	public void joinMember(RegMember regMember, HttpServletRequest request) throws IllegalStateException, IOException {
		service.insertMember(regMember, request);
	}

	@PostMapping("/oauth/member") 	// SNS Member Insert
	public void joinOauthMember(RegMember regMember, HttpServletRequest request) throws IllegalStateException, IOException {
		service.insertMember(regMember, request);
	}
	
	@PostMapping("/{idx}") // Member Edit :: putMapping or patchMapping error!!!
	public void editMember(PutMember putMember,HttpSession session, @PathVariable("idx") int memberIdx, HttpServletRequest request) { 
		service.editMember(putMember,memberIdx,request);
	}
	
	@DeleteMapping("/{idx}") 
	public String deleteMember(@PathVariable("idx") int memberIdx, HttpSession session) {
		return service.deleteMember(memberIdx, session);
	}
}
