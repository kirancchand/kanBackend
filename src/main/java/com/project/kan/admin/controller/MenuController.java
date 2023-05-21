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

import com.project.kan.admin.service.MenuService;
import com.project.kan.admin.vo.Menu;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/menu")
public class MenuController {
	@Autowired
    private MenuService menuservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addMenu(@RequestBody Menu menu)
    {
        return menuservice.saveMenu(menu);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllMenu()
	{
		return menuservice.getAllMenu();
		
	}
	@RequestMapping("/get/{menu_id}")
	@ResponseBody
	public MasterResponse getMenu(@PathVariable("menu_id") int menu_id)
	{
		
		return menuservice.getMenu(menu_id);
		
	}
	
	//Get MENU by PARENT
	@RequestMapping("/getByParent/{parent_id}")
	@ResponseBody
	public MasterResponse getMenuByParent(@PathVariable("parent_id") int parent_id)
	{
		
		return menuservice.getMenuByParent(parent_id);
		
	}
	
	//Get MENU by STATUS	
	@RequestMapping("/getByStatus/{f_status_id}")
	@ResponseBody
	public MasterResponse getMenuByStatus(@PathVariable("f_status_id") int f_status_id)
	{
		
		return menuservice.getMenuByStatus(f_status_id);
		
	}
	
	//get MENU by MENUTYPE
	@RequestMapping("/getByMenutype/{f_menutype_id}")
	@ResponseBody
	public MasterResponse getMenuByMenutype(@PathVariable("f_menutype_id") int f_menutype_id)
	{
		
		return menuservice.getMenuByMenutype(f_menutype_id);
		
	}
	
	
	@DeleteMapping("/delete/{menu_id}")
	@ResponseBody
	public MasterResponse deleteMenu(@PathVariable("menu_id") int menu_id)
	{
		
		return menuservice.deleteMenu(menu_id);
		
	}
	@PutMapping("/update/{menu_id}")
	@ResponseBody
	public MasterResponse updateMenu(@RequestBody Menu menu, @PathVariable("menu_id") int menu_id)
	{
		 return menuservice.updateMenu(menu,menu_id);
	}
}
