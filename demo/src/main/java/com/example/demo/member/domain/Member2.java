package com.example.demo.member.domain;

public class Member2 {

	private int index;
	private String memberid;
	private String pw;
	private String membername;
	private String memberphoto;
	private String date;

	public LoginInfo getLoginInfo() {
		return new LoginInfo(index, memberid, membername, memberphoto);
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberphoto() {
		return memberphoto;
	}

	public void setMemberphoto(String memberphoto) {
		this.memberphoto = memberphoto;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Member2 [index=" + index + ", memberid=" + memberid + ", pw=" + pw + ", membername=" + membername
				+ ", memberphoto=" + memberphoto + ", date=" + date + "]";
	}
	
	

}
