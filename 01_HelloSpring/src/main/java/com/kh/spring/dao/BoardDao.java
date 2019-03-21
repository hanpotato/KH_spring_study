package com.kh.spring.dao;

import java.util.List;

import com.kh.spring.model.vo.Board;

public interface BoardDao {

	int selectCount();
	List<Board> selectList(int cPage, int numPerPage);

}
