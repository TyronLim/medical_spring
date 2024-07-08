package com.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class FrontController {

	// get 방식만 사용 가능 
	@RequestMapping(value= "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	// get, post 방식 둘 다 사용 가능
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	// get 방식만 사용 가능
	@GetMapping("/board/board")
	public String board() {
		return "board/board";
	}
	
	// post 방식만 사용 가능
	@PostMapping("/doBoard")
	public String doBoard() {
		return "doBoard";
		
	}
	
	@RequestMapping("/board/form")
	public String form() {
		return "board/form";
	}
	
	@RequestMapping("/board/form2")
	public String form2() {
		return "board/form2";
	}
	
	@RequestMapping("/board/doForm")
	public String doForm(HttpServletRequest request, Model model) {
		System.out.println("bno : "+request.getParameter("bno"));
		System.out.println("bno : "+request.getParameter("btitle"));
		model.addAttribute("bno", request.getParameter("bno"));
		model.addAttribute("btitle",request.getParameter("btitle"));
		return "board/doForm";
	}

	@RequestMapping("/board/doForm2")
	public ModelAndView doForm2(HttpServletRequest request) {
		System.out.println("bno : "+request.getParameter("bno"));
		System.out.println("bno : "+request.getParameter("btitle"));
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/doForm2");
		mv.addObject("bno", request.getParameter("bno"));
		mv.addObject("btitle", request.getParameter("btitle"));
		
		return mv;
	}
	
	
	
	
	
	
	
	
	
}
