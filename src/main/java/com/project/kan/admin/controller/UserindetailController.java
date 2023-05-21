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

import com.project.kan.admin.service.UserindetailService;
import com.project.kan.admin.vo.Userindetail;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/userindetail")
public class UserindetailController {

	@Autowired
	private UserindetailService userindetailservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addUserindetail(@RequestBody Userindetail userindetail)
	{
		return userindetailservice.saveUserindetail(userindetail);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllUserindetail()
	{
		
		return userindetailservice.getAllUserindetail();
		
	}
	@RequestMapping("/get/{userindetail_id}")
	@ResponseBody
	public MasterResponse getUserindetail(@PathVariable("userindetail_id") int userindetail_id)
	{
		
		return userindetailservice.getUserindetail(userindetail_id);
		
	}
	@DeleteMapping("/delete/{userindetail_id}")
	@ResponseBody
	public MasterResponse deleteUserindetail(@PathVariable("userindetail_id") int userindetail_id)
	{
		
		return userindetailservice.deleteUserindetail(userindetail_id);
		
	}
	@PutMapping("/update/{userindetail_id}")
	@ResponseBody
	public MasterResponse updateUserindetail(@RequestBody Userindetail userindetail,@PathVariable("userindetail_id") int userindetail_id)
	{
		return userindetailservice.updateUserindetail(userindetail,userindetail_id);
	}
	
}
