package com.bitcamp.hgs.place.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.place.dao.PlaceReplyDao;
import com.bitcamp.hgs.place.domain.PlaceReplys;

@Service
public class PlaceReplyRegService {

	private PlaceReplyDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void insertReply(PlaceReplys replys) {
		
		dao = template.getMapper(PlaceReplyDao.class);
		
		System.out.println(replys);
		
		dao.insertReply(replys);
	}
}
