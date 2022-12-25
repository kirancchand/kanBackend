package com.project.kan.admin.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Productcategory;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class ProductcategoryService {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductcategoryService.class);

    @Autowired
    private MyDao mydao;
    
    public Productcategory saveProductcategory(@RequestBody Productcategory productcategory)
    {
    	
        mydao.queryNameForUpdate("master.productcategory.add",new Object[] {productcategory.getF_category_id(), productcategory.getF_product_id(), productcategory.getF_status_id()});
        return productcategory;
    }

    public List<Productcategory> getAllProductcategory()
	{
		List<Productcategory> allProductcategory = mydao.findAll("master.productcategory.all",Productcategory.class);
		 return allProductcategory;		
	}
    
    public Object getProductcategory(@PathVariable("product_category_id") int product_category_id)
	{
		Object myObject = mydao.findById("master.productcategory.getById",new Object[]{product_category_id},Productcategory.class);
		return myObject;
		
	}
    
    public MasterResponse deleteProductcategory(@PathVariable("product_category_id") int product_category_id)
	{
		
		mydao.delete("master.productcategory.delete",new Object[]{product_category_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateProductcategory(@RequestBody Productcategory productcategory,@PathVariable("product_category_id") int product_category_id)
	{
	
		mydao.queryNameForUpdate("master.productcategory.update", new Object[]{productcategory.getF_category_id(), productcategory.getF_product_id(), productcategory.getF_status_id(), product_category_id});

	}
	
}
