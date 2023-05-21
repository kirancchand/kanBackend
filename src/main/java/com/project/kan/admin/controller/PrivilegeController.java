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

import com.project.kan.admin.service.PrivilegeService;
import com.project.kan.admin.vo.Privilege;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/privilege")
public class PrivilegeController {

	@Autowired
    private PrivilegeService privilegeservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addPrivilege(@RequestBody Privilege privilege)
    {
        return privilegeservice.savePrivilege(privilege);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllPrivilege()
	{

		return privilegeservice.getAllPrivilege();

	}
	@RequestMapping("/get/{privilege_id}")
	@ResponseBody
	public MasterResponse getPrivilege(@PathVariable("privilege_id") int privilege_id)
	{

		return privilegeservice.getPrivilege(privilege_id);

	}

	@DeleteMapping("/delete/{privilege_id}")
	@ResponseBody
	public MasterResponse deletePrivilege(@PathVariable("privilege_id") int privilege_id)
	{

		return privilegeservice.deletePrivilege(privilege_id);

	}
	@PutMapping("/update/{privilege_id}")
	@ResponseBody
	public MasterResponse updatePrivilege(@RequestBody Privilege privilege, @PathVariable("privilege_id") int privilege_id)
	{
		 return privilegeservice.updatePrivilege(privilege,privilege_id);
	}

}
