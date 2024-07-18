package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.dto.ChartDto;
import com.java.service.BoardService;
import com.java.service.EmailService;

@Controller
public class FController {
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	EmailService emailService;
	
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/chart")			// 차트 그리기
	public String chart() {
		return "chart";
	}
	
	@GetMapping("/email")			// 메일
	public String email() {
		return "email";
	}
	@PostMapping("/email_send")
	@ResponseBody// 메일
	public String email_send(String name, String email) {
		System.out.println("controller name : "+name);
		System.out.println("controller email : "+email);
		
		// 이메일 전송
		emailService.email_send(name,email);
		emailService.email_send2(name,email);
		
		
		
		
		return "success";
	}

	@GetMapping("/notice_list")		// 게시판 페이지 notice_list
	public ModelAndView notice_list() {
		//board 테이블의 데이터를 가져와서 출력하시오.
		
		ArrayList<BoardDto> list = boardService.selectAll();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("notice_list");
		
		System.out.println(list);
		
		System.out.println();
		return mv;
	}
//	
	@PostMapping("/chart_data")		//ajax 차트 데이터 전송
	@ResponseBody
	public ArrayList<ChartDto> chart_data(String data) {
		System.out.println("controller data : "+data);
		
		ArrayList<ChartDto> list=boardService.selectChart();
		
		if(data.equals("region")) {
			// region, amt를 객체를 생성해서 db에서 가져와서 출력하시오.
			list = boardService.selectChart();
			System.out.println(list);
			
		}else{
			list = boardService.selectChart2();
			System.out.println(list);
		}
		
		//System.out.println("controller list : "+list);
		
		return list;
	}
	
	
	
	
}
