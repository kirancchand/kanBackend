package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.District;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class DistrictService {
    private static final Logger logger = LoggerFactory.getLogger(DistrictService.class);

    @Autowired
    private MyDao mydao;

    public District saveDistrict(@RequestBody District district)
    {
    	
        mydao.queryNameForUpdate("master.district.add",new Object[] {district.getDistrict(),district.getF_state_id()});
        return district;
    }

    public List<District> getAllDistrict()
	{
		List<District> allDistrict=mydao.findAll("master.district.all",District.class);
		 return allDistrict;
		
	}
	
	public Object getDistrict(@PathVariable("district_id") int district_id)
	{
		Object myObject=mydao.findById("master.district.getById",new Object[]{district_id},District.class);
		return myObject;
		
	}
	
	public List getDistrictByState(@PathVariable("state_id") int state_id)
	{
	    List<District> byState=mydao.findListById("master.district.getByState",new Object[]{state_id},District.class);
		return byState;
		
	}
	
	public MasterResponse deleteDistrict(@PathVariable("district_id") int district_id)
	{
		
//		 districtrepo.deleteById(district_id);
		mydao.delete("master.district.delete",new Object[]{district_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateDistrict(@RequestBody District district,@PathVariable("district_id") int district_id)
	{
	
		mydao.queryNameForUpdate("master.district.update",new Object[]{district.getDistrict(),district.getF_state_id(),district_id});
//		return myObject;
//		return district.getDistrict();
		
	}

}
