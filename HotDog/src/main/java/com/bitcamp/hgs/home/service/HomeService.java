package com.bitcamp.hgs.home.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.hgs.home.dao.HomeBoardDao;
import com.bitcamp.hgs.home.dao.HomePlacesDao;
import com.bitcamp.hgs.home.domain.HomePlaceScrap;
import com.bitcamp.hgs.home.domain.HomePlaces;
import com.bitcamp.hgs.member.domain.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class HomeService {

	SqlSessionTemplate template;
	
	HomeService (SqlSessionTemplate template){
		this.template = template;
	}
	
	// Home Data Setting
	public String getHomeContent(Model model, HttpSession session) {
		Logger logger = (Logger)session.getAttribute("logger");
		System.out.println("Logger = "+ logger );
		
		// Get scrap info of Member in DB
		List<HomePlaceScrap> scraps = template.getMapper(HomePlacesDao.class).selectScraps(logger.getMemberIdx());
		
		if( scraps != null ) {
			Gson gson = new GsonBuilder().create();
			String scrapsJson = gson.toJson(scraps);
			System.out.println("scrapsJson = " + scrapsJson);
			model.addAttribute("scraps", scrapsJson);
		} 
		
		/* 	로거의 해시태그 값을 기준	*/
		model.addAttribute("HomeBoard", template.getMapper(HomeBoardDao.class).selectHomeBoardList(logger.getHashtags()));
		
		
		/* 유저 근처의 장소들 랜덤으로 갖고오기 */
		List<HomePlaces> places = template.getMapper(HomePlacesDao.class).selectAllPlacesIdx(logger.getMemberIdx());
		if(places.size() < 1) {
			places = template.getMapper(HomePlacesDao.class).selectAllPlaces();
			System.out.println("places = "+ places);
		}
		model.addAttribute("HomePlace", places);

		return "home/home";
	}

	
}
