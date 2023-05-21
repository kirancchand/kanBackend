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

import com.project.kan.admin.service.QualificationService;
import com.project.kan.admin.vo.Qualification;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/qualification")
public class QualificationController {
	
	@Autowired
	private QualificationService qualificationservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addQualification(@RequestBody Qualification qualification)
	{
		return qualificationservice.saveQualification(qualification);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllQualification()
	{
		
		return qualificationservice.getAllQualification();
		
	}
	@RequestMapping("/get/{qualification_id}")
	@ResponseBody
	public MasterResponse getQualification(@PathVariable("qualification_id") int qualification_id)
	{
		
		return qualificationservice.getQualification(qualification_id);
		
	}
	@DeleteMapping("/delete/{qualification_id}")
	@ResponseBody
	public MasterResponse deleteQualification(@PathVariable("qualification_id") int qualification_id)
	{
		
		return qualificationservice.deleteQualification(qualification_id);
		
	}
	@PutMapping("/update/{qualification_id}")
	@ResponseBody
	public MasterResponse updateQualification(@RequestBody Qualification qualification,@PathVariable("qualification_id") int qualification_id)
	{
		return qualificationservice.updateQualification(qualification,qualification_id);
	}


}
