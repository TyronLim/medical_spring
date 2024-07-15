package com.java.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dto.NoticeDto;
import com.java.dao.NoticeDao;

@Service
class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public ArrayList<NoticeDto> selectAll() {
		ArrayList<NoticeDto> list= noticeDao.selectAll();
		return list;
	}

}
