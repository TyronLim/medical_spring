package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.dao.MemberDao;
import com.java.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	
	@Override
	public MemberDto selectlogin(MemberDto memberDto) {
		System.out.println("보내는 impl아이디 : "+memberDto.getId());
		System.out.println("보내는 impl패스워드 : "+memberDto.getPw());
		MemberDto mDto = memberDao.selectLogin(memberDto);
		System.out.println("받는 impl아이디 : "+mDto.getId());
		System.out.println("받는 impl패스워드 : "+mDto.getPw());
		
		
		return mDto;
	}


}
