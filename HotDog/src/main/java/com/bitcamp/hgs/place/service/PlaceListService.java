package com.bitcamp.hgs.place.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.hgs.place.dao.PlaceDao;
import com.bitcamp.hgs.place.domain.PlaceListView;
import com.bitcamp.hgs.place.domain.RegPlace;

@Service
public class PlaceListService {

	private PlaceDao dao;

	@Autowired
	private SqlSessionTemplate template;

	// 페이지 당 표현할 추천 게시물 개수
	private final int COUNT_PER_PAGE = 6;

	// 페이징 번호 노출 개수
	private final int COUNT_PER_PAGING_NUM = 5;

	public PlaceListView getPage(int currentPage) {

		dao = template.getMapper(PlaceDao.class);

		// 전체 회원 수
		int totalCount = dao.selectTotalCount();

		int index = (currentPage - 1) * COUNT_PER_PAGE;
		// 화면에 노출할 메시지
		List<RegPlace> list = dao.selectList(index, COUNT_PER_PAGE);
	

		return new PlaceListView(currentPage, COUNT_PER_PAGE, COUNT_PER_PAGING_NUM, list, totalCount);

	}
}
