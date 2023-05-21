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
import com.project.kan.common.vo.MasterResponse;
import com.project.kan.common.vo.SearchRequest;
import com.project.kan.common.vo.SearchResponse;

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
    public MasterResponse addArea(@RequestBody Area area)
    {
        return areaservice.saveArea(area);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllArea()
	{
		
		return areaservice.getAllArea();
		
	}
	@RequestMapping("/get/{area_id}")
	@ResponseBody
	public MasterResponse getArea(@PathVariable("area_id") int area_id)
	{
		
		return areaservice.getArea(area_id);
		
	}
	
	@RequestMapping("/getByRegion/{region_id}")
    @ResponseBody
    public MasterResponse getAreaByRegion(@PathVariable("region_id") int region_id)
    {
        
        return areaservice.getAreaByRegion(region_id);
        
    }
	
//	@RequestMapping("/getByDistrict/{district_id}")
//	@ResponseBody
//	public List getAreaByDistrict(@PathVariable("district_id") int district_id)
//	{
//		
//		return areaservice.getAreaByDistrict(district_id);
//		
//	}
	
	@RequestMapping("/getByLocalbodyType/{localbodytype_id}")
    @ResponseBody
    public MasterResponse getAreabyLocalbodyType(@PathVariable("localbodytype_id") int localbodytype_id)
    {
        
        return areaservice.getAreabyLocalbodyType(localbodytype_id);
        
    }
	
	@DeleteMapping("/delete/{area_id}")
	@ResponseBody
	public MasterResponse deleteArea(@PathVariable("area_id") int area_id)
	{
		
		return areaservice.deleteArea(area_id);
		
	}
	@PutMapping("/update/{area_id}")
	@ResponseBody
	public MasterResponse updateArea(@RequestBody Area area,@PathVariable("area_id") int area_id)
	{
		 return areaservice.updateArea(area,area_id);
	}
	
	@RequestMapping("/searchArea")
    @ResponseBody
    public MasterResponse searchArea(@RequestBody SearchRequest searchrequest)
    {
        
        return areaservice.searchArea(searchrequest);
        
    }

}
