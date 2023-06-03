package com.project.kan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.kan.admin.service.UsersService;
import com.project.kan.admin.vo.State;
import com.project.kan.common.vo.MasterResponse;
import com.project.kan.security.vo.Users;

@RestController
@RequestMapping("/master/users")
public class UserController {
    @Autowired
    private UsersService usersservice;
    
    @RequestMapping("/index")
    @ResponseBody
    public String index()
    {
        return "index";
    }

//    @PostMapping("/add")
//    public MasterResponse addState(@RequestBody State state)
//    {
//        return usersservice.saveState(state);
//    }
    
    
    
    @RequestMapping("/getAll")
    @ResponseBody
    public MasterResponse getAllUsers()
    {
        
        return usersservice.getAllUsers();
        
    }
    @RequestMapping("/get/{user_id}")
    @ResponseBody
    public MasterResponse getUser(@PathVariable("user_id") int user_id)
    {
        
        return usersservice.getUser(user_id);
        
    }
    @DeleteMapping("/delete/{user_id}")
    @ResponseBody
    public MasterResponse deleteUser(@PathVariable("user_id") int user_id)
    {
        
        return usersservice.deleteUser(user_id);
        
    }
    @PutMapping("/update/{user_id}")
    @ResponseBody
    public MasterResponse updateUser(@RequestBody Users user,@PathVariable("user_id") int user_id)
    {
        return usersservice.updateUser(user,user_id);
    }

}
