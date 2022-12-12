package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Localbodytype;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;


@Service
public class LocalbodytypeService {
	private static final Logger logger = LoggerFactory.getLogger(LocalbodytypeService.class);

	@Autowired
	private MyDao mydao;
	
	public Localbodytype saveLocalbodytype(@RequestBody Localbodytype localbodytype)
	{
		Long a=mydao.queryForSave("master.localbodytype.add",new Object[] {localbodytype.getLocalbodytype_name()});
		if(a!=0)
			return localbodytype;
			
		else
			return null;
		
	}
	public List<Localbodytype> getAllLocalbodytype()
	{
		List<Localbodytype> allLocalbodytype = mydao.findAll("master.localbodytype.all",Localbodytype.class);
		 return allLocalbodytype;
		
	}
	
	public Object getLocalbodytype(@PathVariable("localbodytype_id") int localbodytype_id)
	{
		Object myObject = mydao.findById("master.localbodytype.getById",new Object[]{localbodytype_id},Localbodytype.class);
		return myObject;
		
	}
	
	public MasterResponse deleteLocalbodytype(@PathVariable("localbodytype_id") int localbodytype_id)
	{
		
		mydao.delete("master.localbodytype.delete",new Object[]{localbodytype_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateLocalbodytype(@RequestBody Localbodytype localbodytype,@PathVariable("localbodytype_id") int localbodytype_id)
	{
	
		long myObject=mydao.queryForUpdate("master.localbodytype.update",new Object[]{localbodytype.getLocalbodytype_name(),localbodytype_id});
		return myObject;
		
	}
}
