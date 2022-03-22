package com.bitcamp.hgs.home.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bitcamp.hgs.home.dao.BreedDao;
import com.bitcamp.hgs.home.domain.Breed;

@Service
public class BreedService {

	@Autowired
	private SqlSessionTemplate template;
	
	public ArrayList<Breed> getDogTypeList() {
		return (ArrayList<Breed>) template.getMapper(BreedDao.class).selectDogTypeList();
	}

	public String getDogTypeList(Model model) {
		model.addAttribute("breedList", (ArrayList<Breed>) template.getMapper(BreedDao.class).selectDogTypeList());
		return "home/join";
	}
	
	// 유저로부터 완성된 dogType이 DB에 존재하는지 확인.
	public int isDogTypeExist(String dogType) {
		return template.getMapper(BreedDao.class).selectDogType(dogType);
	}

}
