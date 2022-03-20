package com.bitcamp.hgs.home.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.dao.HomeBoardDao;
import com.bitcamp.hgs.home.dao.HomePlacesDao;
import com.bitcamp.hgs.home.domain.AllTableList;
import com.bitcamp.hgs.home.domain.HomeBoard;
import com.bitcamp.hgs.home.domain.HomeSelectCafe;
import com.bitcamp.hgs.home.domain.HomeSelectHospital;
import com.bitcamp.hgs.home.domain.HomeSelectPark;
import com.bitcamp.hgs.home.domain.HomeSelectPlace;

@Service
public class SearchService {

	SqlSessionTemplate template;

	SearchService(SqlSessionTemplate template){
		this.template = template;
	}
	
	// 검색 결과를 반환
	public AllTableList selectAllTable(String q, int memberIdx) {
		List<HomeSelectCafe> homeCafe = new ArrayList<HomeSelectCafe>();
		List<HomeSelectPark> homePark = new ArrayList<HomeSelectPark>();
		List<HomeSelectHospital> homeHospital = new ArrayList<HomeSelectHospital>();

		List<HomeBoard> homeBoard = template.getMapper(HomeBoardDao.class).selectSearchBoardList(q);
		List<HomeSelectPlace> homeSelectPlace = template.getMapper(HomePlacesDao.class).selectHomePlaceList(q,memberIdx);
		
		for (int i = 0; i < homeSelectPlace.size(); i++) {
			HomeSelectPlace hsp = homeSelectPlace.get(i);
			String ctgy = hsp.getSubjectCategory();
			if(ctgy.equals("애견카페"))		homeCafe.add(hsp.getCafe());
			else if(ctgy.equals("동물병원")) 	homeHospital.add(hsp.getHospital());
			else if(ctgy.equals("공원")) 	homePark.add(hsp.getPark());
		}
		
		AllTableList allTable = new AllTableList();
		allTable.setHomeBoard(homeBoard);
		allTable.setHomeCafe(homeCafe);
		allTable.setHomeHospital(homeHospital);
		allTable.setHomePark(homePark);
		return allTable;
	}
	
	
}
