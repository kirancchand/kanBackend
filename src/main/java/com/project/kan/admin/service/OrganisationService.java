package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Organisation;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class OrganisationService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrganisationService.class);

	  @Autowired
	  private MyDao mydao;

	  public Organisation saveOrganisation(@RequestBody Organisation organisation)
	  {

	      mydao.queryNameForUpdate("master.organisation.add",new Object[] {organisation.getOrganisation(), organisation.getF_organisation_type_id()});
	      return organisation;
	  }

	  public List<Organisation> getAllOrganisation()
	{
	  List<Organisation> allOrganisation = mydao.findAll("master.organisation.all",Organisation.class);
	   return allOrganisation;
	}


	public Object getOrganisation(@PathVariable("organisation_id") int organisation_id)
	{
	  Object myObject = mydao.findById("master.organisation.getById",new Object[]{organisation_id},Organisation.class);
	  return myObject;

	}

	public List<Organisation> getOrganisationByOrganisationtype(@PathVariable("f_organisation_type_id") int f_organisation_type_id)
	{
	    List<Organisation> byOrganisationtype = mydao.findListById("master.organisation.getByOrganisationtype",new Object[]{f_organisation_type_id},Organisation.class);
	  return byOrganisationtype;

	}


	public MasterResponse deleteOrganisation(@PathVariable("organisation_id") int organisation_id)
	{

	  mydao.delete("master.organisation.delete",new Object[]{organisation_id});
	  MasterResponse masterResponse = new MasterResponse();
	  masterResponse.setMessage("Deleted Successfully!!");
	  masterResponse.setStatus(200);
	  return masterResponse;

	}

	public void updateOrganisation(@RequestBody Organisation organisation,@PathVariable("organisation_id") int organisation_id)
	{

	  mydao.queryNameForUpdate("master.organisation.update", new Object[]{organisation.getOrganisation(), organisation.getF_organisation_type_id(), organisation_id});

	}

}
