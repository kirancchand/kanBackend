package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Menu;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class MenuService {

	private static final Logger logger = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private MyDao mydao;
    
    public MasterResponse saveMenu(@RequestBody Menu menu)
    {
    	
        mydao.queryNameForUpdate("master.menu.add",new Object[] {menu.getMenu(), menu.getParent_id(), menu.getController_name(), menu.getIcon(), menu.getPosition(), menu.getF_status_id(), menu.getF_menutype_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(menu);
        return masterResponse;
    }

    public MasterResponse getAllMenu()
	{
		List<Menu> allMenu = mydao.findAll("master.menu.all",Menu.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allMenu);
        return masterResponse;		
	}
	

    //Get menu by ID 
	public MasterResponse getMenu(@PathVariable("menu_id") int menu_id)
	{
		Object myObject = mydao.findById("master.menu.getById",new Object[]{menu_id},Menu.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
		
	}
	
	//Get menu by PARENT
	public MasterResponse getMenuByParent(@PathVariable("parent_id") int parent_id)
	{
	    List<Menu> byParent = mydao.findListById("master.menu.getByParent",new Object[]{parent_id}, Menu.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byParent);
        return masterResponse;
		
	}
	
	
	//Get menu by STATUS
	public MasterResponse getMenuByStatus(@PathVariable("f_status_id") int f_status_id)
	{
	    List<Menu> byStatus = mydao.findListById("master.menu.getByStatus",new Object[]{f_status_id},Menu.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byStatus);
        return masterResponse;
		
	}
	
	//Get menu by MENUTYPE
	public MasterResponse getMenuByMenutype(@PathVariable("f_menutype_id") int f_menutype_id)
	{
	    List<Menu> byMenutype = mydao.findListById("master.menu.getByMenutype",new Object[]{f_menutype_id},Menu.class);
	    MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(byMenutype);
        return masterResponse;
		
	}
		
	public MasterResponse deleteMenu(@PathVariable("menu_id") int menu_id)
	{
		
		mydao.delete("master.menu.delete",new Object[]{menu_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public MasterResponse updateMenu(@RequestBody Menu menu,@PathVariable("menu_id") int menu_id)
	{
	
		mydao.queryNameForUpdate("master.menu.update", new Object[]{menu.getMenu_id(),menu.getMenu(), menu.getParent_id(), menu.getController_name(), menu.getIcon(), menu.getPosition(), menu.getF_status_id(), menu.getF_menutype_id()});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(menu);
        return masterResponse;
	}
	
}
