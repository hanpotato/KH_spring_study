package com.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dao.DomoDao;

@Service
public class DomoServiceImpl implements DomoService {

	@Autowired
	private DomoDao dao;
	
	@Override
	public void print() {
		System.out.println("Service");
		dao.print();
		
	}

}
