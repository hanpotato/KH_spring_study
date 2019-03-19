package com.kh.spring.controller;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;

/*import org.apache.log4j;*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.model.vo.Member;
import com.kh.spring.service.MemberService;
import com.sun.xml.internal.fastinfoset.Encoder;

import sun.text.normalizer.NormalizerBase.Mode;

/*@SessionAttributes(value={"loggedMember"})*/
@Controller
public class MemberController {
	
	
	//log4j를 이용한 방식
	//private Logger logger = Logger.getLogger(MemberController.class);
	//log4j를 이용한 방식
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
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
		logger.debug(rawPw);
		String enPw = bcEcoder.encode(rawPw);
		logger.debug(enPw);
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
		logger.debug("login m 값 : "+m);
		logger.debug("login session 값 : "+session);
		Member result = service.selectOne(m);
		String msg = "";
		String loc = "/";
		
		try {
			throw new RuntimeException("TEST 에러 발생!");
		}
		catch(RuntimeException e) {
			logger.error("로그인 에러 : "+e.getMessage()+e.getStackTrace());
		}
		
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
	
/*
	@RequestMapping("member/memberUpdate.do")
	public String memberUpdate(Member m, HttpSession session, Model model) {
		
		m = (Member)session.getAttribute("loggedMember");
		Member result = service.selectOne(m);
		model.addAttribute("member", result);
		return "member/memberUpdate";
	}

	@RequestMapping("member/memberUpdateEnd.do")
	public String memberUpdateEnd(Member m, Model model) {
		int result = service.update(m);
		return "redirect:/";
	}
*/

	@RequestMapping("member/memberDel.do")
	public String memberDel(Member m) {
		int result = service.delete(m);
		return "redirect:/";
	}
	
	@RequestMapping("member/memberUpdate.do")
	public ModelAndView memberUpdateEnd(Member m, Model model) {
		
		logger.debug("updateEnd m 값 : "+m);
		Member re = service.selectOne(m);
		logger.debug("updateEnd re 값 : "+re);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/memberUpdate");
		mv.addObject("member",re);
		return mv;
	}
	
	@RequestMapping("/member/memberUpdateEnd.do")
	public ModelAndView updateEnd(Member m) {
		
		// 비밀번호값 암호화
		String rawPw = m.getPassword();
		String enPw = bcEcoder.encode(rawPw);
		m.setPassword(enPw);
		
		int result = service.update(m);
		String msg = "";
		String loc = "/member/update.do?userId="+m.getUserId();
		if(result>0) {
			msg = "수정완료";
		}
		else {
			msg = "수정실패";
		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/msg");
		mv.addObject("msg",msg);
		return mv;
	}
	
}
