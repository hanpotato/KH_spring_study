package com.kh.spring.dao;

import com.kh.spring.model.vo.Member;

public interface MemberDao {

	int insertMember(Member m);
	Member selectOne(Member m);

}
