package com.bitcamp.hgs.member.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.bitcamp.hgs.member.domain.EditMember;
import com.bitcamp.hgs.member.domain.Hashtag;
import com.bitcamp.hgs.member.domain.InsertMember;
import com.bitcamp.hgs.member.domain.Member;
import com.bitcamp.hgs.member.domain.MemberHashtag;
import com.bitcamp.hgs.member.domain.PutMember;
import com.bitcamp.hgs.member.domain.SearchParams;
import com.bitcamp.hgs.member.domain.UpdatePutMember;

public interface MemberDao {
	
	// 유저 저장
	public void insertMemberInfo(InsertMember inserMember);
	
	// 유저가 선택한 해쉬태그 저장
	public void insertMemberHashtag(List<MemberHashtag> memberHashtagList);

	// 유저 잇는지 확인
	public Member selectMember(String email);

	// 유저의 해시태그 리스트 얻기
	public List<Hashtag> selectMemberHashtags(int memberIdx);
	
	public Member selectByIdx(int idx);

	//public int editMember(EditMember editMember);

	public int selectTotalCount(Map<String, String> params);

	public List<Member> selectList(SearchParams params);

	public Member selectByIdx2(int memberIdx);

	// 
	public int deleteByIdx(int memberIdx);

	// 유저 수정
	public int editMember(UpdatePutMember updatePutMember);

	// 유저의 해시태그 정보 삭제
	public void deleteMemberHashtags(int memberIdx);					  


}
