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
	
	
	// Mypage
	@GetMapping("/{idx}")
	public String getMember(@PathVariable("idx") int memberIdx, Model model) {
		return service.getMember(memberIdx, model);
	}
	
	// Member Insert
	@PostMapping
	public void joinMember(RegMember regMember, HttpServletRequest request) throws IllegalStateException, IOException {
		service.insertMember(regMember, request);
	}
	
	// SNS Member Insert
	@PostMapping("/oauth/member")
	public void joinOauthMember(RegMember regMember, HttpServletRequest request) throws IllegalStateException, IOException {
		service.insertMember(regMember, request);
	}
	
	// Member Edit :: putMapping or patchMapping으로 해보고 싶었지만, 서치해본 결과 버그라고 하든디..
	@PostMapping("/{idx}") 
	public void editMember(PutMember putMember,HttpSession session, @PathVariable("idx") int memberIdx, HttpServletRequest request) { 
		service.editMember(putMember,memberIdx,request);
	}
	
	// Member Delete
	@DeleteMapping("/{idx}") 
	public String deleteMember(@PathVariable("idx") int memberIdx, HttpSession session) {
		return service.deleteMember(memberIdx, session);
	}
	
}
