package com.java.service;

import java.util.ArrayList;

import com.java.dto.BoardDto;
import com.java.dto.ChartDto;

public interface BoardService {

	ArrayList<BoardDto> selectAll();

	ArrayList<ChartDto> selectChart();

	ArrayList<ChartDto> selectChart2();

}
