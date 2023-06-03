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

import com.project.kan.security.vo.Users;

@Service
public class UsersService {
    
    private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

    @Autowired
    private MyDao mydao;
    
//null issue
    public MasterResponse getAllUsers()
    {
        List<Users> allUser=mydao.findAll("master.user.all",Users.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allUser);
        return masterResponse;

        
    }
    
    public MasterResponse getUser(@PathVariable("user_id") int user_id)
    {
        Object myObject=mydao.findById("master.user.getById",new Object[]{user_id},Users.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;

        
    }
    
    public MasterResponse deleteUser(@PathVariable("user_id") int user_id)
    {
        
//       staterepo.deleteById(state_id);
        mydao.delete("master.user.delete",new Object[]{user_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Deleted Successfully!!");
        masterResponse.setStatus(200);
        
        return masterResponse;
        
    }
    public MasterResponse updateUser(@RequestBody Users user,@PathVariable("user_id") int user_id)
    {
    
        long myObject=mydao.queryForUpdate("master.user.update",new Object[]{user.getFirst_name(),user.getMiddle_name(),user.getLast_name(),user.getEmail_id(),user.getMobno(),user.getDateofbirth(),user.getGender(),user.getF_branch_id(),user.getF_status_id(),user.getF_usertype_id(),user.getF_caste_id(),user.getF_education_id(),user.getF_personal_document_id(),user_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(user);
        return masterResponse;
//      return state.getState();
        
    }
}
