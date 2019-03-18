package com.kh.spring.service;

import java.util.List;

import com.kh.spring.model.vo.Dev;
import com.kh.spring.model.vo.Member;

public interface DomoService {

	void print();
	
	int insert(Dev dev);
	Dev domo5();
	List<Dev> selectList();
	Dev selectOne(Dev dev);
	int update(Dev dev);
	int delete(Dev dev);
}
