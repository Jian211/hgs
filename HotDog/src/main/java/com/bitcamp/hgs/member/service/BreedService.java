package com.bitcamp.hgs.member.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.member.dao.BreedDao;

@Service
public class BreedService {

	@Autowired
	private SqlSessionTemplate template;
	
	// 유저로부터 받은 강아지 품종 글자를 DB에서 검색
	public ArrayList<String> getDogTypeList(String word) {
		return (ArrayList<String>) template.getMapper(BreedDao.class).selectDogTypeList(word);
	}
	
	// 유저로부터 완성된 dogType이 DB에 존재하는지 확인.
	public int isDogTypeExist(String dogType) {
		return template.getMapper(BreedDao.class).selectDogType(dogType);
	}

}
