package com.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dao.MemberDao;
import com.kh.spring.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {


	@Autowired
	private MemberDao dao;	
	
	@Override
	public int insertMember(Member m) {
		return dao.insertMember(m);
	}

	@Override
	public Member selectOne(Member m) {
		return dao.selectOne(m);
	}

}
