package com.kh.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring.service.DomoService;

@Controller
public class DomoController {
	
	@Autowired
	/*@Qualifier("choice")*/ //servlet-context.xml 에서 선언하게 될때...
	private DomoService service;
	
	/*
	@RequestMapping("/domo/domo.do")
	public void test() {
		System.out.println("Controller");
		service.print();
	}
	*/
	
	@RequestMapping("/domo/domo.do")
	public String String() {
		return "domo/domo";
	}
}
