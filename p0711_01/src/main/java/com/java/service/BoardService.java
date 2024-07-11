package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;

public interface BoardService {

	ArrayList<BoardDto> selectList();	//게시판 리스트

	BoardDto selectOne(BoardDto bdto);	//게시글 한 개

	void insertBoard(BoardDto bdto);	//게시글 저장

	void deleteBoard(BoardDto bdto);	//게시글 삭제

	BoardDto updateBoard(BoardDto bdto);	// 게시글 수정

	void doUpdateBoard(BoardDto bdto);	//수정글 저장

	void insertReply(BoardDto bdto);	//답글 저장

	
}
