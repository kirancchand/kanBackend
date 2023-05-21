package com.project.kan.admin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Area;
import com.project.kan.admin.vo.Branch;
import com.project.kan.admin.vo.Caste;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;
import com.project.kan.common.vo.SearchRequest;
import com.project.kan.common.vo.SearchResponse;

@Service
public class AreaService {
    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);
    
    
    @Autowired
    private MyDao mydao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MasterResponse saveArea(@RequestBody Area area)
    {
        mydao.queryNameForUpdate("master.area.add",new Object[] {area.getArea(),area.getF_region_id(),area.getF_localbodytype_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(area);
        return masterResponse;
    }

    public MasterResponse getAllArea()
	{
		List<Area> allArea=mydao.findAll("master.area.all",Area.class);
		 MasterResponse masterResponse = new MasterResponse();
         masterResponse.setMessage("Listed Successfully!!");
         masterResponse.setStatus(200);
         masterResponse.setData(allArea);
		 return masterResponse;
		
	}
	
	public MasterResponse getArea(@PathVariable("area_id") int area_id)
	{
		Object myObject=mydao.findById("master.area.getById",new Object[]{area_id},Area.class);
		 MasterResponse masterResponse = new MasterResponse();
         masterResponse.setMessage("Listed Successfully!!");
         masterResponse.setStatus(200);
         masterResponse.setData(myObject);
		return masterResponse;
		
	}
	
   public MasterResponse getAreaByRegion(@PathVariable("region_id") int region_id)
    {
        List<Area> byRegion=mydao.findListById("master.area.getByRegion",new Object[]{region_id},Area.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byRegion);
        return masterResponse;
        
    }
//	public List getAreaByDistrict(@PathVariable("district_id") int district_id)
//	{
//	    List<Area> byDistrict=mydao.findListById("master.area.getByDistrict",new Object[]{district_id},Area.class);
//		return byDistrict;
//		
//	}
	
	public MasterResponse getAreabyLocalbodyType(@PathVariable("localbodytype_id") int localbodytype_id)
    {
        List<Area> byLocalbodyType=mydao.findListById("master.area.getAreabyLocalbodyType",new Object[]{localbodytype_id},Area.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byLocalbodyType);
        return masterResponse;
        
    }
	
	public MasterResponse deleteArea(@PathVariable("area_id") int area_id)
	{
		
//		 arearepo.deleteById(area_id);
		mydao.delete("master.area.delete",new Object[]{area_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Deleted Successfully!!");
        masterResponse.setStatus(200);
        return masterResponse;
	}
	
	public MasterResponse updateArea(@RequestBody Area area,@PathVariable("area_id") int area_id)
	{
	
		mydao.queryNameForUpdate("master.area.update",new Object[]{area.getArea(),area.getF_region_id(),area.getF_localbodytype_id(),area_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(area);
        return masterResponse;
//		return myObject;
//		return area.getArea();
		
	}
	
	public MasterResponse searchArea(@RequestBody SearchRequest searchrequest)
    {
        List<Area> allArea=mydao.findAll("master.area.all",Area.class);
        
        String sql = "SELECT * FROM area LIMIT ?,?";
        List<Area> limitArea = jdbcTemplate.query(
            sql, 
            new Object[]{searchrequest.getStart(),searchrequest.getNumberOfRows()}, 
            new BeanPropertyRowMapper(Area.class));

        
        
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setTotalcount(allArea.size());
        searchResponse.setResult(limitArea);
        masterResponse.setData(searchResponse);
        return masterResponse;
        
    }
}
