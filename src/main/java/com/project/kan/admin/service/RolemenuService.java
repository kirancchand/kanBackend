package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Rolemenu;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class RolemenuService {

	private static final Logger logger = LoggerFactory.getLogger(RolemenuService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse saveRolemenu(@RequestBody Rolemenu rolemenu)
    {

        mydao.queryNameForUpdate("master.rolemenu.add",new Object[] {rolemenu.getF_menu_id(), rolemenu.getF_role_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(rolemenu);
        return masterResponse;
    }

    public MasterResponse getAllRolemenu()
	{
		List<Rolemenu> allRolemenu = mydao.findAll("master.rolemenu.all",Rolemenu.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allRolemenu);
        return masterResponse;
	}


	public MasterResponse getRolemenu(@PathVariable("role_menu_id") int role_menu_id)
	{
		Object myObject = mydao.findById("master.rolemenu.getById",new Object[]{role_menu_id},Rolemenu.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

	}

	public MasterResponse deleteRolemenu(@PathVariable("role_menu_id") int role_menu_id)
	{

		mydao.delete("master.rolemenu.delete",new Object[]{role_menu_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;

	}

	public MasterResponse updateRolemenu(@RequestBody Rolemenu rolemenu,@PathVariable("role_menu_id") int role_menu_id)
	{

		mydao.queryNameForUpdate("master.rolemenu.update", new Object[]{rolemenu.getF_menu_id(), rolemenu.getF_role_id(), role_menu_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(rolemenu);
        return masterResponse;

	}
  
}
