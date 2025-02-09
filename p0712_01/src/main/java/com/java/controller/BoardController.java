package com.java.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	@Qualifier(value="ver1")
	BoardService boardService;
	
	@RequestMapping("/board/list")
	public ModelAndView list() {
		
		ArrayList<BoardDto> list = boardService.SelectList();	//게시판 전체 가져오기
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	

	
}
