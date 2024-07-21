package com.java.controller;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.NoticeDto;
import com.java.dto.NoticeReplyDto;
import com.java.service.NoticeService;

@Controller
public class FController {

	@Autowired
	NoticeService noticeService;
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@RequestMapping("/customer/notice")
	public ModelAndView notice() {
		ArrayList<NoticeDto> list = noticeService.selectAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("list",list);
		mv.setViewName("customer/notice");
		return mv;
	}
	
	@RequestMapping("/customer/notice_view")
	public ModelAndView notice_view(NoticeDto noticeDto) {
		
		Map<String, Object> map = noticeService.selectView(noticeDto);

		ModelAndView mv = new ModelAndView();
		mv.addObject("nDto",map.get("nDto"));
		mv.addObject("list",map.get("list"));
		mv.setViewName("customer/notice_view");
		return mv;
	}
	
	@RequestMapping("/customer/commentBwrite")
	public NoticeReplyDto commentBwrite(NoticeReplyDto noticereplyDto) {
		
		NoticeReplyDto nRDto = noticeService.commentBwrite(noticereplyDto);
	
		return nRDto;
	}
	

	

	
	
	
	
	
}
