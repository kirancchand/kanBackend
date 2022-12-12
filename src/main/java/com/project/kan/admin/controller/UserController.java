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

import com.project.kan.admin.service.UserService;
import com.project.kan.admin.vo.User;

@RestController
@RequestMapping("/master/user")
public class UserController {
	
	@Autowired
    private UserService userservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public User addUser(@RequestBody User user)
    {
        return userservice.saveUser(user);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<User> getAllUser()
	{
		
		return userservice.getAllUser();
		
	}
	@RequestMapping("/get/{id}")
	@ResponseBody
	public Object getUser(@PathVariable("id") int id)
	{
		
		return userservice.getUser(id);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") int id)
	{
		
		userservice.deleteUser(id);
		
	}
	@PutMapping("/update/{id}")
	@ResponseBody
	public void updateUser(@RequestBody User user, @PathVariable("id") int id)
	{
		 userservice.updateUser(user,id);
	}

}
