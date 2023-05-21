package com.project.kan.common.controller;

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

import com.project.kan.admin.vo.Branch;
import com.project.kan.common.service.TestService;

@RestController
@RequestMapping("/mytest")
public class TestController {
    
    @Autowired
    private TestService testservice;
    

    @RequestMapping("/test")
    public String index() {
        return "index";
    }
    
    @PostMapping("/add")
    public Branch saveBranch(@RequestBody Branch branch) {
        
//        return branch;
        return testservice.saveBranch(branch);
    }
    
    @RequestMapping("/getAll")
    @ResponseBody
    public List<Branch> getAllBranch()
    {
        
        return testservice.getAllBranch();
        
    }
    @RequestMapping("/get/{branch_id}")
    @ResponseBody
    public Object getBranch(@PathVariable("branch_id") int branch_id)
    {
        
        return testservice.getBranch(branch_id);
        
    }
    
    @RequestMapping("/getByArea/{area_id}")
    @ResponseBody
    public List getBranchByArea(@PathVariable("area_id") int area_id)
    {
        
        return testservice.getBranchByArea(area_id);
        
    }
    
    @DeleteMapping("/delete/{branch_id}")
    @ResponseBody
    public void deleteBranch(@PathVariable("branch_id") int branch_id)
    {
        
        testservice.deleteBranch(branch_id);
        
    }
    
    @PutMapping("/update/{branch_id}")
    @ResponseBody
    public void updateBranch(@RequestBody Branch branch,@PathVariable("branch_id") int branch_id)
    {
        testservice.updateBranch(branch,branch_id);
    }
    
}
