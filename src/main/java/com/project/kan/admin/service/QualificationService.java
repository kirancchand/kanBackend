package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Qualification;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class QualificationService {

	private static final Logger logger = LoggerFactory.getLogger(QualificationService.class);
	
	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveQualification(@RequestBody Qualification qualification)
	{
		Long a = mydao.queryForSave("master.qualification.add",new Object[] {qualification.getQualification()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(qualification);
        return masterResponse;
//		if(a!=0)
//			return qualification;
//			
//		else
//			return null;
		
	}
	public MasterResponse getAllQualification()
	{
		List<Qualification> allQualification = mydao.findAll("master.qualification.all",Qualification.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allQualification);
        return masterResponse;

		
	}
	
	public MasterResponse getQualification(@PathVariable("qualification_id") int qualification_id)
	{
		Object myObject = mydao.findById("master.qualification.getById",new Object[]{qualification_id},Qualification.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	public MasterResponse deleteQualification(@PathVariable("qualification_id") int qualification_id)
	{
		
		mydao.delete("master.qualification.delete",new Object[]{qualification_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public MasterResponse updateQualification(@RequestBody Qualification qualification,@PathVariable("qualification_id") int qualification_id)
	{
	
		long myObject = mydao.queryForUpdate("master.qualification.update",new Object[]{qualification.getQualification(),qualification_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
}
