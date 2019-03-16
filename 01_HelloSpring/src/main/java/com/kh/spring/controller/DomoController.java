package com.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.model.vo.Dev;
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
	
	/*	
	spring URL 이랑 맵핑되는 메소드에서 활용할 수 있는 매개변수

	-선언하게 되면 자동적으로 만들어져서 사용할 수 있다.-
	HttpServletRequest request
	HttpServletResponse res
	HttpSession session
	Locale locale : 설정된 지역
	InputStream/Reader
	OutputStream/Writer
	
	@RequestParam : 전송된 데이터 지정
	@CookieValue : 쿠키값
	@RequestHeader : 헤더 정보
	@RequestBody : Json파라미터값 받는 것
	
	변수선언~ : 자료형 변수명
		-> 파라미터로 넘어오는 값의 키값이 선언한 변수명과 동일하면 자동으로 동일한 변수에 값을 넣어줌!
	
	객체명 변수명 : VO객체를 선언
		-> 맴버변수와 같은 파라미터 키값이 있으면 넣어줌!
	*/

	@RequestMapping("/domo/domo1.do")
	public String domo1(HttpServletRequest re) {
		String devName = re.getParameter("devName");
		int devAge = Integer.parseInt(re.getParameter("devAge"));
		String devEmail = re.getParameter("devEmail");
		String devGender = re.getParameter("devGender");
		String[] devLang = re.getParameterValues("devLang");
		System.out.println(devName+devAge+devEmail+devGender+devLang);
		Dev dev = new Dev(devName,devAge,devEmail,devGender,devLang);
		re.setAttribute("dev", dev);
		return "domo/domoResult";
	}

	@RequestMapping("/domo/domo2.do")
	public String domo2(
			@RequestParam(value="Name") String devName,
			/*@RequestParam(value="Name") value에다가 jsp에서 선언한 name값을 넣고, 그 값을 여기서 선언한 매개변수로 연결해 준다*/
			@RequestParam(value="devAge" /*,required=false*/, defaultValue="100") int devAge,
			/*required=false 로 설정하면 값이 있어도 없어도 되는 상태를 말한다.*/
			/*defaultValue="100" 로 설정하면 넘어온 값이 없을때, 설정된 '100' 값이 매개변수에 저장이 된다.*/
			String devEmail,
			String devGender,
			String[] devLang,
			HttpServletRequest re) {
		
		System.out.println(devName+devAge+devEmail+devGender+devLang);
		re.setAttribute("dev", new Dev(devName,devAge,devEmail,devGender,devLang));
		return "domo/domoResult";
	}
	
	@RequestMapping("/domo/domo3.do")
	public String domo3(Dev dev, Model model) {
		/*Model : 데이터 저장용 객체, request랑 비슷함*/
		/*vo객체와 jsp에서 설정된 name값이 일치하지 않으면 값을 못 받는다.*/
		model.addAttribute("dev",dev);
		return "domo/domoResult";
	}
	
	@RequestMapping("/domo/insert.do")
	public String insert(Dev dev) {
		int result = service.insert(dev);
		return "redirect:/";
	}

	@RequestMapping("/domo/domo5.do")
	public String domo5(HttpServletRequest re) {
		Dev result = service.domo5();
		System.out.println(result);
		re.setAttribute("dev", result);
		return "domo/domoResult";
	}
	
	
	@RequestMapping("/domo/selectList.do")
	public String selectList(Model model) {
		List<Dev> list = service.selectList();
		System.out.println(list);
		model.addAttribute("list",list);
		return "domo/domoList";
	}
	
	/*
	@RequestMapping("/domo/selectList.do")
	public String selectList(HttpServletRequest rs) {
		List<Dev> list = service.selectList();
		System.out.println(list);
		rs.setAttribute("list", list);
		return "domo/domoList";
	}
	*/

}
