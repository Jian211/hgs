package com.bitcamp.hgs.member.domain;


public class InsertMember {
	private int memberIdx;
	private String email;
	private String password;
	private String name;
	private String petNumber;
	private String profile;
	private String address;
	private String birthday;
	private int sex;
	private int neutering;
	private int breedIdx;
	private String snsId;
	private int snsType;
	
	public InsertMember() {	}

	public InsertMember(String email, String password, String name, String petNumber, String profile,
			String address, String birthday, int sex, int neutering, int breedIdx, String snsId, int snsType) {
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
	}
	
	public InsertMember(int memberIdx, String email, String password, String name, String petNumber, String profile,
			String address, String birthday, int sex, int neutering, int breedIdx, String snsId, int snsType) {
		this.memberIdx = memberIdx;
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

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
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

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getNeutering() {
		return neutering;
	}

	public void setNeutering(int neutering) {
		this.neutering = neutering;
	}

	public int getBreedIdx() {
		return breedIdx;
	}

	public void setBreedIdx(int breedIdx) {
		this.breedIdx = breedIdx;
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

	@Override
	public String toString() {
		return "InsertMember [memberIdx=" + memberIdx + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", petNumber=" + petNumber + ", profile=" + profile + ", address=" + address + ", birthday="
				+ birthday + ", sex=" + sex + ", neutering=" + neutering + ", breedIdx=" + breedIdx + ", snsId=" + snsId
				+ ", snsType=" + snsType + "]";
	}

	


	
}
