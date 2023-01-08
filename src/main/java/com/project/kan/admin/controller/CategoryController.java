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

import com.project.kan.admin.service.CategoryService;
import com.project.kan.admin.vo.Category;


@RestController
@RequestMapping("/master/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}
	
	@PostMapping("/add")
	public Category addCategory(@RequestBody Category category)
	{
		return categoryservice.saveCategory(category);
	}
	
	
    @RequestMapping("/getAll")
	@ResponseBody
	public List<Category> getAllCategory()
	{
		
		return categoryservice.getAllCategory();
		
	}
	@RequestMapping("/get/{category_id}")
	@ResponseBody
	public Object getCategory(@PathVariable("category_id") int category_id)
	{
		
		return categoryservice.getCategory(category_id);
		
	}
	
	
	@DeleteMapping("/delete/{category_id}")
	@ResponseBody
	public void deleteCategory(@PathVariable("category_id") int category_id)
	{
		
		categoryservice.deleteCategory(category_id);
		
	}
	@PutMapping("/update/{category_id}")
	@ResponseBody
	public void updateCategory(@RequestBody Category category,@PathVariable("category_id") int category_id)
	{
		 categoryservice.updateCategory(category,category_id);
	}

	
	
}
