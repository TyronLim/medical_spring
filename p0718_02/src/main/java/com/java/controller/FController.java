package com.java.controller;

import org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.MemberDto;
import com.java.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class FController {

	@Autowired
	MemberService memberService;
	@Autowired
	HttpSession session;
	
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public ModelAndView login(MemberDto memberDto) {
		System.out.println("보내는 id : "+memberDto.getId());
		System.out.println("보내는 pw : "+memberDto.getPw());
		
		
		int chkLogin=0;
		MemberDto mDto = memberService.selectlogin(memberDto);
		if(mDto!=null) {
			chkLogin=1;
			System.out.println("controller id"+mDto.getId());
			System.out.println("controller pw"+mDto.getPw());
			
			session.setAttribute("sessionId", mDto.getId());
			session.setAttribute("sessionPw", mDto.getPw());
		}
		System.out.println("로그인 확인 번호 : "+chkLogin);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("chkLogin",chkLogin);
		mv.setViewName("/member/doLogin");
		
		return mv;
	}
	
	
	
	
	
}
