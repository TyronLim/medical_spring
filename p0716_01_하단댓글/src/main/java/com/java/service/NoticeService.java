package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.CommentBDto;
import com.java.dto.NoticeDto;

public interface NoticeService {

	ArrayList<NoticeDto> selectAll();

	Map<String, Object> selectOne(NoticeDto noticeDto);

	CommentBDto insertCommentB(CommentBDto commentBDto);	// 하단댓글 저장, 1개 가져오기

	void deleteCommentB(CommentBDto commentBDto);	// 하단댓글 삭제

	CommentBDto updateCommentB(CommentBDto commentBDto);	// 하단댓글 수정 완료

}
