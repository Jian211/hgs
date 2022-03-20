package com.bitcamp.hgs.member.domain;

import java.sql.Date;

public class Member {
	
	private int memberIdx;
	private String email;
	private String password;
	private String petNumber;
	private String name;
	private String profile;
	private Date birthday;
	private int sex;
	private String address;
	private int breedIdx;
	private int neutering;
	private String snsId;
	private int snsType;
	private String regDate;
	private String outDate;
	private int exist;
	
	public Member() {}

	public Member(int memberIdx, String email, String password, String petNumber, String name, String profile,
			 Date birthday, int sex, String address, int breedIdx, int neutering, String snsId,
			int snsType, String regDate, String outDate, int exist) {
		this.memberIdx = memberIdx;
		this.email = email;
		this.password = password;
		this.petNumber = petNumber;
		this.name = name;
		this.profile = profile;
		this.birthday = birthday;
		this.sex = sex;
		this.address = address;
		this.breedIdx = breedIdx;
		this.neutering = neutering;
		this.snsId = snsId;
		this.snsType = snsType;
		this.regDate = regDate;
		this.outDate = outDate;
		this.exist = exist;
	}

	public int getMemberIdx() {
		return memberIdx;
	}

	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
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

	public String getPetNumber() {
		return petNumber;
	}

	public void setPetNumber(String petNumber) {
		this.petNumber = petNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}


	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBreedIdx() {
		return breedIdx;
	}

	public void setBreedIdx(int breedIdx) {
		this.breedIdx = breedIdx;
	}

	public int getNeutering() {
		return neutering;
	}

	public void setNeutering(int neutering) {
		this.neutering = neutering;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public int getSnsType() {
		return snsType;
	}

	public void setSnsType(int snsType) {
		this.snsType = snsType;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public int getExist() {
		return exist;
	}

	public void setExist(int exist) {
		this.exist = exist;
	}

	@Override
	public String toString() {
		return "Member [memberIdx=" + memberIdx + ", email=" + email + ", password=" + password + ", petNumber="
				+ petNumber + ", name=" + name + ", profile=" + profile + ", birthday="
				+ birthday + ", sex=" + sex + ", address=" + address + ", breedIdx=" + breedIdx + ", neutering="
				+ neutering + ", snsId=" + snsId + ", snsType=" + snsType + ", regDate=" + regDate + ", outDate="
				+ outDate + ", exist=" + exist + "]";
	}

	public Logger getLoggerInfo() {
		return new Logger(memberIdx, email, snsType, name, profile, null);
	}
	
}
