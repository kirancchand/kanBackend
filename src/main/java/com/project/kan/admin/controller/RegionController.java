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

import com.project.kan.admin.service.RegionService;
import com.project.kan.admin.vo.District;
import com.project.kan.admin.vo.Region;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/region")
public class RegionController {
    
    @Autowired
    private RegionService regionservice;
    
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }
    
    @PostMapping("/add")
    public MasterResponse addRegion(@RequestBody Region region)
    {
        return regionservice.saveRegion(region);
    }

    @RequestMapping("/getAll")
    @ResponseBody
    public MasterResponse getAllRegion()
    {
        
        return regionservice.getAllRegion();
        
    }
    
    @RequestMapping("/get/{region_id}")
    @ResponseBody
    public MasterResponse getRegion(@PathVariable("region_id") int region_id)
    {
        
        return regionservice.getRegion(region_id);
        
    }
    
    
    @RequestMapping("/getByDistrict/{district_id}")
    @ResponseBody
    public MasterResponse getRegionByDistrict(@PathVariable("district_id") int district_id)
    {

        return regionservice.getRegionByDistrict(district_id);
        
    }
    
    @DeleteMapping("/delete/{region_id}")
    @ResponseBody
    public MasterResponse deleteRegion(@PathVariable("region_id") int region_id)
    {
        
        return regionservice.deleteRegion(region_id);
        
    }
    
    @PutMapping("/update/{region_id}")
    @ResponseBody
    public MasterResponse updateRegion(@RequestBody Region region,@PathVariable("region_id") int region_id)
    {
        return regionservice.updateRegion(region,region_id);
    }
    

}
