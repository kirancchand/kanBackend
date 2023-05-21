package com.project.kan.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.kan.admin.service.SectorService;
import com.project.kan.admin.vo.Sector;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/sector")
public class SectorController {
	
	@Autowired
    private SectorService sectorservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addSector(@RequestBody Sector sector)
    {
        return sectorservice.saveSector(sector);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllSector()
	{

		return sectorservice.getAllSector();

	}
	@RequestMapping("/get/{sector_id}")
	@ResponseBody
	public MasterResponse getSector(@PathVariable("sector_id") int sector_id)
	{

		return sectorservice.getSector(sector_id);

	}

	@DeleteMapping("/delete/{sector_id}")
	@ResponseBody
	public MasterResponse deleteSector(@PathVariable("sector_id") int sector_id)
	{

		return sectorservice.deleteSector(sector_id);

	}
	@PutMapping("/update/{sector_id}")
	@ResponseBody
	public MasterResponse updateSector(@RequestBody Sector sector, @PathVariable("sector_id") int sector_id)
	{
		 return sectorservice.updateSector(sector,sector_id);
	}

}
