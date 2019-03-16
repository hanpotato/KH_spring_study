package com.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dao.DomoDao;
import com.kh.spring.model.vo.Dev;
import com.kh.spring.model.vo.Member;

@Service
public class DomoServiceImpl implements DomoService {

	@Autowired
	private DomoDao dao;	
	
	@Override
	public void print() {
		System.out.println("Service");
		dao.print();
		
	}

	@Override
	public int insert(Dev dev) {
		return dao.insert(dev);
	}

	@Override
	public Dev domo5() {
		return dao.domo5();
	}

	@Override
	public List<Dev> selectList() {
		return dao.selectList();
	}

}
