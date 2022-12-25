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

import com.project.kan.admin.service.OrganisationService;
import com.project.kan.admin.vo.Organisation;


@RestController
@RequestMapping("/master/organisation")
public class OrganisationController {

	@Autowired
    private OrganisationService organisationservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Organisation addOrganisation(@RequestBody Organisation organisation)
    {
        return organisationservice.saveOrganisation(organisation);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Organisation> getAllOrganisation()
	{

		return organisationservice.getAllOrganisation();

	}
	@RequestMapping("/get/{organisation_id}")
	@ResponseBody
	public Object getOrganisation(@PathVariable("organisation_id") int organisation_id)
	{

		return organisationservice.getOrganisation(organisation_id);

	}

	@RequestMapping("/getByOrganisationtype/{f_organisation_type_id}")
	@ResponseBody
	public Object getOrganisationByOrganisationtype(@PathVariable("f_organisation_type_id") int f_organisation_type_id)
	{

		return organisationservice.getOrganisationByOrganisationtype(f_organisation_type_id);

	}

	@DeleteMapping("/delete/{organisation_id}")
	@ResponseBody
	public void deleteOrganisation(@PathVariable("organisation_id") int organisation_id)
	{

		organisationservice.deleteOrganisation(organisation_id);

	}
	@PutMapping("/update/{organisation_id}")
	@ResponseBody
	public void updateOrganisation(@RequestBody Organisation organisation, @PathVariable("organisation_id") int organisation_id)
	{
		 organisationservice.updateOrganisation(organisation,organisation_id);
	}

}
