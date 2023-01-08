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
    public Localbody addLocalbody(@RequestBody Localbody localbody)
    {
        return localbodyservice.saveLocalbody(localbody);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Localbody> getAllLocalbody()
	{
		
		return localbodyservice.getAllLocalbody();
		
	}
	@RequestMapping("/get/{localbody_id}")
	@ResponseBody
	public Object getLocalbody(@PathVariable("localbody_id") int localbody_id)
	{
		
		return localbodyservice.getLocalbody(localbody_id);
		
	}
	
	@RequestMapping("/getByDistrict/{f_district_id}")
	@ResponseBody
	public Object getLocalbodyByDistrict(@PathVariable("f_district_id") int f_district_id)
	{
		
		return localbodyservice.getLocalbodyByDistrict(f_district_id);
		
	}
	
	@RequestMapping("/getByLocalbodytype/{f_localbodytype_id}")
	@ResponseBody
	public Object getLocalbodyByLocalbodytype(@PathVariable("f_localbodytype_id") int f_localbodytype_id)
	{
		
		return localbodyservice.getLocalbodyByLocalbodytype(f_localbodytype_id);
		
	}
	
	@DeleteMapping("/delete/{localbody_id}")
	@ResponseBody
	public void deleteLocalbody(@PathVariable("localbody_id") int localbody_id)
	{
		
		localbodyservice.deleteLocalbody(localbody_id);
		
	}
	
	@PutMapping("/update/{localbody_id}")
	@ResponseBody
	public void updateLocalbody(@RequestBody Localbody localbody, @PathVariable("localbody_id") int localbody_id)
	{
		 localbodyservice.updateLocalbody(localbody,localbody_id);
	}
	
}
