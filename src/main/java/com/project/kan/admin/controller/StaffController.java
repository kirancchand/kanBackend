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

import com.project.kan.admin.service.StaffService;
import com.project.kan.admin.vo.Staff;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addStaff(@RequestBody Staff staff)
	{
		return staffService.saveStaff(staff);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllStaff()
	{
		
		return staffService.getAllStaff();
		
	}
	
	@RequestMapping("/get/{staff_id}")
	@ResponseBody
	public MasterResponse getStaff(@PathVariable("staff_id") int staff_id)
	{
		
		return staffService.getStaff(staff_id);
		
	}
	
	@DeleteMapping("/delete/{staff_id}")
	@ResponseBody
	public MasterResponse deleteStaff(@PathVariable("staff_id") int staff_id)
	{
		
		return staffService.deleteStaff(staff_id);
		
	}
	
	@PutMapping("/update/{staff_id}")
	@ResponseBody
	public MasterResponse updateStaff(@RequestBody Staff staff,@PathVariable("staff_id") int staff_id)
	{
		return staffService.updateStaff(staff,staff_id);
	}

}
