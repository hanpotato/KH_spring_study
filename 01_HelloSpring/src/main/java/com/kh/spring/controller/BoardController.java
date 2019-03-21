package com.kh.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.common.PageBarFactory;
import com.kh.spring.model.vo.Board;
import com.kh.spring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/board/boardForm")
	public String boardForm() {
		return "board/boardForm";
	}
	
	@RequestMapping("/board/boardList")
	public ModelAndView boardList(
			@RequestParam(value="cPage", required=false, defaultValue="1") int cPage
			) {
		
		int numPerPage = 10;
		ModelAndView mv = new ModelAndView();
		
		int totalList = service.selectCount();
		List<Board> list = service.selectList(cPage,numPerPage);
		
		mv.addObject("list", list);
		mv.addObject("totalList",totalList);
		mv.addObject("pageBar",PageBarFactory.getPageBar(totalList,cPage,numPerPage,"/spring/board/boardList"));
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
	@RequestMapping("/board/boardFormEnd.do")
	public ModelAndView insertBoard(Board board, MultipartFile upFile) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println(board);
		System.out.println(upFile.getOriginalFilename());
		
		mv.setViewName("common/msg");
		return mv;
	}
}
