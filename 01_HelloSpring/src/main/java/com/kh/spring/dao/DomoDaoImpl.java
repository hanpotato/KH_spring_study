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

	@Override
	public Dev selectOne(Dev dev) {
		return session.selectOne("dev.selectOne",dev);
	}

	@Override
	public int update(Dev dev) {
		return session.update("dev.update",dev);
	}

	@Override
	public int delete(Dev dev) {
		return session.delete("dev.delete",dev);
	}

}
