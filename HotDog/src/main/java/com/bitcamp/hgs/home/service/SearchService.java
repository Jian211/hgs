package com.bitcamp.hgs.home.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.hgs.home.dao.HomeBoardDao;
import com.bitcamp.hgs.home.dao.HomePlacesDao;
import com.bitcamp.hgs.home.domain.AllTableList;
import com.bitcamp.hgs.home.domain.HomeBoard;
import com.bitcamp.hgs.home.domain.HomeSelectCafe;
import com.bitcamp.hgs.home.domain.HomeSelectHospital;
import com.bitcamp.hgs.home.domain.HomeSelectPark;
import com.bitcamp.hgs.home.domain.HomeSelectPlace;
import com.bitcamp.hgs.member.domain.Logger;

@Service
public class SearchService {

	SqlSessionTemplate template;

	SearchService(SqlSessionTemplate template){
		this.template = template;
	}
	
	// 검색 결과를 반환
	public String selectAllTable(String q, HttpSession session, Model model) {
		Logger logger = (Logger)session.getAttribute("logger");
		
		List<HomeSelectHospital> homeHospital = new ArrayList<HomeSelectHospital>();
		List<HomeSelectCafe> homeCafe 		  = new ArrayList<HomeSelectCafe>();
		List<HomeSelectPark> homePark 		  = new ArrayList<HomeSelectPark>();

		List<HomeBoard> homeBoard = template.getMapper(HomeBoardDao.class).selectSearchBoardList(q);
		List<HomeSelectPlace> homeSelectPlace = template.getMapper(HomePlacesDao.class).selectHomePlaceList(q,logger.getMemberIdx());
		
		for (int i = 0; i < homeSelectPlace.size(); i++) {
			HomeSelectPlace hsp = homeSelectPlace.get(i);
			String ctgy = hsp.getSubjectCategory();
			if(ctgy.equals("애견카페"))		homeCafe.add(hsp.getCafe());
			else if(ctgy.equals("동물병원")) 	homeHospital.add(hsp.getHospital());
			else if(ctgy.equals("공원")) 		homePark.add(hsp.getPark());
		}
		
		AllTableList allTable = new AllTableList();
		allTable.setHomeBoard(homeBoard);
		allTable.setHomeCafe(homeCafe);
		allTable.setHomeHospital(homeHospital);
		allTable.setHomePark(homePark);
		model.addAttribute("allPlaces", allTable);
		return "home/search";
	}
	
	
}
