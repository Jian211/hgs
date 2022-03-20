package com.bitcamp.hgs.home.domain;

import java.util.List;


// 병원, 카페, 공원, 게시글 기준으로 잡았다.
public class AllTableList {
	private List<HomeBoard> homeBoard;	
	private List<HomeSelectCafe> homeCafe;
	private List<HomeSelectHospital> homeHospital;
	private List<HomeSelectPark> homePark;

	public AllTableList() {}

	public AllTableList(List<HomeBoard> homeBoard, List<HomeSelectCafe> homeCafe, List<HomeSelectHospital> homeHospital,List<HomeSelectPark> homePark) {
		this.homeBoard = homeBoard;
		this.homeCafe = homeCafe;
		this.homeHospital = homeHospital;
		this.homePark = homePark;
	}

	public List<HomeBoard> getHomeBoard() {
		return homeBoard;
	}

	public void setHomeBoard(List<HomeBoard> homeBoard) {
		this.homeBoard = homeBoard;
	}

	public List<HomeSelectCafe> getHomeCafe() {
		return homeCafe;
	}

	public void setHomeCafe(List<HomeSelectCafe> homeCafe) {
		this.homeCafe = homeCafe;
	}

	public List<HomeSelectHospital> getHomeHospital() {
		return homeHospital;
	}

	public void setHomeHospital(List<HomeSelectHospital> homeHospital) {
		this.homeHospital = homeHospital;
	}

	public List<HomeSelectPark> getHomePark() {
		return homePark;
	}

	public void setHomePark(List<HomeSelectPark> homePark) {
		this.homePark = homePark;
	}

	@Override
	public String toString() {
		return "AllTableList [homeBoard=" + homeBoard + ", homeCafe=" + homeCafe + ", homeHospital=" + homeHospital
				+ ", homePark=" + homePark + "]";
	}

	
	
	

}
