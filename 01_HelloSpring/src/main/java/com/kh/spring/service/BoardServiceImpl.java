package com.kh.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.dao.BoardDao;
import com.kh.spring.model.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao dao;

	@Override
	public int selectCount() {
		return dao.selectCount();
	}

	@Override
	public List<Board> selectList(int cPage, int numPerPage) {
		return dao.selectList(cPage,numPerPage);
	}
	
}
