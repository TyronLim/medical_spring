package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.NoticeDao;
import com.java.dto.NoticeDto;
import com.java.dto.NoticeReplyDto;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeDao noticeDao;
	
	@Override
	public ArrayList<NoticeDto> selectAll() {
		ArrayList<NoticeDto> list = noticeDao.selectAll();
		return list;
	}

	@Override
	public Map<String, Object> selectView(NoticeDto noticeDto) {
		NoticeDto nDto = noticeDao.selectView(noticeDto);
		
		ArrayList<NoticeReplyDto> list = noticeDao.selectReply(noticeDto);	//댓글
		
		Map<String, Object> map = new HashMap<>();
		map.put("nDto", nDto);
		map.put("list", list);
		
		return map;
	}

	@Override
	public NoticeReplyDto commentBwrite(NoticeReplyDto noticereplyDto) {
		noticeDao.commentBwrite(noticereplyDto);
		NoticeReplyDto nRDto = noticeDao.selectOneBwrite(noticereplyDto);
		return nRDto;
	}

	



}
