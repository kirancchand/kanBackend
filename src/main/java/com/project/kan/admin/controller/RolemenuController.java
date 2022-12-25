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

import com.project.kan.admin.service.RolemenuService;
import com.project.kan.admin.vo.Rolemenu;


@RestController
@RequestMapping("/master/rolemenu")
public class RolemenuController {

	@Autowired
    private RolemenuService rolemenuservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Rolemenu addRolemenu(@RequestBody Rolemenu rolemenu)
    {
        return rolemenuservice.saveRolemenu(rolemenu);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Rolemenu> getAllRolemenu()
	{

		return rolemenuservice.getAllRolemenu();

	}
	@RequestMapping("/get/{role_menu_id}")
	@ResponseBody
	public Object getRolemenu(@PathVariable("role_menu_id") int role_menu_id)
	{

		return rolemenuservice.getRolemenu(role_menu_id);

	}

	@DeleteMapping("/delete/{role_menu_id}")
	@ResponseBody
	public void deleteRolemenu(@PathVariable("role_menu_id") int role_menu_id)
	{

		rolemenuservice.deleteRolemenu(role_menu_id);

	}
	@PutMapping("/update/{role_menu_id}")
	@ResponseBody
	public void updateRolemenu(@RequestBody Rolemenu rolemenu, @PathVariable("role_menu_id") int role_menu_id)
	{
		 rolemenuservice.updateRolemenu(rolemenu,role_menu_id);
	}

}
