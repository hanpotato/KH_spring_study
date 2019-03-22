package com.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSessionTemplate session;

	@Override
	public int selectCount() {
		return session.selectOne("board.selectCount");
	}

	@Override
	public List<Board> selectList(int cPage, int numPerPage) {
		RowBounds row = new RowBounds((cPage-1)*numPerPage, numPerPage);
		return session.selectList("board.selectList",null,row);
	}

	@Override
	public int insertBoard(Board b) {
		return session.insert("board.insertBoard",b);
	}

	@Override
	public int insertAttachment(Attachment a) {
		return session.insert("board.insertAttachment",a);
	}

	@Override
	public Board selectBoard(int boardNo) {
		return session.selectOne("board.selectBoard", boardNo);
	}

	@Override
	public List<Attachment> selectAttachment(int boardNo) {
		return session.selectList("board.selectAttachment",boardNo);
	}
	
}
