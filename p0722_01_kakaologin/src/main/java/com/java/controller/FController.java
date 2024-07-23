package com.java.controller;



import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.dto.OAuthTokenDto;

@Controller
public class FController {
	
	//카카오에서 code값을 전달해줌.
	@RequestMapping("/kakao/oauth")
	@ResponseBody
	public String oauth(@RequestParam(value="code") String code) {
		System.out.println("code : "+code);
		
		// 토큰 요청 > 인터넷 url로 전송 post
		String content_type = "application/x-www-form-urlencoded;charset=utf-8";
		String grant_type = "authorization_code";
		String client_id = "241615a226268eddb98c9acfd14daa0d";
		String redirect_uri = "http://localhost:8181/kakao/oauth";
		// code = code;
		
		// http 전송
		RestTemplate rt = new RestTemplate();
		
		// HttpHeaders 생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type", content_type);
		
		// HttpBody 생성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", grant_type);
		params.add("client_id", client_id);
		params.add("redirect_uri", redirect_uri);
		params.add("code", code);
		
		// HttpEntity - HttpHeaders, HttpBody 1개의 오브젝트 생성
		HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(params,headers);
		
		// http전송 - HttpEntity
		String oauthUrl = "https://kauth.kakao.com/oauth/token";
		ResponseEntity<String> response = rt.exchange(oauthUrl, HttpMethod.POST,kakaoTokenRequest,String.class);
		System.out.println("카카오 토큰 요청에 대한 응답"+response);
		
		ObjectMapper objectMapper = new ObjectMapper();
		OAuthTokenDto oAuthTokenDto = null;
		
		try {
			oAuthTokenDto = objectMapper.readValue(response.getBody(), OAuthTokenDto.class);
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println("3.Access_token : "+oAuthTokenDto.getAccess_token());
		
		return "카카오 토큰 요청에 대한 응답 : "+response;
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}
}
