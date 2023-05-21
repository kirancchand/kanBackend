package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Category;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse saveCategory(@RequestBody Category category)
    {
    	
        mydao.queryNameForUpdate("master.category.add",new Object[] {category.getCategory(),category.getCategorytheme(),category.getParent_id(),category.getCategory_image()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(category);
        return masterResponse;
    }

    public MasterResponse getAllCategory()
	{
		List<Category> allCategory=mydao.findAll("master.category.all",Category.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allCategory);
		 return masterResponse;
		
	}
	
	public MasterResponse getCategory(@PathVariable("category_id") int category_id)
	{
		Object myObject=mydao.findById("master.category.getById",new Object[]{category_id},Category.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
		return masterResponse;
		
	}
	
	public MasterResponse getCategoryByDistrict(@PathVariable("district_id") int district_id)
	{
		Object myObject=mydao.findById("master.category.getByDistrict",new Object[]{district_id},Category.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
		return masterResponse;
		
	}
	
	public MasterResponse deleteCategory(@PathVariable("category_id") int category_id)
	{
		
//		 categoryrepo.deleteById(category_id);
		mydao.delete("master.category.delete",new Object[]{category_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Deleted Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData("");
        return masterResponse;
	}
	
	public MasterResponse updateCategory(@RequestBody Category category,@PathVariable("category_id") int category_id)
	{
	
		mydao.queryNameForUpdate("master.category.update",new Object[]{category.getCategory(),category.getCategorytheme(),category.getParent_id(),category.getCategory_image(),category_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(category);
        return masterResponse;
		
	}

}
