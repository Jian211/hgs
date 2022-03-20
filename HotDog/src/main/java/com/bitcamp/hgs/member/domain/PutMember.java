package com.bitcamp.hgs.member.domain;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PutMember {
	private String name;
	private MultipartFile profile;
	private Date birthday;
	private int sex;
	private int petNumber;
	private int neutering;
	private String address;
	private int breedIdx;
	private List<Integer> hashtags;

	public PutMember() {	}

	public PutMember(String name, MultipartFile profile, Date birthday, int sex, int petNumber,
			int neutering, String address, int breedIdx, List<Integer> hashtags) {
		this.name = name;
		this.profile = profile;
		this.birthday = birthday;
		this.sex = sex;
		this.petNumber = petNumber;
		this.neutering = neutering;
		this.address = address;
		this.breedIdx = breedIdx;
		this.hashtags = hashtags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getProfile() {
		return profile;
	}

	public void setProfile(MultipartFile profile) {
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

	public int getPetNumber() {
		return petNumber;
	}

	public void setPetNumber(int petNumber) {
		this.petNumber = petNumber;
	}

	public int getNeutering() {
		return neutering;
	}

	public void setNeutering(int neutering) {
		this.neutering = neutering;
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

	public List<Integer> getHashtags() {
		return hashtags;
	}

	public void setHashtags(List<Integer> hashtags) {
		this.hashtags = hashtags;
	}

	@Override
	public String toString() {
		return "PutMember [name=" + name + ", profile=" + profile + ", birthday=" + birthday
				+ ", sex=" + sex + ", petNumber=" + petNumber + ", neutering=" + neutering + ", address=" + address
				+ ", breedIdx=" + breedIdx + ", hashtags=" + hashtags + "]";
	}
	
	public UpdatePutMember getUpdatePutMember() {
		return new UpdatePutMember(0, name, null, birthday, sex, petNumber, neutering, address, breedIdx);
	}
	
}
