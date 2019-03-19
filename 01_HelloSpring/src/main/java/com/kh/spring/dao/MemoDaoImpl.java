package com.kh.spring.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemoDaoImpl implements MemoDao {
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Override
	public int insertMemo(Map<String, String> map) {
		return session.insert("memo.insertMemo",map);
	}

	@Override
	public List<Map<String, String>> selectMemo() {
		return session.selectList("memo.selectMemo");
	}

}
