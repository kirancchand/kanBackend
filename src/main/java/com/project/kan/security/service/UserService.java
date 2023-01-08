package com.project.kan.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.common.dao.MyDao;
import com.project.kan.security.service.UserService;
import com.project.kan.security.vo.JwtRequest;

@Service
public class UserService {
	@Autowired
	private MyDao mydao;
	public Object getUser(@RequestBody String jwtRequest)
	{
		Object myObject=mydao.queryNameForObject("master.user.login",new Object[]{jwtRequest},JwtRequest.class);
		return myObject;
		
	}

}
