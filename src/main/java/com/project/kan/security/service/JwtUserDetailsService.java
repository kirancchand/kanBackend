package com.project.kan.security.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.kan.common.dao.MyDao;
import com.project.kan.security.service.UserService;
import com.project.kan.security.vo.JwtRequest;
import com.project.kan.security.vo.JwtResponse;
import com.project.kan.security.vo.UserResponse;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userservice;
	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	private MyDao mydao;
	

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
//		{
//			data:
//			message:
//			statuse
//		}
		
		List<Map<String, Object>> list=mydao.queryNameForList("master.user.login",new Object[]{username});
//		Object newObject=userservice.getUser(username);
		System.out.println(list.get(0).get("password"));
		String password=list.get(0).get("password").toString();
		if (username.equals(list.get(0).get("username"))) {

//			Map<String, Object> ma=new HashMap<String, Object>();
//			ma.put(arg0, arg1)
//			return new User(username, "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
			
			

			return new User(username, password,
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
	}
	
	

	
	public UserResponse registerUser(JwtRequest user)
	{
//		return type Map<String, Object> 
		System.out.println(bcryptEncoder.encode(user.getPassword()));
		mydao.queryNameForUpdate("master.user.add",new Object[] {user.getUsername(),bcryptEncoder.encode(user.getPassword())});
		UserResponse userResponse = new UserResponse();
		userResponse.setData(user);
		userResponse.setMessage("User Registered Successfully");
		userResponse.setStatus(200);
		return userResponse;
		
//		Map<String, Object> resp=new HashMap<String, Object>();
//		resp.put("data",user);
//		resp.put("message","User Registered Successfully");
//		resp.put("status",200);
//		return resp;
	}
}