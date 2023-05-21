package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Organisationproduct;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class OrganisationproductService {

	private static final Logger logger = LoggerFactory.getLogger(OrganisationproductService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse saveOrganisationproduct(@RequestBody Organisationproduct organisationproduct)
    {

        mydao.queryNameForUpdate("master.organisationproduct.add",new Object[]{
          organisationproduct.getF_organisation_id(),
          organisationproduct.getF_product_id(),
          organisationproduct.getProduct_price(),
          organisationproduct.getProduct_qty(),
          organisationproduct.getProduct_desc()
        });
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(organisationproduct);
        return masterResponse;

    }

    public MasterResponse getAllOrganisationproduct()
	{
		List<Organisationproduct> allOrganisationproduct = mydao.findAll("master.organisationproduct.all",Organisationproduct.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allOrganisationproduct);
        return masterResponse;

	}


	public MasterResponse getOrganisationproduct(@PathVariable("organisation_product_id") int organisation_product_id)
	{
		Object myObject = mydao.findById("master.organisationproduct.getById",new Object[]{organisation_product_id},Organisationproduct.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

	}



	public MasterResponse deleteOrganisationproduct(@PathVariable("organisation_product_id") int organisation_product_id)
	{

		mydao.delete("master.organisationproduct.delete",new Object[]{organisation_product_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;

	}

	public MasterResponse updateOrganisationproduct(@RequestBody Organisationproduct organisationproduct,@PathVariable("organisation_product_id") int organisation_product_id)
	{

		mydao.queryNameForUpdate("master.organisationproduct.update", new Object[]{
        organisationproduct.getF_organisation_id(),
        organisationproduct.getF_product_id(),
        organisationproduct.getProduct_price(),
        organisationproduct.getProduct_qty(),
        organisationproduct.getProduct_desc(),
        organisation_product_id
      });
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(organisationproduct);
        return masterResponse;

	}
}
