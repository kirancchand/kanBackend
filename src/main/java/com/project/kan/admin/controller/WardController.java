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

import com.project.kan.admin.service.WardService;
import com.project.kan.admin.vo.Ward;

@RestController
@RequestMapping("/master/ward")
public class WardController {
	
	@Autowired
    private WardService wardservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }
    
    @PostMapping("/add")
    public Ward addWard(@RequestBody Ward ward)
    {
        return wardservice.saveWard(ward);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Ward> getAllWard()
	{
		
		return wardservice.getAllWard();
		
	}
    
	@RequestMapping("/get/{ward_id}")
	@ResponseBody
	public Object getWard(@PathVariable("ward_id") int ward_id)
	{
		
		return wardservice.getWard(ward_id);
		
	}
	
	@RequestMapping("/getByLocalbody/{f_localbody_id}")
	@ResponseBody
	public Object getWardByLocalbody(@PathVariable("f_localbody_id") int f_localbody_id)
	{
		
		return wardservice.getWardByLocalbody(f_localbody_id);
		
	}
	
	@DeleteMapping("/delete/{ward_id}")
	@ResponseBody
	public void deleteWard(@PathVariable("ward_id") int ward_id)
	{
		
		wardservice.deleteWard(ward_id);
		
	}
	@PutMapping("/update/{ward_id}")
	@ResponseBody
	public void updateWard(@RequestBody Ward ward, @PathVariable("wardid") int ward_id)
	{
		 wardservice.updateWard(ward,ward_id);
	}

}
