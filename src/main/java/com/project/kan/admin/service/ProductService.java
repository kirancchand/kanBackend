package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;
import com.project.kan.security.vo.UserResponse;
import com.project.kan.admin.service.ProductService;
import com.project.kan.admin.vo.Product;

@Service
public class ProductService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	private MyDao mydao;
	
	public Product saveProduct(@RequestBody Product product)
	{
		Long a=mydao.queryForSave("master.product.add",new Object[] {product.getProduct_name()});
		if(a!=0)
			return product;
			
		else
			return null;
		
	}
	public List<Product> getAllProduct()
	{
		List<Product> allProduct=mydao.findAll("master.product.all",Product.class);
		 return allProduct;
		
	}
	
	public Object getProduct(@PathVariable("product_id") int product_id)
	{
		Object myObject=mydao.findById("master.product.getById",new Object[]{product_id},Product.class);
		return myObject;
		
	}
	
	public MasterResponse deleteProduct(@PathVariable("product_id") int product_id)
	{
		
		mydao.delete("master.product.delete",new Object[]{product_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateProduct(@RequestBody Product product,@PathVariable("product_id") int product_id)
	{
	
		long myObject=mydao.queryForUpdate("master.product.update",new Object[]{product.getProduct_name(),product_id});
		return myObject;
		
	}

}
