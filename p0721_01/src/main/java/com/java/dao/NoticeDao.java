package com.java.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.NoticeDto;
import com.java.dto.NoticeReplyDto;

@Mapper
public interface NoticeDao {

	ArrayList<NoticeDto> selectAll();

	NoticeDto selectView(NoticeDto noticeDto);

	ArrayList<NoticeReplyDto> selectReply(NoticeDto noticeDto);	//댓글

	void commentBwrite(NoticeReplyDto noticereplyDto);// 댓글 저장

	NoticeReplyDto selectOneBwrite(NoticeReplyDto noticereplyDto);	//댓글 한 개 가져오기




}
