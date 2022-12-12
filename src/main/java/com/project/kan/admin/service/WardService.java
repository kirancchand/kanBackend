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
    
    public Ward saveWard(@RequestBody Ward ward)
    {
    	
        mydao.queryNameForUpdate("master.ward.add",new Object[] {ward.getF_localbody_id(), ward.getWard(), ward.getWard_no() });
        return ward;
    }

    public List<Ward> getAllWard()
	{
		List<Ward> allWard = mydao.findAll("master.ward.all",Ward.class);
		 return allWard;		
	}
    
    public Object getWard(@PathVariable("ward_id") int ward_id)
	{
		Object myObject = mydao.findById("master.ward.getById",new Object[]{ward_id},Ward.class);
		return myObject;
		
	}
    
    public List<Ward> getWardByLocalbody(@PathVariable("f_localbody_id") int f_localbody_id)
	{
	    List<Ward> byLocalbody = mydao.findListById("master.localbody.getByLocalbdody",new Object[]{f_localbody_id},Ward.class);
		return byLocalbody;
	}
    
    public MasterResponse deleteWard(@PathVariable("ward_id") int ward_id)
	{
		
		mydao.delete("master.ward.delete",new Object[]{ward_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateWard(@RequestBody Ward ward,@PathVariable("ward_id") int ward_id)
	{
	
		mydao.queryNameForUpdate("master.ward.update", new Object[]{ward.getF_localbody_id(),ward.getWard(),ward.getWard_no(), ward_id});

	}

}
