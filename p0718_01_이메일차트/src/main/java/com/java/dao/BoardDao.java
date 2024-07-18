package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.BoardDto;
import com.java.dto.ChartDto;

@Mapper
public interface BoardDao {

	ArrayList<BoardDto> selectOne();

	ArrayList<ChartDto> selectChart();

	ArrayList<ChartDto> selectChart2();

}
