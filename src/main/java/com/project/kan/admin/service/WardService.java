package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Localbody;
import com.project.kan.admin.vo.Ward;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class WardService {
	
	private static final Logger logger = LoggerFactory.getLogger(WardService.class);

    @Autowired
    private MyDao mydao;
    
    public MasterResponse saveWard(@RequestBody Ward ward)
    {
    	
        mydao.queryNameForUpdate("master.ward.add",new Object[] {ward.getF_localbody_id(), ward.getWard(), ward.getWard_no() });
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(ward);
        return masterResponse;
    }

    public MasterResponse getAllWard()
	{
		List<Ward> allWard = mydao.findAll("master.ward.all",Ward.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allWard);
        return masterResponse;		
	}
    
    public MasterResponse getWard(@PathVariable("ward_id") int ward_id)
	{
		Object myObject = mydao.findById("master.ward.getById",new Object[]{ward_id},Ward.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
    
    public MasterResponse getWardByLocalbody(@PathVariable("f_localbody_id") int f_localbody_id)
	{
	    List<Ward> byLocalbody = mydao.findListById("master.localbody.getByLocalbdody",new Object[]{f_localbody_id},Ward.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byLocalbody);
        return masterResponse;
	}
    
    public MasterResponse deleteWard(@PathVariable("ward_id") int ward_id)
	{
		
		mydao.delete("master.ward.delete",new Object[]{ward_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public MasterResponse updateWard(@RequestBody Ward ward,@PathVariable("ward_id") int ward_id)
	{
	
		mydao.queryNameForUpdate("master.ward.update", new Object[]{ward.getF_localbody_id(),ward.getWard(),ward.getWard_no(), ward_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(ward);
        return masterResponse;
	}

}
