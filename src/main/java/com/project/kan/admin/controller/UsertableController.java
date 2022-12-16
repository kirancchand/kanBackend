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

import com.project.kan.admin.service.UsertableService;
import com.project.kan.admin.vo.Usertable;

@RestController
@RequestMapping("/master/usertable")
public class UsertableController {
	
	@Autowired
    private UsertableService usertableservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Usertable addUser(@RequestBody Usertable usertable)
    {
        return usertableservice.saveUser(usertable);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Usertable> getAllUser()
	{
		
		return usertableservice.getAllUser();
		
	}
	@RequestMapping("/get/{id}")
	@ResponseBody
	public Object getUser(@PathVariable("id") int id)
	{
		
		return usertableservice.getUser(id);
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable("id") int id)
	{
		
		usertableservice.deleteUser(id);
		
	}
	@PutMapping("/update/{id}")
	@ResponseBody
	public void updateUser(@RequestBody Usertable usertable, @PathVariable("id") int id)
	{
		 usertableservice.updateUser(usertable,id);
	}

}
