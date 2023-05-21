package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.District;
import com.project.kan.admin.vo.Region;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class RegionService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private MyDao mydao;
    
    public MasterResponse saveRegion(@RequestBody Region region)
    {
        
        mydao.queryNameForUpdate("master.region.add",new Object[] {region.getRegion(),region.getF_district_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(region);
        return masterResponse;
    }

    public MasterResponse getAllRegion()
    {
        List<Region> allRegion=mydao.findAll("master.region.all",Region.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allRegion);
        return masterResponse;
        
    }
    
    public MasterResponse getRegion(@PathVariable("region_id") int region_id)
    {
        Object myObject=mydao.findById("master.region.getById",new Object[]{region_id},Region.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
        
    }
    
    public MasterResponse getRegionByDistrict(@PathVariable("district_id") int district_id)
    {
        List<Region> byDistrict=mydao.findListById("master.region.getByDistrict",new Object[]{district_id},Region.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byDistrict);
        return masterResponse;
        
    }
    
    public MasterResponse deleteRegion(@PathVariable("region_id") int region_id)
    {
        
//       districtrepo.deleteById(district_id);
        mydao.delete("master.region.delete",new Object[]{region_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Deleted Successfully!!");
        masterResponse.setStatus(200);
        return masterResponse;
        
    }
    
    public MasterResponse updateRegion(@RequestBody Region region,@PathVariable("region_id") int region_id)
    {
    
        mydao.queryNameForUpdate("master.region.update",new Object[]{region.getRegion(),region.getF_district_id(),region_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(region);
        return masterResponse;
//      return myObject;
//      return district.getDistrict();
        
    }
    
}
