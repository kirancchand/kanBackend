package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Staff;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;


@Service
public class StaffService {
	
	private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

	@Autowired
	private MyDao mydao;
	
	public MasterResponse saveStaff(@RequestBody Staff staff)
	{
		Long a=mydao.queryForSave("master.staff.add",new Object[] {staff.getF_user_id()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(staff);
        return masterResponse;
//		if(a!=0)
//			return staff;
//			
//		else
//			return null;
		
	}
	
	public MasterResponse getAllStaff()
	{
		List<Staff> allStaff = mydao.findAll("master.staff.all",Staff.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allStaff);
        return masterResponse;
		
	}
	
	public MasterResponse getStaff(@PathVariable("staff_id") int staff_id)
	{
		Object myObject = mydao.findById("master.staff.getById",new Object[]{staff_id},Staff.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	public MasterResponse deleteStaff(@PathVariable("staff_id") int staff_id)
	{
		
		mydao.delete("master.staff.delete",new Object[]{staff_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public MasterResponse updateStaff(@RequestBody Staff staff,@PathVariable("staff_id") int staff_id)
	{
	
		long myObject=mydao.queryForUpdate("master.staff.update",new Object[]{staff.getF_user_id(),staff_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(staff);
        return masterResponse;
		
	}
	

}
