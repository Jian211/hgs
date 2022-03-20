package com.bitcamp.hgs.home.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.dao.HomePlacesDao;
import com.bitcamp.hgs.home.domain.HomePlace;
import com.bitcamp.hgs.home.domain.HomePlaceScrap;
import com.bitcamp.hgs.home.domain.HomePlaces;
import com.bitcamp.hgs.place.dao.PlaceDao;

@Service
public class HomePlaceService {
	
	private SqlSessionTemplate template;

	HomePlaceService(SqlSessionTemplate template){
		this.template = template;
	}

	// 이름, idx, 위도 경도
	public List<HomePlaceScrap> selectScraps(int memberIdx) {
		// 위치 주변의 카페, 공원, 병원, 정보를 수집 
		// 리스트 안에 카페 리스트, 공원리스트, 병원리스트, 
		return template.getMapper(HomePlacesDao.class).selectScraps(memberIdx);
	};
	
	
	// 현재 접속한 위치(주소), 주변 카페,병원,공원 리스트 전달
	public List<HomePlace> selectPlaces(String address){
		System.out.println("address = " + address);
		return template.getMapper(HomePlacesDao.class).selectPlaces(address);
	}

	// 주변 가게 리스트 검색
	public List<HomePlaces> selectPlaces(int memberIdx) {
		List<HomePlaces> places = template.getMapper(HomePlacesDao.class).selectAllPlacesIdx(memberIdx);
		if(places.size() < 1) {
			places = template.getMapper(HomePlacesDao.class).selectAllPlaces();
			System.out.println("places = "+ places);
		}
		return places;
	}
	
	
}
