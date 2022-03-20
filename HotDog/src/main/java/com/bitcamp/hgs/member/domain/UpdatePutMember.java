package com.bitcamp.hgs.member.domain;

import java.sql.Date;

public class UpdatePutMember {
	private int memberIdx;
	private String name;
	private String fileName;
	private Date birthday;
	private int sex;
	private int petNumber;
	private int neutering;
	private String address;
	private int breedIdx;
	
	public UpdatePutMember() {	}
	
	public UpdatePutMember(int memberIdx, String name, String fileName, Date birthday, int sex,
			int petNumber, int neutering, String address, int breedIdx) {
		this.memberIdx = memberIdx;
		this.name = name;
		this.fileName = fileName;
		this.birthday = birthday;
		this.sex = sex;
		this.petNumber = petNumber;
		this.neutering = neutering;
		this.address = address;
		this.breedIdx = breedIdx;
	}



	public int getMemberIdx() {
		return memberIdx;
	}
	
	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	@Override
	public String toString() {
		return "UpdatePutMember [memberIdx=" + memberIdx + ", name=" + name + ", fileName="
				+ fileName + ", birthday=" + birthday + ", sex=" + sex + ", petNumber=" + petNumber + ", neutering="
				+ neutering + ", address=" + address + ", breedIdx=" + breedIdx + "]";
	}
	
	
}
