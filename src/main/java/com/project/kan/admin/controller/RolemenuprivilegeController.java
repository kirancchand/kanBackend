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

import com.project.kan.admin.service.RolemenuprivilegeService;
import com.project.kan.admin.vo.Rolemenuprivilege;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/rolemenuprivilege")
public class RolemenuprivilegeController {
	
	@Autowired
    private RolemenuprivilegeService rolemenuprivilegeservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addRolemenuprivilege(@RequestBody Rolemenuprivilege rolemenuprivilege)
    {
        return rolemenuprivilegeservice.saveRolemenuprivilege(rolemenuprivilege);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllRolemenuprivilege()
	{
		
		return rolemenuprivilegeservice.getAllRolemenuprivilege();
		
	}
	@RequestMapping("/get/{role_menu_privilege_id}")
	@ResponseBody
	public MasterResponse getRolemenuprivilege(@PathVariable("role_menu_privilege_id") int role_menu_privilege_id)
	{
		
		return rolemenuprivilegeservice.getRolemenuprivilege(role_menu_privilege_id);
		
	}
	
	@DeleteMapping("/delete/{role_menu_privilege_id}")
	@ResponseBody
	public MasterResponse deleteRolemenuprivilege(@PathVariable("role_menu_privilege_id") int role_menu_privilege_id)
	{
		
		return rolemenuprivilegeservice.deleteRolemenuprivilege(role_menu_privilege_id);
		
	}
	
	@PutMapping("/update/{role_menu_privilege_id}")
	@ResponseBody
	public MasterResponse updateRolemenuprivilege(@RequestBody Rolemenuprivilege rolemenuprivilege, @PathVariable("role_menu_privilege_id") int role_menu_privilege_id)
	{
		 return rolemenuprivilegeservice.updateRolemenuprivilege(rolemenuprivilege,role_menu_privilege_id);
	}

}
