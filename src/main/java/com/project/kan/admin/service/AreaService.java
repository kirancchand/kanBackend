package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Area;
import com.project.kan.admin.vo.Caste;
import com.project.kan.common.dao.MyDao;

@Service
public class AreaService {
    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);

    @Autowired
    private MyDao mydao;

    public Area saveArea(@RequestBody Area area)
    {
    	
        mydao.queryNameForUpdate("master.area.add",new Object[] {area.getArea(),area.getF_district_id(),area.getF_localbodytype_id()});
        return area;
    }

    public List<Area> getAllArea()
	{
		List<Area> allArea=mydao.findAll("master.area.all",Area.class);
		 return allArea;
		
	}
	
	public Object getArea(@PathVariable("area_id") int area_id)
	{
		Object myObject=mydao.findById("master.area.getById",new Object[]{area_id},Area.class);
		return myObject;
		
	}
	
	public List getAreaByDistrict(@PathVariable("district_id") int district_id)
	{
	    List<Area> byDistrict=mydao.findListById("master.area.getByDistrict",new Object[]{district_id},Area.class);
		return byDistrict;
		
	}
	
	public void deleteArea(@PathVariable("area_id") int area_id)
	{
		
//		 arearepo.deleteById(area_id);
		mydao.delete("master.area.delete",new Object[]{area_id});
		
	}
	
	public void updateArea(@RequestBody Area area,@PathVariable("area_id") int area_id)
	{
	
		mydao.queryNameForUpdate("master.area.update",new Object[]{area.getArea(),area.getF_district_id(),area.getF_localbodytype_id(),area_id});
//		return myObject;
//		return area.getArea();
		
	}
}
