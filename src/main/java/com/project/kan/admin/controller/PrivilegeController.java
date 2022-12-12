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
    public Privilege addPrivilege(@RequestBody Privilege privilege)
    {
        return privilegeservice.savePrivilege(privilege);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Privilege> getAllPrivilege()
	{

		return privilegeservice.getAllPrivilege();

	}
	@RequestMapping("/get/{privilege_id}")
	@ResponseBody
	public Object getPrivilege(@PathVariable("privilege_id") int privilege_id)
	{

		return privilegeservice.getPrivilege(privilege_id);

	}

	@DeleteMapping("/delete/{privilege_id}")
	@ResponseBody
	public void deletePrivilege(@PathVariable("privilege_id") int privilege_id)
	{

		privilegeservice.deletePrivilege(privilege_id);

	}
	@PutMapping("/update/{privilege_id}")
	@ResponseBody
	public void updatePrivilege(@RequestBody Privilege privilege, @PathVariable("privilege_id") int privilege_id)
	{
		 privilegeservice.updatePrivilege(privilege,privilege_id);
	}

}
