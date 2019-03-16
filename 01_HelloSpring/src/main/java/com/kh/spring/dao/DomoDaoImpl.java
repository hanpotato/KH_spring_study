package com.kh.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.vo.Dev;
import com.kh.spring.model.vo.Member;

@Repository
public class DomoDaoImpl implements DomoDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public void print() {
		System.out.println("DAO");
		
	}

	@Override
	public int insert(Dev dev) {
		return session.insert("dev.insert",dev);
	}

	@Override
	public Dev domo5() {
		return session.selectOne("dev.selectNo");
	}

	@Override
	public List<Dev> selectList() {
		return session.selectList("dev.selectList");
	}

}
