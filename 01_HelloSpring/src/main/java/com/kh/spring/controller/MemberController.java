package com.kh.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;

/*@SessionAttributes(value={"loggedMember"})*/
@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private BCryptPasswordEncoder bcEcoder;
	
	@RequestMapping("/member/memberEnroll.do")
	public String memberEnroll() {
		return "member/memberEnroll";
	}

	@RequestMapping("/member/memberEnrollEnd.do")
	public String memberEnrollEnd(Member m, Model model) {
		
		String rawPw = m.getPassword();
		String enPw = bcEcoder.encode(rawPw);
		m.setPassword(enPw);
		//m.setPassword(bcEcoder.encode(rawPw));
		
		int result = service.insertMember(m);
		String msg = "";
		String loc = "/";
		if(result>0) {
			msg = "회원가입완료";
		}
		else {
			msg = "회원가입실패";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		return "common/msg";
	}
	
	@RequestMapping("/member/memberLogin.do")
	public String login(Member m, Model model, HttpSession session) {
		
		Member result = service.selectOne(m);
		String msg = "";
		String loc = "/";
		
		if(result!=null) {
			if(bcEcoder.matches(m.getPassword(), result.getPassword())) {
				msg = "로그인 성공";
				session.setAttribute("loggedMember", result);
				/*model.addAttribute("loggedMember",result);*/
			}
			else {
				msg = "패스워드가 일치하지 않습니다.";
			}
		}
		else {
			msg = "아이디가 존재하지 않습니다.";
		}
		
		model.addAttribute("msg",msg);
		model.addAttribute("loc",loc);
		return "common/msg";
	}
	
	@RequestMapping("/member/logOut.do")
	public String logOut(/*SessionStatus session*/ HttpSession session) {
		
		/*
		if(!session.isComplete()) {
			session.setComplete();
		}
		*/
		
		session.invalidate();

		return "redirect:/";
	}
	
}
