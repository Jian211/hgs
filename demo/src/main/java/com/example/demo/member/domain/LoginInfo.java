package com.example.demo.member.domain;

public class LoginInfo {
	private int idx;
	private String userId;
	private String userName;
	private String photo;
	
	public LoginInfo() {};
	public LoginInfo(int idx, String userId, String userName, String photo) {
		this.idx = idx;
		this.userId = userId;
		this.userName = userName;
		this.photo = photo;
	}

	public int getIdx() {
		return idx;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPhoto() {
		return photo;
	}
	
	
}
