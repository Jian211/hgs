package com.example.demo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class MemberRegRequest {
	
	private int idx;
	private String userid;
	private String pw;
	private String username;
	private MultipartFile photo;
	private String fileName;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public MemberRegRequest() {};
	public MemberRegRequest(String userid, String pw, String username, MultipartFile photo, String fileName) {
		this.userid = userid;
		this.pw = pw;
		this.username = username;
		this.photo = photo;
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "MemberRegRequest [userid=" + userid + ", pw=" + pw + ", username=" + username + ", photo=" + photo
				+ ", fileName=" + fileName + "]";
	}

	
	
	
}
