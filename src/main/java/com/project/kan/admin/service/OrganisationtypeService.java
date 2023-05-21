package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Organisationtype;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class OrganisationtypeService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganisationtypeService.class);

	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveOrganisationtype(@RequestBody Organisationtype organisationtype)
	{
		Long a = mydao.queryForSave("master.organisationtype.add",new Object[] {organisationtype.getOrganisation_type()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(organisationtype);
        return masterResponse;
//		if(a!=0)
//			return organisationtype;
//			
//		else
//			return null;
		
	}
	public MasterResponse getAllOrganisationtype()
	{
		List<Organisationtype> allOrganisationtype = mydao.findAll("master.organisationtype.all", Organisationtype.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allOrganisationtype);
        return masterResponse;

		
	}
	
	public MasterResponse getOrganisationtype(@PathVariable("organisation_type_id") int organisation_type_id)
	{
		Object myObject = mydao.findById("master.organisationtype.getById",new Object[]{organisation_type_id},Organisationtype.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

		
	}
	
	public MasterResponse deleteOrganisationtype(@PathVariable("organisation_type_id") int organisation_type_id)
	{
		
		mydao.delete("master.organisationtype.delete",new Object[]{organisation_type_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public MasterResponse updateOrganisationtype(@RequestBody Organisationtype organisationtype,@PathVariable("organisation_type_id") int organisation_type_id)
	{
	
		long myObject = mydao.queryForUpdate("master.organisationtype.update",new Object[]{organisationtype.getOrganisation_type(),organisation_type_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(organisationtype);
        return masterResponse;
		
	}
	

}
