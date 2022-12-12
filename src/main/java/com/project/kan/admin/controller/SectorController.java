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
    public Sector addSector(@RequestBody Sector sector)
    {
        return sectorservice.saveSector(sector);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public List<Sector> getAllSector()
	{

		return sectorservice.getAllSector();

	}
	@RequestMapping("/get/{sector_id}")
	@ResponseBody
	public Object getSector(@PathVariable("sector_id") int sector_id)
	{

		return sectorservice.getSector(sector_id);

	}

	@DeleteMapping("/delete/{sector_id}")
	@ResponseBody
	public void deleteSector(@PathVariable("sector_id") int sector_id)
	{

		sectorservice.deleteSector(sector_id);

	}
	@PutMapping("/update/{sector_id}")
	@ResponseBody
	public void updateSector(@RequestBody Sector sector, @PathVariable("sector_id") int sector_id)
	{
		 sectorservice.updateSector(sector,sector_id);
	}

}
