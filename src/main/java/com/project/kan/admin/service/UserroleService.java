package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Userrole;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class UserroleService {

	private static final Logger logger = LoggerFactory.getLogger(UserroleService.class);

    @Autowired
    private MyDao mydao;
    
    public Userrole saveUserrole(@RequestBody Userrole userrole)
    {
    	
        mydao.queryNameForUpdate("master.user_role.add",new Object[] {userrole.getF_role_id(), userrole.getF_user_id()});
        return userrole;
    }

    public List<Userrole> getAllUserrole()
	{
		List<Userrole> allUserrole = mydao.findAll("master.user_role.all",Userrole.class);
		 return allUserrole;		
	}
	
  //Get User_role by id..................//
	public Object getUserrole(@PathVariable("user_role_id") int user_role_id)
	{
		Object myObject = mydao.findById("master.user_role.getById",new Object[]{user_role_id},Userrole.class);
		return myObject;
		
	}
	
	public MasterResponse deleteUserrole(@PathVariable("user_role_id") int user_role_id)
	{
		
//		 districtrepo.deleteById(district_id);
		mydao.delete("master.user_role.delete",new Object[]{user_role_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateUserrole(@RequestBody Userrole userrole,@PathVariable("user_role_id") int user_role_id)
	{
	
		mydao.queryNameForUpdate("master.user_role.update", new Object[]{userrole.getF_role_id(), userrole.getF_user_id(), user_role_id});

	}
	
}
