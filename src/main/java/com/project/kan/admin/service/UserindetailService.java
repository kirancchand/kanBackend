package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Userindetail;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class UserindetailService {

	private static final Logger logger = LoggerFactory.getLogger(UserindetailService.class);

	@Autowired
	private MyDao mydao;
	
	public Userindetail saveUserindetail(@RequestBody Userindetail userindetail)
	{
		Long a=mydao.queryForSave("master.userindetail.add",new Object[] {userindetail.getF_user_id()});
		if(a!=0)
			return userindetail;
			
		else
			return null;
		
	}
	public List<Userindetail> getAllUserindetail()
	{
		List<Userindetail> allUserindetail=mydao.findAll("master.userindetail.all",Userindetail.class);
		 return allUserindetail;
		
	}
	
	public Object getUserindetail(@PathVariable("userindetail_id") int userindetail_id)
	{
		Object myObject=mydao.findById("master.userindetail.getById",new Object[]{userindetail_id},Userindetail.class);
		return myObject;
		
	}
	
	public MasterResponse deleteUserindetail(@PathVariable("userindetail_id") int userindetail_id)
	{
		
//		 userindetailrepo.deleteById(userindetail_id);
		mydao.delete("master.userindetail.delete",new Object[]{userindetail_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateUserindetail(@RequestBody Userindetail userindetail,@PathVariable("userindetail_id") int userindetail_id)
	{
	
		long myObject=mydao.queryForUpdate("master.userindetail.update",new Object[]{userindetail.getF_user_id(),userindetail_id});
		return myObject;
//		return userindetail.getUserindetail();
		
	}
	
}
