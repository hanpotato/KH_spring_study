package com.kh.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.BoardService;
import com.kh.spring.service.MemberService;

@Controller
public class AjaxTest {

	@Autowired
	private BoardService bservice;
	
	@Autowired
	private MemberService mservice;
	
	@RequestMapping("/ajaxTest.do")
	@ResponseBody
	public List ajaxTest() {
		List list = bservice.selectList(1, 10);
		return list;
	}
	
	@RequestMapping("/ajaxTest2.do")
	@ResponseBody
	public Member ajaxTest2(String userId) {
		Member m = new Member();
		m.setUserId(userId);
		Member result = mservice.selectOne(m);
		return result;
	}
	
}
