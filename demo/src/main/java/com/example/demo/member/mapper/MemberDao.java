package com.example.demo.member.mapper;

import java.util.List;
import java.util.Map;

import com.example.demo.member.domain.EditRequest;
import com.example.demo.member.domain.Member;
import com.example.demo.member.domain.Member2;
import com.example.demo.member.domain.MemberRegRequest;
import com.example.demo.member.domain.SearchParams;

public interface MemberDao {

	// public Member selectByIdPw(LoginParams prams);
	public Member selectByIdPw(String uid, String pw);
	/* selectByIdPw("cool", "123"); */

	public Member selectById(String uid);

	// public int selectTotalCount();
	public int selectTotalCount(Map<String, String> params);

	public List<Member> selectList(SearchParams params);
	// public List<Member> selectList(int count, int index);

	public int insertMember(MemberRegRequest regRequest);

	public Member selectByIdx(int idx);

	public Member2 selectByIdx2(int idx);

	public int deleteByIdx(int memberIdx);

	public int editMember(EditRequest editRequest);

	public int selectCountByUesrId(String userId);
}