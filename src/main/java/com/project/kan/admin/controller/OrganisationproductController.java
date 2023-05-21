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

import com.project.kan.admin.service.OrganisationproductService;
import com.project.kan.admin.vo.Organisationproduct;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/organisationproduct")
public class OrganisationproductController {

	@Autowired
    private OrganisationproductService organisationproductservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addOrganisationproduct(@RequestBody Organisationproduct organisationproduct)
    {
        return organisationproductservice.saveOrganisationproduct(organisationproduct);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllOrganisationproduct()
	{

		return organisationproductservice.getAllOrganisationproduct();

	}
	@RequestMapping("/get/{organisation_product_id}")
	@ResponseBody
	public MasterResponse getOrganisationproduct(@PathVariable("organisation_product_id") int organisation_product_id)
	{

		return organisationproductservice.getOrganisationproduct(organisation_product_id);

	}


	@DeleteMapping("/delete/{organisation_product_id}")
	@ResponseBody
	public MasterResponse deleteOrganisationproduct(@PathVariable("organisation_product_id") int organisation_product_id)
	{

		return organisationproductservice.deleteOrganisationproduct(organisation_product_id);

	}
	@PutMapping("/update/{organisation_product_id}")
	@ResponseBody
	public MasterResponse updateOrganisationproduct(@RequestBody Organisationproduct organisationproduct, @PathVariable("organisation_product_id") int organisation_product_id)
	{
		return organisationproductservice.updateOrganisationproduct(organisationproduct, organisation_product_id);
	}

}
