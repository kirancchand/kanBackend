package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.User;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private MyDao mydao;
    
    public User saveUser(@RequestBody User user)
    {
    	
        mydao.queryNameForUpdate("master.user.add",new Object[] {user.getEmail_id(),user.getF_ward_id(),user.getFullname(),user.getMob_no(),user.getPassword(),user.getStatus(),user.getUser_id()});
        return user;
    }

    public List<User> getAllUser()
	{
		List<User> allUser = mydao.findAll("master.user.all",User.class);
		 return allUser;		
	}
	
  //Get user by id..................//
	public Object getUser(@PathVariable("id") int id)
	{
		Object myObject = mydao.findById("master.user.getById",new Object[]{id},User.class);
		return myObject;
		
	}
	
	public MasterResponse deleteUser(@PathVariable("id") int id)
	{
		
		mydao.delete("master.user.delete",new Object[]{id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateUser(@RequestBody User user,@PathVariable("id") int id)
	{
	
		mydao.queryNameForUpdate("master.user.update", new Object[]{user.getEmail_id(), user.getF_ward_id(), user.getFullname(), user.getMob_no(), user.getPassword(), user.getStatus(), user.getUser_id(), id});

	}
	
}
