package com.java.dao;

import org.apache.ibatis.annotations.Mapper;

import com.java.dto.MemberDto;

@Mapper
public interface MemberDao {

	MemberDto selectLogin(MemberDto memberDto);// 로그인 세션
	
}
