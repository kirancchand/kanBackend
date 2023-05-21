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

import com.project.kan.admin.service.LocalbodyService;
import com.project.kan.admin.vo.Localbody;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/localbody")
public class LocalbodyController {

	@Autowired
    private LocalbodyService localbodyservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addLocalbody(@RequestBody Localbody localbody)
    {
        return localbodyservice.saveLocalbody(localbody);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllLocalbody()
	{
		
		return localbodyservice.getAllLocalbody();
		
	}
	@RequestMapping("/get/{localbody_id}")
	@ResponseBody
	public MasterResponse getLocalbody(@PathVariable("localbody_id") int localbody_id)
	{
		
		return localbodyservice.getLocalbody(localbody_id);
		
	}
	
	@RequestMapping("/getByDistrict/{f_district_id}")
	@ResponseBody
	public MasterResponse getLocalbodyByDistrict(@PathVariable("f_district_id") int f_district_id)
	{
		
		return localbodyservice.getLocalbodyByDistrict(f_district_id);
		
	}
	
	@RequestMapping("/getByLocalbodytype/{f_localbodytype_id}")
	@ResponseBody
	public MasterResponse getLocalbodyByLocalbodytype(@PathVariable("f_localbodytype_id") int f_localbodytype_id)
	{
		
		return localbodyservice.getLocalbodyByLocalbodytype(f_localbodytype_id);
		
	}
	
	@DeleteMapping("/delete/{localbody_id}")
	@ResponseBody
	public MasterResponse deleteLocalbody(@PathVariable("localbody_id") int localbody_id)
	{
		
		return localbodyservice.deleteLocalbody(localbody_id);
		
	}
	
	@PutMapping("/update/{localbody_id}")
	@ResponseBody
	public MasterResponse updateLocalbody(@RequestBody Localbody localbody, @PathVariable("localbody_id") int localbody_id)
	{
		 return localbodyservice.updateLocalbody(localbody,localbody_id);
	}
	
}
