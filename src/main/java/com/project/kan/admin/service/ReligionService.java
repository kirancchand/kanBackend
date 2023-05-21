package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Religion;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class ReligionService {
	
	private static final Logger logger = LoggerFactory.getLogger(ReligionService.class);

	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveReligion(@RequestBody Religion religion)
	{
//	    return religion;
		Long a = mydao.queryForSave("master.religion.add",new Object[] {religion.getReligion()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(religion);
        return masterResponse;
//		if(a!=0)
//			return religion;
//		else
//			return null;
		
		
	}
	public MasterResponse getAllReligion()
	{
		List<Religion> allReligion = mydao.findAll("master.religion.all",Religion.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allReligion);
        return masterResponse;

		
	}
	
	public MasterResponse getReligion(@PathVariable("religion_id") int religion_id)
	{
		Object myObject = mydao.findById("master.religion.getById",new Object[]{religion_id},Religion.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	public MasterResponse deleteReligion(@PathVariable("religion_id") int religion_id)
	{
		

		mydao.delete("master.religion.delete",new Object[]{religion_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public MasterResponse updateReligion(@RequestBody Religion religion, @PathVariable("religion_id") int religion_id)
	{
	
		long myObject = mydao.queryForUpdate("master.religion.update", new Object[]{religion.getReligion(),religion_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(religion);
        return masterResponse;
//		return religion.getReligion();
		
	}

}
