package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Education;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class EducationService {
	
	private static final Logger logger = LoggerFactory.getLogger(EducationService.class);

    @Autowired
    private MyDao mydao;
    
    public Education saveEducation(@RequestBody Education education)
    {
    	
        mydao.queryNameForUpdate("master.education.add",new Object[] {education.getSubject_id(), education.getQualification_id()});
        return education;
    }

    public List<Education> getAllEducation()
	{
		List<Education> allEducation = mydao.findAll("master.education.all",Education.class);
		 return allEducation;		
	}
	
  //Get by id..................//
	public Object getEducation(@PathVariable("education_id") int education_id)
	{
		Object myObject = mydao.findById("master.education.getById",new Object[]{education_id},Education.class);
		return myObject;
		
	}
	
	
	public MasterResponse deleteEducation(@PathVariable("education_id") int education_id)
	{
		
		mydao.delete("master.education.delete",new Object[]{education_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateEducation(@RequestBody Education education,@PathVariable("education_id") int education_id)
	{
	
		mydao.queryNameForUpdate("master.education.update", new Object[]{education.getSubject_id(), education.getQualification_id(), education_id});

	}
	

}
