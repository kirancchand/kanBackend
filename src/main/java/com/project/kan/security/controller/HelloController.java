package com.project.kan.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.kan.security.config.JwtTokenUtil;

@RestController
public class HelloController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@RequestMapping({ "/hello" })
	public String firstPage(@RequestHeader (name="Authorization") String token) {
		

		String myUserName=jwtTokenUtil.getUsernameFromToken(token.substring(7));
		return myUserName;
	}

}
