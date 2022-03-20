package com.bitcamp.hgs.home.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.home.dao.HomeBoardDao;
import com.bitcamp.hgs.home.domain.HomeBoard;
import com.bitcamp.hgs.member.domain.Hashtag;

@Service
public class HomeBoardService {
	
	SqlSessionTemplate template;
	
	HomeBoardService(SqlSessionTemplate template){
		this.template = template;
	}
	
	
	// 홈에 표시할 보드 리스트 갖고오기
	public List<HomeBoard> selectBoardList(List<Hashtag> hashtags) {
		System.out.println("해시태그 테스트 = " + hashtags);
		return template.getMapper(HomeBoardDao.class).selectHomeBoardList(hashtags);
	}
	

}
