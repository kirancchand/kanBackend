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
    
    public Menu saveMenu(@RequestBody Menu menu)
    {
    	
        mydao.queryNameForUpdate("master.menu.add",new Object[] {menu.getMenu(), menu.getParent_id(), menu.getController_name(), menu.getIcon(), menu.getPosition(), menu.getF_status_id(), menu.getF_menutype_id()});
        return menu;
    }

    public List<Menu> getAllMenu()
	{
		List<Menu> allMenu = mydao.findAll("master.menu.all",Menu.class);
		 return allMenu;		
	}
	

    //Get menu by ID 
	public Object getMenu(@PathVariable("menu_id") int menu_id)
	{
		Object myObject = mydao.findById("master.menu.getById",new Object[]{menu_id},Menu.class);
		return myObject;
		
	}
	
	//Get menu by PARENT
	public List<Menu> getMenuByParent(@PathVariable("parent_id") int parent_id)
	{
	    List<Menu> byParent = mydao.findListById("master.menu.getByParent",new Object[]{parent_id}, Menu.class);
		return byParent;
		
	}
	
	
	//Get menu by STATUS
	public List<Menu> getMenuByStatus(@PathVariable("f_status_id") int f_status_id)
	{
	    List<Menu> byStatus = mydao.findListById("master.menu.getByStatus",new Object[]{f_status_id},Menu.class);
		return byStatus;
		
	}
	
	//Get menu by MENUTYPE
	public List<Menu> getMenuByMenutype(@PathVariable("f_menutype_id") int f_menutype_id)
	{
	    List<Menu> byMenutype = mydao.findListById("master.menu.getByMenutype",new Object[]{f_menutype_id},Menu.class);
		return byMenutype;
		
	}
		
	public MasterResponse deleteMenu(@PathVariable("menu_id") int menu_id)
	{
		
		mydao.delete("master.menu.delete",new Object[]{menu_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateMenu(@RequestBody Menu menu,@PathVariable("menu_id") int menu_id)
	{
	
		mydao.queryNameForUpdate("master.menu.update", new Object[]{menu.getMenu_id(),menu.getMenu(), menu.getParent_id(), menu.getController_name(), menu.getIcon(), menu.getPosition(), menu.getF_status_id(), menu.getF_menutype_id()});

	}
	
}
