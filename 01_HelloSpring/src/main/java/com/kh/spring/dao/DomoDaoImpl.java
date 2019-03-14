package com.kh.spring.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DomoDaoImpl implements DomoDao {

	@Override
	public void print() {
		System.out.println("DAO");
		
	}

}
