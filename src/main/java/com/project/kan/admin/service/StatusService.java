package com.project.kan.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Status;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StatusService {

	private static final Logger logger = LoggerFactory.getLogger(StatusService.class);

	@Autowired
	private MyDao mydao;
	
	public Status saveStatus(@RequestBody Status status)
	{
		Long a=mydao.queryForSave("master.status.add",new Object[] {status.getStatus()});
		if(a!=0)
			return status;
			
		else
			return null;
		
	}
	public List<Status> getAllStatus()
	{
		List<Status> allStatus=mydao.findAll("master.status.all",Status.class);
		 return allStatus;
		
	}
	
	public Object getStatus(@PathVariable("status_id") int status_id)
	{
		Object myObject=mydao.findById("master.status.getById",new Object[]{status_id},Status.class);
		return myObject;
		
	}
	
	public MasterResponse deleteStatus(@PathVariable("status_id") int status_id)
	{
		
		mydao.delete("master.status.delete",new Object[]{status_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateStatus(@RequestBody Status status,@PathVariable("status_id") int status_id)
	{
	
		long myObject=mydao.queryForUpdate("master.status.update",new Object[]{status.getStatus(),status_id});
		return myObject;
		
	}
	
}
