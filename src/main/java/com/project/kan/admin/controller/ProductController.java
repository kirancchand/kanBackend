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

import com.project.kan.admin.service.ProductService;
import com.project.kan.admin.vo.Product;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/product")

public class ProductController {

	@Autowired
	private ProductService productservice;
	
	@RequestMapping("/index")
	@ResponseBody
	public String index()
	{
		return "index";
	}

	@PostMapping("/add")
	public Product addProduct(@RequestBody Product product)
	{
		return productservice.saveProduct(product);
	}
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Product> getAllProduct()
	{
		
		return productservice.getAllProduct();
		
	}
	@RequestMapping("/get/{product_id}")
	@ResponseBody
	public Object getProduct(@PathVariable("product_id") int product_id)
	{
		
		return productservice.getProduct(product_id);
		
	}
	@DeleteMapping("/delete/{product_id}")
	@ResponseBody
	public MasterResponse deleteProduct(@PathVariable("product_id") int product_id)
	{
		
		return productservice.deleteProduct(product_id);
		
	}
	@PutMapping("/update/{product_id}")
	@ResponseBody
	public Long updateProduct(@RequestBody Product product,@PathVariable("product_id") int product_id)
	{
		return productservice.updateProduct(product,product_id);
	}
	
}
