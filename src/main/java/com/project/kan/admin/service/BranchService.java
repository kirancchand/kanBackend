package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Branch;
import com.project.kan.common.dao.MyDao;

@Service
public class BranchService {

    private static final Logger logger = LoggerFactory.getLogger(BranchService.class);

    @Autowired
    private MyDao mydao;

    public Branch saveBranch(@RequestBody Branch branch)
    {
    	
        mydao.queryNameForUpdate("master.branch.add",new Object[] {branch.getBranch(),branch.getF_area_id()});
        return branch;
    }

    public List<Branch> getAllBranch()
	{
		List<Branch> allBranch = mydao.findAll("master.branch.all",Branch.class);
		 return allBranch;
		
	}
	
	public Object getBranch(@PathVariable("branch_id") int branch_id)
	{
		
		Object myObject=mydao.findById("master.branch.getById",new Object[]{branch_id},Branch.class);
		return myObject;
		
	}
	
	public List<Branch> getBranchByArea(@PathVariable("area_id") int area_id)
	{
		
		List<Branch> branchByArea = mydao.findListById("master.branch.getByArea",new Object[]{area_id},Branch.class);
		return branchByArea;
		
	}
	
	public void deleteBranch(@PathVariable("branch_id") int branch_id)
	{
		
//		 branchrepo.deleteById(branch_id);
		mydao.delete("master.branch.delete",new Object[]{branch_id});
		
	}
	
	public void updateBranch(@RequestBody Branch branch,@PathVariable("branch_id") int branch_id)
	{
	
		mydao.queryNameForUpdate("master.branch.update",new Object[]{branch.getBranch(),branch.getF_area_id(),branch_id});
//		return myObject;
//		return branch.getBranch();
		
	}

}
