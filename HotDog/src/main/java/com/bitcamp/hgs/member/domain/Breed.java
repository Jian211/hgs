package com.bitcamp.hgs.member.domain;

public class Breed {
	
	private int breedIdx;
	private String dogType;
	
	public Breed() {	}

	public Breed(int breedIdx, String dogType) {
		this.breedIdx = breedIdx;
		this.dogType = dogType;
	}

	public int getBreedIdx() {
		return breedIdx;
	}

	public String getDogType() {
		return dogType;
	}

	@Override
	public String toString() {
		return "Breed [breedIdx=" + breedIdx + ", dogType=" + dogType + "]";
	}

	
	
}
