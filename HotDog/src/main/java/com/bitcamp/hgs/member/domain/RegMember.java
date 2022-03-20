package com.bitcamp.hgs.member.domain;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartFile;

public class RegMember {
	
	private String email;
	private String password;
	private String name;
	private String petNumber;
	private MultipartFile profile;
	private String address;
	private String birthday;
	private String sex;
	private String neutering;
	private String breedIdx;
	private String snsId;
	private String snsType;
	private ArrayList<String> hashtagIdx;

	public RegMember() {}

	public RegMember(String email, String password, String name, String petNumber, MultipartFile profile,
			String address, String birthday, String sex, String neutering, String breedIdx, String snsId,
			String snsType, ArrayList<String> hashtagIdx) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.petNumber = petNumber;
		this.profile = profile;
		this.address = address;
		this.birthday = birthday;
		this.sex = sex;
		this.neutering = neutering;
		this.breedIdx = breedIdx;
		this.snsId = snsId;
		this.snsType = snsType;
		this.hashtagIdx = hashtagIdx;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPetNumber() {
		return petNumber;
	}

	public void setPetNumber(String petNumber) {
		this.petNumber = petNumber;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNeutering() {
		return neutering;
	}

	public void setNeutering(String neutering) {
		this.neutering = neutering;
	}

	public String getBreedIdx() {
		return breedIdx;
	}

	public void setBreedIdx(String breedIdx) {
		this.breedIdx = breedIdx;
	}

	public String getSnsId() {
		return snsId;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public String getSnsType() {
		return snsType;
	}

	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}

	public ArrayList<String> getHashtagIdx() {
		return hashtagIdx;
	}

	public void setHashtagIdx(ArrayList<String> hashtagIdx) {
		this.hashtagIdx = hashtagIdx;
	}

	@Override
	public String toString() {
		return "RegMember [email=" + email + ", password=" + password + ", name=" + name + ", petNumber=" + petNumber
				+ ", profile=" + profile + ", address=" + address + ", birthday=" + birthday + ", sex=" + sex
				+ ", neutering=" + neutering + ", breedIdx=" + breedIdx + ", snsId=" + snsId + ", snsType=" + snsType
				+ ", hashtagIdx=" + hashtagIdx + "]";
	}
	
	
	
}
