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

import com.project.kan.admin.service.UsertableService;
import com.project.kan.admin.vo.Usertable;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/usertable")
public class UsertableController {
	
	@Autowired
    private UsertableService usertableservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addUser(@RequestBody Usertable usertable)
    {
        return usertableservice.saveUser(usertable);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllUser()
	{
		
		return usertableservice.getAllUser();
		
	}
	@RequestMapping("/get/{id}")
	@ResponseBody
	public MasterResponse getUser(@PathVariable("id") int id)
	{
		
		return usertableservice.getUser(id);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public MasterResponse deleteUser(@PathVariable("id") int id)
	{
		
		return usertableservice.deleteUser(id);
		
	}
	@PutMapping("/update/{id}")
	@ResponseBody
	public MasterResponse updateUser(@RequestBody Usertable usertable, @PathVariable("id") int id)
	{
		 return usertableservice.updateUser(usertable,id);
	}

}
