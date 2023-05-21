package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Subject;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class SubjectService {
	
	private static final Logger logger = LoggerFactory.getLogger(SubjectService.class);
	
	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveSubject(@RequestBody Subject subject)
	{
		Long a = mydao.queryForSave("master.subject.add",new Object[] {subject.getSubject()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(subject);
        return masterResponse;
//		if(a!=0)
//			return subject;
//			
//		else
//			return null;
		
	}
	public MasterResponse getAllSubject()
	{
		List<Subject> allSubject = mydao.findAll("master.subject.all",Subject.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allSubject);
        return masterResponse;
	
		
	}
	
	public MasterResponse getSubject(@PathVariable("subject_id") int subject_id)
	{
		Object myObject = mydao.findById("master.subject.getById",new Object[]{subject_id},Subject.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

		
	}
	
	public MasterResponse deleteSubject(@PathVariable("subject_id") int subject_id)
	{
		
		mydao.delete("master.subject.delete",new Object[]{subject_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public MasterResponse updateSubject(@RequestBody Subject subject,@PathVariable("subject_id") int subject_id)
	{
	
		long myObject = mydao.queryForUpdate("master.subject.update",new Object[]{subject.getSubject(),subject_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(subject);
        return masterResponse;

		
	}

}
