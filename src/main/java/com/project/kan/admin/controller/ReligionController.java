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

import com.project.kan.admin.service.ReligionService;
import com.project.kan.admin.vo.Religion;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/religion")

public class ReligionController {
	
	@Autowired
	private ReligionService religionservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public Religion addReligion(@RequestBody Religion religion)
	{
		return religionservice.saveReligion(religion);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Religion> getAllReligion()
	{
		
		return religionservice.getAllReligion();
		
	}
	
	@RequestMapping("/get/{religion_id}")
	@ResponseBody
	public Object getReligion(@PathVariable("religion_id") int religion_id)
	{
		
		return religionservice.getReligion(religion_id);
		
	}
	
	@DeleteMapping("/delete/{religion_id}")
	@ResponseBody
	public MasterResponse deleteReligion(@PathVariable("religion_id") int religion_id)
	{
		
		return religionservice.deleteReligion(religion_id);
		
	}
	
	@PutMapping("/update/{religion_id}")
	@ResponseBody
	public Long updateReligion(@RequestBody Religion religion, @PathVariable("religion_id") int religion_id)
	{
		return religionservice.updateReligion(religion, religion_id);
	}


}
