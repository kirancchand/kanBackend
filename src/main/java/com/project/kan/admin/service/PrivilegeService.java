package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Privilege;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class PrivilegeService {

	private static final Logger logger = LoggerFactory.getLogger(PrivilegeService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse savePrivilege(@RequestBody Privilege privilege)
    {

        mydao.queryNameForUpdate("master.privilege.add",new Object[] {privilege.getPrivilege()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(privilege);
        return masterResponse;
    }

    public MasterResponse getAllPrivilege()
	{
		List<Privilege> allPrivilege = mydao.findAll("master.privilege.all",Privilege.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allPrivilege);
        return masterResponse;
	}


	public MasterResponse getPrivilege(@PathVariable("privilege_id") int privilege_id)
	{
		Object myObject = mydao.findById("master.privilege.getById",new Object[]{privilege_id},Privilege.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

	}


	public MasterResponse deletePrivilege(@PathVariable("privilege_id") int privilege_id)
	{

		mydao.delete("master.privilege.delete",new Object[]{privilege_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;

	}

	public MasterResponse updatePrivilege(@RequestBody Privilege privilege,@PathVariable("privilege_id") int privilege_id)
	{
	
		mydao.queryNameForUpdate("master.privilege.update", new Object[]{privilege.getPrivilege(), privilege_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(privilege);
        return masterResponse;

	}
}
