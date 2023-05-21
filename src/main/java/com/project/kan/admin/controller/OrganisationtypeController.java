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

import com.project.kan.admin.service.OrganisationtypeService;
import com.project.kan.admin.vo.Organisationtype;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/organisationtype")
public class OrganisationtypeController {

	@Autowired
	private OrganisationtypeService organisationtypeservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addOrganisationtype(@RequestBody Organisationtype organisationtype)
	{
		return organisationtypeservice.saveOrganisationtype(organisationtype);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllOrganisationtype()
	{
		
		return organisationtypeservice.getAllOrganisationtype();
		
	}
	@RequestMapping("/get/{organisation_type_id}")
	@ResponseBody
	public MasterResponse getOrganisationtype(@PathVariable("organisation_type_id") int organisation_type_id)
	{
		
		return organisationtypeservice.getOrganisationtype(organisation_type_id);
		
	}
	@DeleteMapping("/delete/{organisation_type_id}")
	@ResponseBody
	public MasterResponse deleteOrganisationtype(@PathVariable("organisation_type_id") int organisation_type_id)
	{
		
		return organisationtypeservice.deleteOrganisationtype(organisation_type_id);
		
	}
	@PutMapping("/update/{organisation_type_id}")
	@ResponseBody
	public MasterResponse updateOrganisationtype(@RequestBody Organisationtype organisationtype,@PathVariable("organisation_type_id") int organisation_type_id)
	{
		return organisationtypeservice.updateOrganisationtype(organisationtype,organisation_type_id);
	}
	
	
}
