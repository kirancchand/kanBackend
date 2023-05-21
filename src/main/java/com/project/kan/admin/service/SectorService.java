package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Sector;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class SectorService {

	private static final Logger logger = LoggerFactory.getLogger(SectorService.class);

    @Autowired
    private MyDao mydao;

    public MasterResponse saveSector(@RequestBody Sector sector)
    {

        mydao.queryNameForUpdate("master.sector.add",new Object[] {sector.getSector(), sector.getF_branch_id()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(sector);
        return masterResponse;

    }

    public MasterResponse getAllSector()
	{
		List<Sector> allSector = mydao.findAll("master.sector.all",Sector.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allSector);
        return masterResponse;

	}


	public MasterResponse getSector(@PathVariable("sector_id") int sector_id)
	{
		Object myObject = mydao.findById("master.sector.getById",new Object[]{sector_id},Sector.class);
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;


	}


	public MasterResponse deleteSector(@PathVariable("sector_id") int sector_id)
	{

		mydao.delete("master.sector.delete",new Object[]{sector_id});
		MasterResponse masterResponse = new MasterResponse();
		masterResponse.setMessage("Deleted Successfully!!");
		masterResponse.setStatus(200);
		return masterResponse;

	}

	public MasterResponse updateSector(@RequestBody Sector sector,@PathVariable("sector_id") int sector_id)
	{

		mydao.queryNameForUpdate("master.sector.update", new Object[]{sector.getSector(), sector.getF_branch_id(), sector_id});
		MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(sector);
        return masterResponse;
	}
	
}
