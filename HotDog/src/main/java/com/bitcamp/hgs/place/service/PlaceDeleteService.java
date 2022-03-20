package com.bitcamp.hgs.place.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.place.dao.PlaceDao;

@Service
public class PlaceDeleteService {

	private PlaceDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public void deletePlace(int placeIdx) {
		
		dao = template.getMapper(PlaceDao.class);
		
		dao.deletePlace(placeIdx);
		
	}

}
