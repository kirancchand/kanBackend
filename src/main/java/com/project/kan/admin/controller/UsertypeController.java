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

import com.project.kan.admin.service.UsertypeService;
import com.project.kan.admin.vo.Usertype;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/usertype")
public class UsertypeController {

	@Autowired
	private UsertypeService usertypeservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addUsertype(@RequestBody Usertype usertype)
	{
		return usertypeservice.saveUsertype(usertype);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllUsertype()
	{
		
		return usertypeservice.getAllUsertype();
		
	}
	@RequestMapping("/get/{usertype_id}")
	@ResponseBody
	public MasterResponse getUsertype(@PathVariable("usertype_id") int usertype_id)
	{
		
		return usertypeservice.getUsertype(usertype_id);
		
	}
	@DeleteMapping("/delete/{usertype_id}")
	@ResponseBody
	public MasterResponse deleteUsertype(@PathVariable("usertype_id") int usertype_id)
	{
		
		return usertypeservice.deleteUsertype(usertype_id);
		
	}
	@PutMapping("/update/{usertype_id}")
	@ResponseBody
	public MasterResponse updateUsertype(@RequestBody Usertype usertype,@PathVariable("usertype_id") int usertype_id)
	{
		return usertypeservice.updateUsertype(usertype,usertype_id);
	}


	
}
