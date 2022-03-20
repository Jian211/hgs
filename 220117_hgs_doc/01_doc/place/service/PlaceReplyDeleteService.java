package com.bitcamp.hgs.place.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.place.dao.PlaceReplyDao;

@Service
public class PlaceReplyDeleteService {
	
	private PlaceReplyDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	public int deleteReply(int idx) {
		return template.getMapper(PlaceReplyDao.class).deleteByIdx(idx);
		}
}
