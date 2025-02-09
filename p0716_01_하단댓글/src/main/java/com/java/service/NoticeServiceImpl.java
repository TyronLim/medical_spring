package com.java.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.NoticeDao;
import com.java.dto.CommentBDto;
import com.java.dto.NoticeDto;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	NoticeDao noticeDao;
	
	@Override	// notice 리스트
	public ArrayList<NoticeDto> selectAll() {
		ArrayList<NoticeDto> list = noticeDao.selectAll();
		return list;
	}

	@Override	// notice 한 개
	public Map<String, Object> selectOne(NoticeDto noticeDto) {
		
		Map<String, Object> map = new HashMap<>();
		
		// 게시글 1개 가져오기
		NoticeDto nDto = noticeDao.selectOne(noticeDto);
		// 게시글 하단 댓글 모두 가져오기
		ArrayList<CommentBDto> list = noticeDao.selectAllCommentB(noticeDto);
		
		map.put("nDto", nDto);
		map.put("list", list);
		
//		System.out.println("임플dto : "+ map.get("nDto"));
//		System.out.println("임플리스트 : "+ map.get("list"));
		
		return map;
	}

	@Override	// 하단 댓글 저장, 1개 가져오기
	public CommentBDto insertCommentB(CommentBDto commentBDto) {
		System.out.println("service cno : "+commentBDto.getCno());

		// 하단댓글 저장
		noticeDao.insertCommentB(commentBDto);

		// cno 생성 후 출력
		System.out.println("service cno : "+commentBDto.getCno());
		
		// 하단 댓글 1개 가져오기
		CommentBDto cBDto = noticeDao.selectOneCommentB(commentBDto);
				
		return cBDto;
	}

	@Override
	public void deleteCommentB(CommentBDto commentBDto) {
		System.out.println("service cno : "+commentBDto.getCno());
		// 하단댓글 저장
		noticeDao.deleteCommentB(commentBDto);
				
		return;
	}

	@Override
	public CommentBDto updateCommentB(CommentBDto commentBDto) {
		System.out.println("service cno : "+commentBDto.getCno());
		noticeDao.updateCommentB(commentBDto);
		CommentBDto cBDto = noticeDao.selectOneCommentB(commentBDto);
		return cBDto;
	}
	
	
	
	
	
	

}
