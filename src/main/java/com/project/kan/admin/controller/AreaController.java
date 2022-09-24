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

import com.project.kan.admin.service.AreaService;
import com.project.kan.admin.vo.Area;

@RestController
@RequestMapping("/master/area")
public class AreaController {
    @Autowired
    private AreaService areaservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Area addArea(@RequestBody Area area)
    {
        return areaservice.saveArea(area);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Area> getAllArea()
	{
		
		return areaservice.getAllArea();
		
	}
	@RequestMapping("/get/{area_id}")
	@ResponseBody
	public Object getArea(@PathVariable("area_id") int area_id)
	{
		
		return areaservice.getArea(area_id);
		
	}
	
	@RequestMapping("/getByDistrict/{district_id}")
	@ResponseBody
	public Object getAreaByDistrict(@PathVariable("district_id") int district_id)
	{
		
		return areaservice.getAreaByDistrict(district_id);
		
	}
	
	@DeleteMapping("/delete/{area_id}")
	@ResponseBody
	public void deleteArea(@PathVariable("area_id") int area_id)
	{
		
		areaservice.deleteArea(area_id);
		
	}
	@PutMapping("/update/{area_id}")
	@ResponseBody
	public void updateArea(@RequestBody Area area,@PathVariable("area_id") int area_id)
	{
		 areaservice.updateArea(area,area_id);
	}

}
