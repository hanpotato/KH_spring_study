package com.kh.spring.service;

import java.util.List;

import com.kh.spring.model.vo.Attachment;
import com.kh.spring.model.vo.Board;

public interface BoardService {

	int selectCount();
	List<Board> selectList(int cPage, int numPerPage);
	int insertBoard(Board b, List<Attachment> attachmentList);
	
	Board selectBoard(int boardNo);
	List<Attachment> selectAttachment(int boardNo);
}
