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

import com.project.kan.admin.service.MigrationsService;
import com.project.kan.admin.vo.Migrations;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/migrations")
public class MigrationsController {

	@Autowired
    private MigrationsService migrationsservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addMigrations(@RequestBody Migrations migrations)
    {
        return migrationsservice.saveMigrations(migrations);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllMigrations()
	{
		
		return migrationsservice.getAllMigrations();
		
	}
    
	@RequestMapping("/get/{id}")
	@ResponseBody
	public MasterResponse getMigrations(@PathVariable("id") int id)
	{
		
		return migrationsservice.getMigrations(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public MasterResponse deleteMigrations(@PathVariable("id") int id)
	{
		
		return migrationsservice.deleteMigrations(id);
		
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public MasterResponse updateMigrations(@RequestBody Migrations migrations, @PathVariable("id") int id)
	{
		 return migrationsservice.updateMigrations(migrations,id);
	}
	
}
