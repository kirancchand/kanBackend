package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Migrations;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class MigrationsService {

	private static final Logger logger = LoggerFactory.getLogger(MigrationsService.class);

    @Autowired
    private MyDao mydao;
    
    public Migrations saveMigrations(@RequestBody Migrations migrations)
    {
    	
        mydao.queryNameForUpdate("master.migrations.add",new Object[] {migrations.getMigration(), migrations.getBatch()});
        return migrations;
    }

    public List<Migrations> getAllMigrations()
	{
		List<Migrations> allMigrations = mydao.findAll("master.migrations.all", Migrations.class);
		 return allMigrations;		
	}
	
    public Object getMigrations(@PathVariable("id") int id)
	{
		Object myObject = mydao.findById("master.migrations.getById",new Object[]{id},Migrations.class);
		return myObject;
		
	}
    
    public MasterResponse deleteMigrations(@PathVariable("id") int id)
	{
		
		mydao.delete("master.migrations.delete",new Object[]{id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;
		
	}
	
	public void updateMigrations(@RequestBody Migrations migrations,@PathVariable("id") int id)
	{
	
		mydao.queryNameForUpdate("master.migrations.update", new Object[]{migrations.getMigration(), migrations.getBatch(), id});

	}
    
}
