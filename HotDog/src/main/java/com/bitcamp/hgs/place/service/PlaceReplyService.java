package com.bitcamp.hgs.place.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.place.dao.PlaceReplyDao;
import com.bitcamp.hgs.place.domain.PlaceReplys;

@Service
public class PlaceReplyService {

	private PlaceReplyDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 후기 목록보기
	public List<PlaceReplys> getList(int placeIdx) {
		
		
		
		return template.getMapper(PlaceReplyDao.class).getList(placeIdx);
	}

	// 후기 등록
	public void registReply(PlaceReplys reply) {

		dao = template.getMapper(PlaceReplyDao.class);

		dao.registReply(reply);

	}

	// 후기 삭제
	public int deleteReply(int placeReplyIdx) {

		return template.getMapper(PlaceReplyDao.class).deleteReply(placeReplyIdx);
	}

	// 후기 수정
	//public int updateReply(PlaceReplys reply) {

		//dao = template.getMapper(PlaceReplyDao.class);

		//return dao.updateReply(reply);
	//}
}
