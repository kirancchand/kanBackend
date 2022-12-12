package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Rolemenuprivilege;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class RolemenuprivilegeService {
	
	private static final Logger logger = LoggerFactory.getLogger(RolemenuprivilegeService.class);

    @Autowired
    private MyDao mydao;
    
    public Rolemenuprivilege saveRolemenuprivilege(@RequestBody Rolemenuprivilege rolemenuprivilege)
    {
    	
        mydao.queryNameForUpdate("master.rolemenuprivilege.add",new Object[] {rolemenuprivilege.getF_role_menu_id(), rolemenuprivilege.getPrivilege_id()});
        return rolemenuprivilege;
    }

    public List<Rolemenuprivilege> getAllRolemenuprivilege()
	{
		List<Rolemenuprivilege> allRolemenuprivilege = mydao.findAll("master.rolemenuprivilege.all",Rolemenuprivilege.class);
		 return allRolemenuprivilege;		
	}
    
    public Object getRolemenuprivilege(@PathVariable("role_menu_privilege_id") int role_menu_privilege_id)
	{
		Object myObject = mydao.findById("master.rolemenuprivilege.getById",new Object[]{role_menu_privilege_id},Rolemenuprivilege.class);
		return myObject;
		
	}
    
    public MasterResponse deleteRolemenuprivilege(@PathVariable("role_menu_privilege_id") int role_menu_privilege_id)
	{
		
		mydao.delete("master.rolemenuprivilege.delete",new Object[]{role_menu_privilege_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateRolemenuprivilege(@RequestBody Rolemenuprivilege rolemenuprivilege,@PathVariable("role_menu_privilege_id") int role_menu_privilege_id)
	{
	
		mydao.queryNameForUpdate("master.rolemenuprivilege.update", new Object[]{rolemenuprivilege.getF_role_menu_id(), rolemenuprivilege.getPrivilege_id(), role_menu_privilege_id});

	}

}
