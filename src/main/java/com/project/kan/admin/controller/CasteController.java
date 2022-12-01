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

import com.project.kan.admin.service.CasteService;
import com.project.kan.admin.vo.Caste;

@RestController
@RequestMapping("/master/caste")
public class CasteController {
	
    @Autowired
    private CasteService casteservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public Caste addCaste(@RequestBody Caste caste)
    {
        return casteservice.saveCaste(caste);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Caste> getAllCaste()
	{
		
		return casteservice.getAllCaste();
		
	}
	@RequestMapping("/get/{caste_id}")
	@ResponseBody
	public Object getCaste(@PathVariable("caste_id") int caste_id)
	{
		
		return casteservice.getCaste(caste_id);
		
	}
	
	
	@RequestMapping("/getByReligion/{religion_id}")
	@ResponseBody
	public List getCasteByReligion(@PathVariable("religion_id") int religion_id)
	{

		return casteservice.getCasteByReligion(religion_id);
		
	}
	
	@DeleteMapping("/delete/{caste_id}")
	@ResponseBody
	public void deleteCaste(@PathVariable("caste_id") int caste_id)
	{
		
		casteservice.deleteCaste(caste_id);
		
	}
	@PutMapping("/update/{caste_id}")
	@ResponseBody
	public void updateCaste(@RequestBody Caste caste,@PathVariable("caste_id") int caste_id)
	{
		 casteservice.updateCaste(caste,caste_id);
	}


}
