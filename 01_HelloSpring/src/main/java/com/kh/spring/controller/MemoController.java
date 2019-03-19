package com.kh.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.service.MemoService;

@Controller
public class MemoController {
	
	@Autowired
	private MemoService service;
	
	@RequestMapping("/memo/memo.do")
	public String memo(Model model) {
		List<Map<String,String>> list = service.selectMemo();
		model.addAttribute("list", list);
		return "memo/memo";
	}
	
	@RequestMapping("/memo/insertMemo.do")
	public String insertMemo(String memo, String password) {
		Map<String,String> map = new HashMap();
		map.put("memo", memo);
		map.put("password", password);
		service.insertMemo(map);
		return "redirect:/memo/memo.do";
	}
}
