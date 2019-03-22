package com.kh.spring.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.common.PageBarFactory;
import com.kh.spring.model.vo.Attachment;
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
	public ModelAndView insertBoard(Board board, MultipartFile[] upFile, HttpServletRequest re) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println(board);
		System.out.println(upFile[0].getOriginalFilename());
		System.out.println(upFile[1].getOriginalFilename());
		
		String saveDir = re.getSession().getServletContext().getRealPath("/resources/upload");
		
		File dir = new File(saveDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		/*
		//단일 파일 받을때..
		if(!upFile.isEmpty()) {
			String oriFileName = upFile.getOriginalFilename();
			String ext = oriFileName.substring(oriFileName.indexOf("."));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HHmmssSSS");
			int rndNum = (int)(Math.random()*1000);
			String reNamedFile = sdf.format(new Date(System.currentTimeMillis())) + "_" + rndNum+ext;
			try {
				upFile.transferTo(new File(saveDir+"/"+reNameFile));
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
		//복수파일 받을때..
		List<Attachment> list = new ArrayList();
		for(MultipartFile f : upFile) {
			if(!f.isEmpty()) {
				String oriFileName = f.getOriginalFilename();
				String ext = oriFileName.substring(oriFileName.indexOf("."));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
				int rndNum = (int)(Math.random()*10000);
				String reNamedFile = sdf.format(new Date(System.currentTimeMillis())) + "_" + rndNum+ext;
				try {
					f.transferTo(new File(saveDir+"/"+reNamedFile));
				}
				catch(IOException e) {
					e.printStackTrace();
				}
				
				Attachment a = new Attachment();
				a.setOriginalFileName(oriFileName);
				a.setRenamedFileName(reNamedFile);
				list.add(a);

				//list.add(new Attachment(0,0,oriFileName,reNamedFile,null,0,null));
			}
		}
		
		int result = service.insertBoard(board,list);
		
		mv.setViewName("common/msg");
		return mv;
	}

	@RequestMapping("/board/boardView.do")
	public ModelAndView selectOne(
			@RequestParam(value="boardNo", defaultValue="1") int boardNo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", service.selectBoard(boardNo));
		mv.addObject("attachmentList", service.selectAttachment(boardNo));
		mv.setViewName("board/boardView");
		return mv;
	}
	
	@RequestMapping("/board/boardDown.do")
	public void fileDown(String oName, String rName, HttpServletRequest request, HttpServletResponse response) {
		BufferedInputStream bis = null;
		ServletOutputStream sos = null;
		
		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload");
		try {
			FileInputStream fis = new FileInputStream(new File(saveDir+"/"+rName));
			bis = new BufferedInputStream(fis);
			sos = response.getOutputStream();
			String resFilename = "";
			boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1
					|| request.getHeader("user-agent").indexOf("Trident") != -1;
			if(isMSIE) {
				resFilename = URLEncoder.encode(oName, "UTF-8");
				resFilename = resFilename.replaceAll("\\+", "%20");
			}
			else {
				resFilename = new String(oName.getBytes("UTF-8"),"ISO-8859-1");
			}
			
			response.setContentType("application/octet-stream;charset=UTF-8");
			response.addHeader("Content-Disposition","attachment;filename=\""+resFilename+"\"");
			
			int read = 0;
			
			while((read=bis.read()) != -1) {
				sos.write(read);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bis.close();
				sos.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
