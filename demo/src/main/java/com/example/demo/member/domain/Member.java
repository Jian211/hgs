package com.example.demo.member.domain;

public class Member {

	private int idx;
	private String userid;
	private String password;
	private String username;
	private String regdate;
	private String photo;
	
	public Member () {};
	
	public Member(int idx, String userid, String password, String username, String regdate, String photo) {
		this.idx = idx;
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.regdate = regdate;
		this.photo = photo;
	}

	public LoginInfo getLoginInfo() {
		return new LoginInfo(idx, userid, username, photo);
	}

	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
}
