package com.example.demo.member.domain;

import org.springframework.web.multipart.MultipartFile;

public class EditRequest {

	private int idx;
	private String userid;
	private String pw;
	private String username;
	private String oldfile;
	private MultipartFile photo;
	private String fileName;

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

	public String getOldfile() {
		return oldfile;
	}

	public void setOldfile(String oldfile) {
		this.oldfile = oldfile;
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

	@Override
	public String toString() {
		return "EditRequest [idx=" + idx + ", userid=" + userid + ", pw=" + pw + ", username=" + username + ", oldfile="
				+ oldfile + ", photo=" + photo.getOriginalFilename() + "]";
	}

}