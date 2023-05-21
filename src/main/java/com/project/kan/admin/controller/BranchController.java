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

import com.project.kan.admin.service.BranchService;
import com.project.kan.admin.vo.Branch;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/branch")
public class BranchController {
    @Autowired
    private BranchService branchservice;

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @PostMapping("/add")
    public MasterResponse addBranch(@RequestBody Branch branch)
    {
        return branchservice.saveBranch(branch);
    }

    @RequestMapping("/getAll")
	@ResponseBody
	public MasterResponse getAllBranch()
	{
		
		return branchservice.getAllBranch();
		
	}
	@RequestMapping("/get/{branch_id}")
	@ResponseBody
	public MasterResponse getBranch(@PathVariable("branch_id") int branch_id)
	{
		
		return branchservice.getBranch(branch_id);
		
	}
	
	@RequestMapping("/getByArea/{area_id}")
	@ResponseBody
	public MasterResponse getBranchByArea(@PathVariable("area_id") int area_id)
	{
		
		return branchservice.getBranchByArea(area_id);
		
	}
	
	@DeleteMapping("/delete/{branch_id}")
	@ResponseBody
	public MasterResponse deleteBranch(@PathVariable("branch_id") int branch_id)
	{
		
		return branchservice.deleteBranch(branch_id);
		
	}
	@PutMapping("/update/{branch_id}")
	@ResponseBody
	public MasterResponse updateBranch(@RequestBody Branch branch,@PathVariable("branch_id") int branch_id)
	{
		 return branchservice.updateBranch(branch,branch_id);
	}
}
