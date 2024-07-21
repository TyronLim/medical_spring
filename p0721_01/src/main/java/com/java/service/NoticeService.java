package com.java.service;

import java.util.ArrayList;
import java.util.Map;

import com.java.dto.NoticeDto;
import com.java.dto.NoticeReplyDto;

public interface NoticeService {

	ArrayList<NoticeDto> selectAll();

	Map<String, Object> selectView(NoticeDto noticeDto);

	NoticeReplyDto commentBwrite(NoticeReplyDto noticereplyDto);//댓글 추가




}
