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

import com.project.kan.admin.service.LocalbodytypeService;
import com.project.kan.admin.vo.Localbodytype;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/localbodytype")
public class LocalbodytypeController {

	@Autowired
	private LocalbodytypeService localbodytypeservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addLocalbodytype(@RequestBody Localbodytype localbodytype)
	{
		return localbodytypeservice.saveLocalbodytype(localbodytype);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllLocalbodytype()
	{
		
		return localbodytypeservice.getAllLocalbodytype();
		
	}
	@RequestMapping("/get/{localbodytype_id}")
	@ResponseBody
	public MasterResponse getLocalbodytype(@PathVariable("localbodytype_id") int localbodytype_id)
	{
		
		return localbodytypeservice.getLocalbodytype(localbodytype_id);
		
	}
	@DeleteMapping("/delete/{localbodytype_id}")
	@ResponseBody
	public MasterResponse deleteLocalbodytype(@PathVariable("localbodytype_id") int localbodytype_id)
	{
		
		return localbodytypeservice.deleteLocalbodytype(localbodytype_id);
		
	}
	@PutMapping("/update/{localbodytype_id}")
	@ResponseBody
	public MasterResponse updateLocalbodytype(@RequestBody Localbodytype localbodytype,@PathVariable("localbodytype_id") int localbodytype_id)
	{
		return localbodytypeservice.updateLocalbodytype(localbodytype,localbodytype_id);
	}

	
}
