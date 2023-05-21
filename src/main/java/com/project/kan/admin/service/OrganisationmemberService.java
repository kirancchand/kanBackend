package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Organisationmember;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class OrganisationmemberService {

	private static final Logger logger = LoggerFactory.getLogger(OrganisationmemberService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse saveOrganisationmember(@RequestBody Organisationmember organisationmember)
    {

        mydao.queryNameForUpdate("master.organisationmember.add",new Object[] {organisationmember.getF_organisation_role_id(), organisationmember.getF_status_id(), organisationmember.getF_user_id(), organisationmember.getF_organisation_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(organisationmember);
        return masterResponse;
    }

    public MasterResponse getAllOrganisationmember()
	{
		List<Organisationmember> allOrganisationmember = mydao.findAll("master.organisationmember.all",Organisationmember.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allOrganisationmember);
        return masterResponse;
	}


	public MasterResponse getOrganisationmember(@PathVariable("organisation_member_id") int organisation_member_id)
	{
		Object myObject = mydao.findById("master.organisationmember.getById",new Object[]{organisation_member_id},Organisationmember.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

	}



	public MasterResponse deleteOrganisationmember(@PathVariable("organisation_member_id") int organisation_member_id)
	{

		mydao.delete("master.organisationmember.delete",new Object[]{organisation_member_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;

	}

	public MasterResponse updateOrganisationmember(@RequestBody Organisationmember organisationmember,@PathVariable("organisation_member_id") int organisation_member_id)
	{

		mydao.queryNameForUpdate("master.organisationmember.update", new Object[]{organisationmember.getF_organisation_role_id(), organisationmember.getF_status_id(), organisationmember.getF_user_id(), organisationmember.getF_organisation_id(), organisation_member_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(organisationmember);
        return masterResponse;
	}
}
