package com.kh.spring.service;

import com.kh.spring.model.vo.Member;

public interface MemberService {
	
	int insertMember(Member m);
	Member selectOne(Member m);

}
