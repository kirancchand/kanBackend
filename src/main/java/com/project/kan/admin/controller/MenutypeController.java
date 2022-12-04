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

import com.project.kan.admin.service.MenutypeService;
import com.project.kan.admin.vo.Menutype;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/menutype")
public class MenutypeController {

	@Autowired
	private MenutypeService menutypeservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public Menutype addMenutype(@RequestBody Menutype menutype)
	{
		return menutypeservice.saveMenutype(menutype);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Menutype> getAllMenutype()
	{
		
		return menutypeservice.getAllMenutype();
		
	}
	@RequestMapping("/get/{menutype_id}")
	@ResponseBody
	public Object getMenutype(@PathVariable("menutype_id") int menutype_id)
	{
		
		return menutypeservice.getMenutype(menutype_id);
		
	}
	@DeleteMapping("/delete/{menutype_id}")
	@ResponseBody
	public MasterResponse deleteMenutype(@PathVariable("menutype_id") int menutype_id)
	{
		
		return menutypeservice.deleteMenutype(menutype_id);
		
	}
	@PutMapping("/update/{menutype_id}")
	@ResponseBody
	public Long updateMenutype(@RequestBody Menutype menutype,@PathVariable("menutype_id") int menutype_id)
	{
		return menutypeservice.updateMenutype(menutype,menutype_id);
	}
	
}
