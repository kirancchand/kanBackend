package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Menutype;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;


@Service
public class MenutypeService {

	private static final Logger logger = LoggerFactory.getLogger(MenutypeService.class);

	@Autowired
	private MyDao mydao;
	
	public Menutype saveMenutype(@RequestBody Menutype menutype)
	{
		Long a=mydao.queryForSave("master.menutype.add",new Object[] {menutype.getMenutype()});
		if(a!=0)
			return menutype;
			
		else
			return null;
		
	}
	public List<Menutype> getAllMenutype()
	{
		List<Menutype> allMenutype=mydao.findAll("master.menutype.all",Menutype.class);
		 return allMenutype;
		
	}
	
	public Object getMenutype(@PathVariable("menutype_id") int menutype_id)
	{
		Object myObject=mydao.findById("master.menutype.getById",new Object[]{menutype_id},Menutype.class);
		return myObject;
		
	}
	
	public MasterResponse deleteMenutype(@PathVariable("menutype_id") int menutype_id)
	{
		
		mydao.delete("master.menutype.delete",new Object[]{menutype_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	public Long updateMenutype(@RequestBody Menutype menutype,@PathVariable("menutype_id") int menutype_id)
	{
	
		long myObject=mydao.queryForUpdate("master.menutype.update",new Object[]{menutype.getMenutype(),menutype_id});
		return myObject;
		
	}
	
}
