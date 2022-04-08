package com.project.kan.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.common.dao.MyDao;
import com.project.kan.security.service.UserService;
import com.project.kan.security.vo.JwtRequest;
public class UserService {
	@Autowired
	private MyDao mydao;
	public Object getState(@RequestBody JwtRequest jwtRequest)
	{
		Object myObject=mydao.findById("master.state.getById",new Object[]{jwtRequest.getUsername(),jwtRequest.getPassword()},JwtRequest.class);
		return myObject;
		
	}

}
