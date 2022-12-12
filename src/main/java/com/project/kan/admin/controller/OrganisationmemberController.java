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

import com.project.kan.admin.service.OrganisationmemberService;
import com.project.kan.admin.vo.Organisationmember;


@RestController
@RequestMapping("/master/organisationmember")
public class OrganisationmemberController {

	@Autowired
    private OrganisationmemberService organisationmemberservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Organisationmember addOrganisationmember(@RequestBody Organisationmember organisationmember)
    {
        return organisationmemberservice.saveOrganisationmember(organisationmember);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Organisationmember> getAllOrganisationmember()
	{

		return organisationmemberservice.getAllOrganisationmember();

	}
	@RequestMapping("/get/{organisation_member_id}")
	@ResponseBody
	public Object getOrganisationmember(@PathVariable("organisation_member_id") int organisation_member_id)
	{

		return organisationmemberservice.getOrganisationmember(organisation_member_id);

	}


	@DeleteMapping("/delete/{organisation_member_id}")
	@ResponseBody
	public void deleteOrganisationmember(@PathVariable("organisation_member_id") int organisation_member_id)
	{

		organisationmemberservice.deleteOrganisationmember(organisation_member_id);

	}
	@PutMapping("/update/{organisation_member_id}")
	@ResponseBody
	public void updateOrganisationmember(@RequestBody Organisationmember organisationmember, @PathVariable("organisation_member_id") int organisation_member_id)
	{
		 organisationmemberservice.updateOrganisationmember(organisationmember, organisation_member_id);
	}

}
