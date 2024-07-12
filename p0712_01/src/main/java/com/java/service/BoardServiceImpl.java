package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;

@Service	//IOC컨테이너 등록
@Qualifier(value="ver1")
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	
	@Override
	public ArrayList<BoardDto> SelectList() {
		
		ArrayList<BoardDto> list = boardDao.selectList();
		
		System.out.println(list.size());
		
		return list;
		
	}



}
