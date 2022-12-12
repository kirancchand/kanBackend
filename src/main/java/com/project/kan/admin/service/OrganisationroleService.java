package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Organisationrole;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class OrganisationroleService {

	private static final Logger logger = LoggerFactory.getLogger(Organisationrole.class);
	
	@Autowired
	private MyDao mydao;
	
	public Organisationrole saveOrganisationrole(@RequestBody Organisationrole organisationrole)
	{
		Long a = mydao.queryForSave("master.organisationrole.add",new Object[] {organisationrole.getOrganisation_role()});
		if(a!=0)
			return organisationrole;
			
		else
			return null;
		
	}
	public List<Organisationrole> getAllOrganisationrole()
	{
		List<Organisationrole> allOrganisationrole = mydao.findAll("master.organisationrole.all",Organisationrole.class);
		 return allOrganisationrole;
		
	}
	
	public Object getOrganisationrole(@PathVariable("organisation_role_id") int organisation_role_id)
	{
		Object myObject = mydao.findById("master.organisationrole.getById",new Object[]{organisation_role_id},Organisationrole.class);
		return myObject;
		
	}
	
	public MasterResponse deleteOrganisationrole(@PathVariable("organisation_role_id") int organisation_role_id)
	{
		

		mydao.delete("master.organisationrole.delete",new Object[]{organisation_role_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateOrganisationrole(@RequestBody Organisationrole organisationrole,@PathVariable("_organisation_role_id") int organisation_role_id)
	{
	
		long myObject = mydao.queryForUpdate("master.organisationrole.update",new Object[]{organisationrole.getOrganisation_role(),organisation_role_id});
		return myObject;
		
	}
	
}
