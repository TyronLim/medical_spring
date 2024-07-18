package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardDto {

	private int board_no;
	private String board_type; 
	private String title; 
	private String contents; 
	private String user_id; 
	private Timestamp created_time;
	private Timestamp updated_time;
	
}
