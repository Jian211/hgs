package com.bitcamp.hgs.home.domain;

/*
 * 	회원가입 시, 사용되는 email과 SNS 타입 정보를 담는 클래스
 */

public class EmailType {

	private String email;
	private String snsType;
	
	public EmailType() {	}

	public EmailType(String email, String snsType) {
		this.email = email;
		this.snsType = snsType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSnsType() {
		return snsType;
	}

	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}

	@Override
	public String toString() {
		return "EmailType [email=" + email + ", snsType=" + snsType + "]";
	}

	
		
}
