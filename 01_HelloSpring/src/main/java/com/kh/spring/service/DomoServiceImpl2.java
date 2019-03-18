package com.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dao.DomoDao;

/*@Service*/ //servlet-context.xml에 등록이 되면 어노테이션으로 선언한 걸 없애도 유지가 된다.
/*
public class DomoServiceImpl2 implements DomoService {

	@Autowired
	private DomoDao dao;
	
	@Override
	public void print() {
		System.out.println("Service2");
		dao.print();
		
	}

}
*/