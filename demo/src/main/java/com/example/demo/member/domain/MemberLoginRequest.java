package com.example.demo.member.domain;

public class MemberLoginRequest {

	private String url;
	private String userid;
	private String password;
	private String saveid;
	
	@Override
	public String toString() {
		return "MemberLoginRequest [url=" + url + ", userid=" + userid + ", password=" + password + ", saveid=" + saveid + "]";
	}
	public MemberLoginRequest() {};
	
	public MemberLoginRequest(String url, String userid, String password, String saveid) {
		this.url = url;
		this.userid = userid;
		this.password = password;
		this.saveid = saveid;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getSaveid() {
		return saveid;
	}
	public void setSaveid(String saveid) {
		this.saveid = saveid;
	}
	public LoginParams getLoginParam() {
		return new LoginParams(this.userid, this.password);
	}
	
}
