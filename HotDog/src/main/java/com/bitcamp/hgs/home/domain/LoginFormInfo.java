package com.bitcamp.hgs.home.domain;

public class LoginFormInfo {
	private String email;
	private String password;
	private String saveEmail;

	public LoginFormInfo() {}

	public LoginFormInfo(String email, String password, String saveEmail) {
		this.email = email;
		this.password = password;
		this.saveEmail = saveEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSaveEmail() {
		return saveEmail;
	}

	public void setSaveEmail(String saveEmail) {
		this.saveEmail = saveEmail;
	}

	@Override
	public String toString() {
		return "LoginFormInfo [email=" + email + ", password=" + password + ", saveEmail=" + saveEmail + "]";
	}
	
	
	
	
}
