package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.CommentBDto;
import com.java.dto.NoticeDto;

@Mapper
public interface NoticeDao {

	ArrayList<NoticeDto> selectAll();

	NoticeDto selectOne(NoticeDto noticeDto);

	ArrayList<CommentBDto> selectAllCommentB(NoticeDto noticeDto);

	void insertCommentB(CommentBDto commentBDto);	// 하단댓글 저장

	CommentBDto selectOneCommentB(CommentBDto commentBDto);	// 하단댓글 1개 가져오기

	void deleteCommentB(CommentBDto commentBDto);	// 하단댓글 삭제

	void updateCommentB(CommentBDto commentBDto);	// 하단댓글수정완료

	



}
