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
	
	public Usertype saveUsertype(@RequestBody Usertype usertype)
	{
		Long a = mydao.queryForSave("master.usertype.add",new Object[] {usertype.getUsertype()});
		if(a!=0)
			return usertype;
			
		else
			return null;
		
	}
	public List<Usertype> getAllUsertype()
	{
		List<Usertype> allUsertype=mydao.findAll("master.usertype.all",Usertype.class);
		 return allUsertype;
		
	}
	
	public Object getUsertype(@PathVariable("usertype_id") int usertype_id)
	{
		Object myObject=mydao.findById("master.usertype.getById",new Object[]{usertype_id},Usertype.class);
		return myObject;
		
	}
	
	public MasterResponse deleteUsertype(@PathVariable("usertype_id") int usertype_id)
	{
		
		mydao.delete("master.usertype.delete",new Object[]{usertype_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateUsertype(@RequestBody Usertype usertype,@PathVariable("usertype_id") int usertype_id)
	{
	
		long myObject=mydao.queryForUpdate("master.usertype.update",new Object[]{usertype.getUsertype(),usertype_id});
		return myObject;
		
	}
}
