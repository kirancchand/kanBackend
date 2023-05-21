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

import com.project.kan.admin.service.ProductcategoryService;
import com.project.kan.admin.vo.Productcategory;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/productcategory")
public class ProductcategoryController {
	
	@Autowired
    private ProductcategoryService productcategoryservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addProductcategory(@RequestBody Productcategory productcategory)
    {
        return productcategoryservice.saveProductcategory(productcategory);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllProductcategory()
	{
		
		return productcategoryservice.getAllProductcategory();
		
	}
	@RequestMapping("/get/{product_category_id}")
	@ResponseBody
	public MasterResponse getProductcategory(@PathVariable("product_category_id") int product_category_id)
	{
		
		return productcategoryservice.getProductcategory(product_category_id);
		
	}
	
	@DeleteMapping("/delete/{product_category_id}")
	@ResponseBody
	public MasterResponse deleteProductcategory(@PathVariable("product_category_id") int product_category_id)
	{
		
		return productcategoryservice.deleteProductcategory(product_category_id);
		
	}
	
	@PutMapping("/update/{product_category_id}")
	@ResponseBody
	public MasterResponse updateProductcategory(@RequestBody Productcategory productcategory, @PathVariable("product_category_id") int product_category_id)
	{
		 return productcategoryservice.updateProductcategory(productcategory,product_category_id);
	}

}
