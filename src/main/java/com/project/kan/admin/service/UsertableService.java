package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Usertable;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;


@Service
public class UsertableService {

	private static final Logger logger = LoggerFactory.getLogger(UsertableService.class);

    @Autowired
    private MyDao mydao;
    
    public Usertable saveUser(@RequestBody Usertable usertable)
    {
    	
        mydao.queryNameForUpdate("master.usertable.add",new Object[] {usertable.getEmail_id(),usertable.getF_ward_id(),usertable.getFullname(),usertable.getMob_no(),usertable.getPassword(),usertable.getStatus(),usertable.getUser_id()});
        return usertable;
    }

    public List<Usertable> getAllUser()
	{
		List<Usertable> allUser = mydao.findAll("master.usertable.all",Usertable.class);
		 return allUser;		
	}
	
  //Get user by id..................//
	public Object getUser(@PathVariable("id") int id)
	{
		Object myObject = mydao.findById("master.usertable.getById",new Object[]{id},Usertable.class);
		return myObject;
		
	}
	
	public MasterResponse deleteUser(@PathVariable("id") int id)
	{
		
		mydao.delete("master.usertable.delete",new Object[]{id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateUser(@RequestBody Usertable usertable,@PathVariable("id") int id)
	{
	
		mydao.queryNameForUpdate("master.usertable.update", new Object[]{usertable.getEmail_id(), usertable.getF_ward_id(), usertable.getFullname(), usertable.getMob_no(), usertable.getPassword(), usertable.getStatus(), usertable.getUser_id(), id});

	}
	
}
