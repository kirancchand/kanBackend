package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Role;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class RoleService {

	private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    @Autowired
    private MyDao mydao;

    public Role saveRole(@RequestBody Role role)
    {

        mydao.queryNameForUpdate("master.role.add",new Object[] {role.getRole()});
        return role;
    }

    public List<Role> getAllRole()
	{
		List<Role> allRole = mydao.findAll("master.role.all",Role.class);
		 return allRole;
	}


	public Object getRole(@PathVariable("role_id") int role_id)
	{
		Object myObject = mydao.findById("master.role.getById",new Object[]{role_id},Role.class);
		return myObject;

	}


	public MasterResponse deleteRole(@PathVariable("role_id") int role_id)
	{

		mydao.delete("master.role.delete",new Object[]{role_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;

	}

	public void updateRole(@RequestBody Role role,@PathVariable("role_id") int role_id)
	{

		mydao.queryNameForUpdate("master.role.update", new Object[]{role.getRole(), role_id});

	}
}
