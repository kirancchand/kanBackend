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

import com.project.kan.admin.service.StatusService;
import com.project.kan.admin.vo.Status;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/status")
public class StatusController {
	@Autowired
	private StatusService statusservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addStatus(@RequestBody Status status)
	{
		return statusservice.saveStatus(status);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllStatus()
	{
		
		return statusservice.getAllStatus();
		
	}
	@RequestMapping("/get/{status_id}")
	@ResponseBody
	public MasterResponse getStatus(@PathVariable("status_id") int status_id)
	{
		
		return statusservice.getStatus(status_id);
		
	}
	@DeleteMapping("/delete/{status_id}")
	@ResponseBody
	public MasterResponse deleteStatus(@PathVariable("status_id") int status_id)
	{
		
		return statusservice.deleteStatus(status_id);
		
	}
	@PutMapping("/update/{status_id}")
	@ResponseBody
	public MasterResponse updateStatus(@RequestBody Status status,@PathVariable("status_id") int status_id)
	{
		return statusservice.updateStatus(status,status_id);
	}

}

