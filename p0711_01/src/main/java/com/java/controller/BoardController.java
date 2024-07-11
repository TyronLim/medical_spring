package com.java.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.java.dto.BoardDto;
import com.java.service.BoardService;


@Controller
public class BoardController {

	@Autowired
	BoardService boardService; // IOC컨테이너에서 주입받음.
	
	@RequestMapping("/board/list") // 게시판리스트
	public ModelAndView list() {
		ArrayList<BoardDto> list = boardService.selectList();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}//list
	
	@RequestMapping("/board/view") //뷰페이지
	public ModelAndView view(BoardDto bdto) {
		
		//1개
		BoardDto boardDto = boardService.selectOne(bdto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto", boardDto);
		mv.setViewName("board/view");
		return mv;
	}
	
	@GetMapping("/board/write")
	public String write() { // 글쓰기 페이지
		return "board/write";
	}
	
	@PostMapping("/board/write") // 글쓰기 저장
	public String write(BoardDto bdto,@RequestPart MultipartFile files) {
		//id,btitle,bcontent,files
		System.out.println("controller files : "+files.getOriginalFilename());
		
		String uFile="";
		//파일이 존재할 시
		if(!files.isEmpty()) {
			//jsp
			long time = System.currentTimeMillis();
			System.out.println("time : "+time);
			
			//uuid 방식
	//		UUID uuid = UUID.randomUUID();
			uFile=String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl = "c:/upload/";
			File f = new File(saveUrl+uFile);
			try {
				files.transferTo(f);
			} catch (Exception e) {e.printStackTrace();} 
		
			}//if
		//변경된 파일이름 저장
		bdto.setBfile(uFile);
		
		boardService.insertBoard(bdto);
		return "redirect:/board/list";
	}
	
	
	@RequestMapping("/board/delete") // 게시글 삭제
	public String delete(BoardDto bdto) {
		System.out.println("controller delete bno : "+bdto.getBno());
		boardService.deleteBoard(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/update")
	public ModelAndView update(BoardDto bdto) { // 게시글 수정페이지
		BoardDto boardDto = boardService.updateBoard(bdto);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto", boardDto);
		mv.setViewName("/board/modify");
		return mv;
	}
	
	@RequestMapping("/board/doUpdate")	// 게시글 수정저장
	public String doUpdate(BoardDto bdto, @RequestPart MultipartFile files) {
		
		String uFile="";
		//파일이 존재할 시
		if(!files.isEmpty()) {
			//jsp
			long time = System.currentTimeMillis();
			System.out.println("time : "+time);
			
			//uuid 방식
	//		UUID uuid = UUID.randomUUID();
			uFile=String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl = "c:/upload/";
			File f = new File(saveUrl+uFile);
			try {
				files.transferTo(f);
			} catch (Exception e) {e.printStackTrace();} 
			//변경된 파일이름 저장
			bdto.setBfile(uFile);
		}//if
		
		System.out.println("controller bno : "+bdto.getBno());
		System.out.println("controller btitle : "+bdto.getBtitle());
		boardService.doUpdateBoard(bdto);	//bno,id,btitle,bcontent
		
		return "redirect:/board/list";
	}
	
	
	@RequestMapping("/board/reply")	//답글페이지
	public ModelAndView reply(BoardDto bdto) {
		BoardDto boardDto = boardService.selectOne(bdto);
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDto",boardDto);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@RequestMapping("/board/doReply")	//답글페이지 저장
	public String doReply(BoardDto bdto,@RequestPart MultipartFile files) {
		
		String uFile="";
		//파일이 존재할 시
		if(!files.isEmpty()) {
			long time = System.currentTimeMillis();
			System.out.println("time : "+time);
			
			uFile=String.format("%d_%s", time,files.getOriginalFilename());
			String saveUrl = "c:/upload/";
			File f = new File(saveUrl+uFile);
			try {
				files.transferTo(f);
			} catch (Exception e) {e.printStackTrace();} 
		}//if

		bdto.setBfile(uFile);

		boardService.insertReply(bdto);
		
		return "redirect:/board/list";
	}
	
}
