package com.bitcamp.hgs.place.dao;

import java.util.List;

import com.bitcamp.hgs.place.domain.PlaceReplys;

public interface PlaceReplyDao {

	// 후기의 전체 목록(추천 장소 게시물 idx기준)
	public List<PlaceReplys> getList(int placeIdx);
	
	// 후기 입력
	public void registReply(PlaceReplys reply);
	
	// 후기 삭제
	public int deleteReply(int idx);
	
	// 후기 수정
	public int updateReply(PlaceReplys reply);
	
}
