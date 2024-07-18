package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.BoardDao;
import com.java.dto.BoardDto;
import com.java.dto.ChartDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public ArrayList<BoardDto> selectAll() {
		ArrayList<BoardDto> list = boardDao.selectOne();
		return list;
	}

	@Override
	public ArrayList<ChartDto> selectChart() {
		ArrayList<ChartDto> list = boardDao.selectChart();
		return list;
	}

	@Override
	public ArrayList<ChartDto> selectChart2() {
		ArrayList<ChartDto> list = boardDao.selectChart2();
		return list;
	}

}
