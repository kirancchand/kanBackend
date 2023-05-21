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

import com.project.kan.admin.service.RoleService;
import com.project.kan.admin.vo.Role;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/role")
public class RoleController {

	@Autowired
    private RoleService roleservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addRole(@RequestBody Role role)
    {
        return roleservice.saveRole(role);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllRole()
	{

		return roleservice.getAllRole();

	}
	@RequestMapping("/get/{role_id}")
	@ResponseBody
	public MasterResponse getRole(@PathVariable("role_id") int role_id)
	{

		return roleservice.getRole(role_id);

	}

	@DeleteMapping("/delete/{role_id}")
	@ResponseBody
	public MasterResponse deleteRole(@PathVariable("role_id") int role_id)
	{

		return roleservice.deleteRole(role_id);

	}
	@PutMapping("/update/{role_id}")
	@ResponseBody
	public MasterResponse updateRole(@RequestBody Role role, @PathVariable("role_id") int role_id)
	{
		 return roleservice.updateRole(role,role_id);
	}

}
