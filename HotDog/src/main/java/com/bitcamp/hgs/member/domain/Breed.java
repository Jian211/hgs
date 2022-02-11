package com.bitcamp.hgs.member.domain;

public class Breed {
	
	private int breedIdx;
	private String dogType;
	
	public Breed() {	}

	public Breed(int breedInd, String dogType) {
		this.breedIdx = breedInd;
		this.dogType = dogType;
	}

	public int getBreedInd() {
		return breedIdx;
	}

	public String getDogType() {
		return dogType;
	}

	@Override
	public String toString() {
		return "Breed [breedInd=" + breedIdx + ", dogType=" + dogType + "]";
	}

	
	
}
