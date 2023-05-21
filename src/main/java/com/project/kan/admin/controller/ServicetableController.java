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

import com.project.kan.admin.service.ServicetableService;
import com.project.kan.admin.vo.Servicetable;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/service")
public class ServicetableController {
	
	@Autowired
	private ServicetableService servicetableservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public MasterResponse addServicetable(@RequestBody Servicetable servicetable)
	{
		return servicetableservice.saveServicetable(servicetable);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllServicetable()
	{
		
		return servicetableservice.getAllServicetable();
		
	}
	@RequestMapping("/get/{service_id}")
	@ResponseBody
	public MasterResponse getServicetable(@PathVariable("service_id") int service_id)
	{
		
		return servicetableservice.getServicetable(service_id);
		
	}
	@DeleteMapping("/delete/{service_id}")
	@ResponseBody
	public MasterResponse deleteServicetable(@PathVariable("service_id") int service_id)
	{
		
		return servicetableservice.deleteServicetable(service_id);
		
	}
	@PutMapping("/update/{service_id}")
	@ResponseBody
	public MasterResponse updateServicetable(@RequestBody Servicetable servicetable,@PathVariable("service_id") int service_id)
	{
		return servicetableservice.updateServicetable(servicetable,service_id);
	}

}
