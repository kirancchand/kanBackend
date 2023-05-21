package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;
import com.project.kan.security.vo.UserResponse;
import com.project.kan.admin.service.ServicetableService;
import com.project.kan.admin.vo.Servicetable;

@Service
public class ServicetableService {
	
	private static final Logger logger = LoggerFactory.getLogger(ServicetableService.class);

	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveServicetable(@RequestBody Servicetable servicetable)
	{
		Long a=mydao.queryForSave("master.service.add",new Object[] {servicetable.getService()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(servicetable);
        return masterResponse;
//		if(a!=0)
//			return servicetable;
//			
//		else
//			return null;
		
	}
	public MasterResponse getAllServicetable()
	{
		List<Servicetable> allServicetable=mydao.findAll("master.service.all", Servicetable.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allServicetable);
        return masterResponse;
		
	}
	
	public MasterResponse getServicetable(@PathVariable("service_id") int service_id)
	{
		Object myObject=mydao.findById("master.service.getById",new Object[]{service_id},Servicetable.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	public MasterResponse deleteServicetable(@PathVariable("service_id") int service_id)
	{
		mydao.delete("master.service.delete",new Object[]{service_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public MasterResponse updateServicetable(@RequestBody Servicetable servicetable,@PathVariable("service_id") int service_id)
	{
	
		long myObject=mydao.queryForUpdate("master.service.update",new Object[]{servicetable.getService(),service_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(servicetable);
        return masterResponse;
		
	}

}
