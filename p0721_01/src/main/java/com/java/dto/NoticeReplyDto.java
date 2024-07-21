package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoticeReplyDto {

	private int rno;
	private int board_no;
	private String user_id;
	private String user_pw;
	private String rcontent;
	private Timestamp rdata;
	
}
