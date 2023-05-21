package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Caste;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class CasteService {
	
	private static final Logger logger = LoggerFactory.getLogger(CasteService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse saveCaste(@RequestBody Caste caste)
    {
    	
        mydao.queryNameForUpdate("master.caste.add",new Object[] {caste.getCaste(),caste.getF_religion_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(caste);
        return masterResponse;
    }

    public MasterResponse getAllCaste()
	{
		List<Caste> allCaste = mydao.findAll("master.caste.all", Caste.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allCaste);
        return masterResponse;
		
	}
	
	public MasterResponse getCaste(@PathVariable("caste_id") int caste_id)
	{
		Object myObject = mydao.findById("master.caste.getById",new Object[]{caste_id},Caste.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
		return masterResponse;
		
	}
	
	public MasterResponse getCasteByReligion(@PathVariable("religion_id") int religion_id)
	{
	    List<Caste> byReligion = mydao.findListById("master.caste.getByReligion",new Object[]{religion_id},Caste.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byReligion);
		return masterResponse;
		
	}
	
	public MasterResponse deleteCaste(@PathVariable("caste_id") int caste_id)
	{
		
//		 casterepo.deleteById(caste_id);
		mydao.delete("master.caste.delete",new Object[]{caste_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public MasterResponse updateCaste(@RequestBody Caste caste,@PathVariable("caste_id") int caste_id)
	{
	
		mydao.queryNameForUpdate("master.caste.update",new Object[]{caste.getCaste(),caste.getF_religion_id(),caste_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(caste);
        return masterResponse;
		
	}


}
