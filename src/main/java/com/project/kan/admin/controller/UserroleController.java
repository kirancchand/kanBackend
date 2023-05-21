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

import com.project.kan.admin.service.UserroleService;
import com.project.kan.admin.vo.Userrole;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/user_role")
public class UserroleController {
	
	@Autowired
    private UserroleService userroleservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addUserrole(@RequestBody Userrole userrole)
    {
        return userroleservice.saveUserrole(userrole);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllUserrole()
	{
		
		return userroleservice.getAllUserrole();
		
	}
	@RequestMapping("/get/{user_role_id}")
	@ResponseBody
	public MasterResponse getUserrole(@PathVariable("user_role_id") int user_role_id)
	{
		
		return userroleservice.getUserrole(user_role_id);
		
	}
		
	@DeleteMapping("/delete/{user_role_id}")
	@ResponseBody
	public MasterResponse deleteUserrole(@PathVariable("user_role_id") int user_role_id)
	{
		
		return userroleservice.deleteUserrole(user_role_id);
		
	}
	@PutMapping("/update/{user_role_id}")
	@ResponseBody
	public MasterResponse updateUserrole(@RequestBody Userrole userrole, @PathVariable("user_role_id") int user_role_id)
	{
		return userroleservice.updateUserrole(userrole,user_role_id);
	}

}
