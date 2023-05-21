package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;
import com.project.kan.security.vo.UserResponse;
import com.project.kan.admin.service.UsertypeService;
import com.project.kan.admin.vo.Usertype;

@Service
public class UsertypeService {

	private static final Logger logger = LoggerFactory.getLogger(UsertypeService.class);

	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveUsertype(@RequestBody Usertype usertype)
	{
		Long a = mydao.queryForSave("master.usertype.add",new Object[] {usertype.getUsertype()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(usertype);
        return masterResponse;
//		if(a!=0)
//			return usertype;
//			
//		else
//			return null;
		
	}
	public MasterResponse getAllUsertype()
	{
		List<Usertype> allUsertype=mydao.findAll("master.usertype.all",Usertype.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allUsertype);
        return masterResponse;
		
	}
	
	public MasterResponse getUsertype(@PathVariable("usertype_id") int usertype_id)
	{
		Object myObject=mydao.findById("master.usertype.getById",new Object[]{usertype_id},Usertype.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	public MasterResponse deleteUsertype(@PathVariable("usertype_id") int usertype_id)
	{
		
		mydao.delete("master.usertype.delete",new Object[]{usertype_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public MasterResponse updateUsertype(@RequestBody Usertype usertype,@PathVariable("usertype_id") int usertype_id)
	{
	
		long myObject=mydao.queryForUpdate("master.usertype.update",new Object[]{usertype.getUsertype(),usertype_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(usertype);
        return masterResponse;

		
	}
}
