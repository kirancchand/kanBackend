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

import com.project.kan.admin.service.SubjectService;
import com.project.kan.admin.vo.Subject;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/subject")

public class SubjectController {
	
	@Autowired
	private SubjectService subjectservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public Subject addSubject(@RequestBody Subject subject)
	{
		return subjectservice.saveSubject(subject);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Subject> getAllSubject()
	{
		
		return subjectservice.getAllSubject();
		
	}
	@RequestMapping("/get/{subject_id}")
	@ResponseBody
	public Object getSubject(@PathVariable("subject_id") int subject_id)
	{
		
		return subjectservice.getSubject(subject_id);
		
	}
	@DeleteMapping("/delete/{subject_id}")
	@ResponseBody
	public MasterResponse deleteSubject(@PathVariable("subject_id") int subject_id)
	{
		
		return subjectservice.deleteSubject(subject_id);
		
	}
	@PutMapping("/update/{subject_id}")
	@ResponseBody
	public Long updateSubject(@RequestBody Subject subject,@PathVariable("subject_id") int subject_id)
	{
		return subjectservice.updateSubject(subject,subject_id);
	}


}
