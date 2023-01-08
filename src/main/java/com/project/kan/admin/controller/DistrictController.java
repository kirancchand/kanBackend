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

import com.project.kan.admin.service.DistrictService;
import com.project.kan.admin.vo.District;

@RestController
@RequestMapping("/master/district")
public class DistrictController {

    @Autowired
    private DistrictService districtservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public District addDistrict(@RequestBody District district)
    {
        return districtservice.saveDistrict(district);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<District> getAllDistrict()
	{
		
		return districtservice.getAllDistrict();
		
	}
	@RequestMapping("/get/{district_id}")
	@ResponseBody
	public Object getDistrict(@PathVariable("district_id") int district_id)
	{
		
		return districtservice.getDistrict(district_id);
		
	}
	
	
	@RequestMapping("/getByState/{state_id}")
	@ResponseBody
	public List getDistrictByState(@PathVariable("state_id") int state_id)
	{

		return districtservice.getDistrictByState(state_id);
		
	}
	
	@DeleteMapping("/delete/{district_id}")
	@ResponseBody
	public void deleteDistrict(@PathVariable("district_id") int district_id)
	{
		
		districtservice.deleteDistrict(district_id);
		
	}
	@PutMapping("/update/{district_id}")
	@ResponseBody
	public void updateDistrict(@RequestBody District district,@PathVariable("district_id") int district_id)
	{
		 districtservice.updateDistrict(district,district_id);
	}

}
