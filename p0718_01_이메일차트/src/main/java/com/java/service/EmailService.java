package com.java.service;

public interface EmailService {

	void email_send(String name, String email);	//이메일 전송 text

	void email_send2(String name, String email);//이메일 전송 html

}
