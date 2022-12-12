package com.project.kan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.kan.admin.service.EducationService;
import com.project.kan.admin.vo.Education;

@RestController
@RequestMapping("/master/education")
public class EducationController {

	@Autowired
    private EducationService educationservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Education addEducation(@RequestBody Education education)
    {
        return educationservice.saveEducation(education);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Education> getAllEducation()
	{
		
		return educationservice.getAllEducation();
		
	}
	@RequestMapping("/get/{education_id}")
	@ResponseBody
	public Object getEducation(@PathVariable("education_id") int education_id)
	{
		
		return educationservice.getEducation(education_id);
		
	}
	
	
	@DeleteMapping("/delete/{education_id}")
	@ResponseBody
	public void deleteEducation(@PathVariable("education_id") int education_id)
	{
		
		educationservice.deleteEducation(education_id);
		
	}
	@PutMapping("/update/{education_id}")
	@ResponseBody
	public void updateEducation(@RequestBody Education education, @PathVariable("education_id") int education_id)
	{
		 educationservice.updateEducation(education,education_id);
	}
	
}
