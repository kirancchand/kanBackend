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
import com.project.kan.security.vo.Users;

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
		
		List<Map<String, Object>> list=mydao.queryNameForList("master.user.login",new Object[]{username});
//		Object newObject=userservice.getUser(username);
		System.out.println(list.get(0));
		String password=list.get(0).get("password").toString();
		if (username.equals(list.get(0).get("email_id"))) {
			return new User(username, password,
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		
	}
	
	

	
	public UserResponse registerUser(Users user)
	{
//		return type Map<String, Object> 
		System.out.println(bcryptEncoder.encode(user.getPassword()));
		mydao.queryNameForUpdate("master.user.add",new Object[] {user.getFirst_name(),user.getMiddle_name(),user.getLast_name(),user.getEmail_id(),user.getGender(),user.getF_status_id(),user.getF_usertype_id(),bcryptEncoder.encode(user.getPassword())});
		UserResponse userResponse = new UserResponse();
		userResponse.setData(user);
		userResponse.setMessage("User Registered Successfully");
		userResponse.setStatus(200);
		return userResponse;
		
//		first_name,middle_name,last_name,email_id,dateofbirth,gender,f_status_id,f_usertype_id,password
//		Map<String, Object> resp=new HashMap<String, Object>();
//		resp.put("data",user);
//		resp.put("message","User Registered Successfully");
//		resp.put("status",200);
//		return resp;
	}
}