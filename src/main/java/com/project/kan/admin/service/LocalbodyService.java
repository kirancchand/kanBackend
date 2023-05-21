package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.District;
import com.project.kan.admin.vo.Localbody;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class LocalbodyService {

	private static final Logger logger = LoggerFactory.getLogger(LocalbodyService.class);

    @Autowired
    private MyDao mydao;
    
    public MasterResponse saveLocalbody(@RequestBody Localbody localbody)
    {
    	
        mydao.queryNameForUpdate("master.localbody.add",new Object[] {localbody.getF_district_id(), localbody.getF_localbodytype_id(), localbody.getLocalbody_name()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(localbody);
        return masterResponse;
    }

    public MasterResponse getAllLocalbody()
	{
		List<Localbody> allLocalbody = mydao.findAll("master.localbody.all",Localbody.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allLocalbody);
        return masterResponse;	
	}
	
  //Get local body by criteria..................//
	public MasterResponse getLocalbody(@PathVariable("localbody_id") int localbody_id)
	{
		Object myObject = mydao.findById("master.localbody.getById",new Object[]{localbody_id},Localbody.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	public MasterResponse getLocalbodyByDistrict(@PathVariable("f_district_id") int f_district_id)
	{
	    List<Localbody> byDistrict = mydao.findListById("master.localbody.getByDistrict",new Object[]{f_district_id},Localbody.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byDistrict);
        return masterResponse;
		
	}
	
	public MasterResponse getLocalbodyByLocalbodytype(@PathVariable("f_localbodytype_id") int f_localbodytype_id)
	{
	    List<Localbody> byLocalbodytype = mydao.findListById("master.localbody.getByLocalbodytype",new Object[]{f_localbodytype_id},Localbody.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byLocalbodytype);
        return masterResponse;
		
	}
	
	public MasterResponse deleteLocalbody(@PathVariable("localbody_id") int localbody_id)
	{
		
//		 districtrepo.deleteById(district_id);
		mydao.delete("master.localbody.delete",new Object[]{localbody_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public MasterResponse updateLocalbody(@RequestBody Localbody localbody,@PathVariable("localbody_id") int localbody_id)
	{
	
		mydao.queryNameForUpdate("master.localbody.update", new Object[]{localbody.getF_district_id(), localbody.getF_localbodytype_id(), localbody.getLocalbody_name(), localbody_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(localbody);
        return masterResponse;
	}
}
