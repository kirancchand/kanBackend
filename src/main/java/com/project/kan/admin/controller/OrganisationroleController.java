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

import com.project.kan.admin.service.OrganisationroleService;
import com.project.kan.admin.vo.Organisationrole;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/organisationrole")
public class OrganisationroleController {

	@Autowired
	private OrganisationroleService organisationroleservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public Organisationrole addOrganisationrole(@RequestBody Organisationrole organisationrole)
	{
		return organisationroleservice.saveOrganisationrole(organisationrole);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Organisationrole> getAllOrganisationrole()
	{
		
		return organisationroleservice.getAllOrganisationrole();
		
	}


	@RequestMapping("/get/{organisation_role_id}")
	@ResponseBody
	public Object getOrganisationrole(@PathVariable("organisation_role_id") int organisation_role_id)
	{
		
		return organisationroleservice.getOrganisationrole(organisation_role_id);
		
	}


	@DeleteMapping("/delete/{organisation_role_id}")
	@ResponseBody
	public MasterResponse deleteOrganisationrole(@PathVariable("organisation_role_id") int organisation_role_id)
	{
		
		return organisationroleservice.deleteOrganisationrole(organisation_role_id);
		
	}


	@PutMapping("/update/{organisation_role_id}")
	@ResponseBody
	public Long updateOrganisationrole(@RequestBody Organisationrole organisationrole,@PathVariable("organisation_role_id") int organisation_role_id)
	{
		return organisationroleservice.updateOrganisationrole(organisationrole,organisation_role_id);
	}
	
}
