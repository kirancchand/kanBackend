package com.project.kan.common.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.kan.admin.service.BranchService;
import com.project.kan.admin.vo.Branch;

@Service
public class TestService {
    
    
    private static final Logger logger = LoggerFactory.getLogger(TestService.class);
    @Autowired
    private JdbcTemplate jdbctemplate;
    public Branch saveBranch(@RequestBody Branch branch) {   
        int resp=jdbctemplate.update("INSERT INTO branch (branch,f_area_id) VALUES (?,?)", new Object[] {branch.getBranch(),branch.getF_area_id()});
//        System.out.print(resp);
        return branch;
    }
    
    public List<Branch> getAllBranch()
    {
        
        String sql = " SELECT * FROM branch";
        List<Branch> allbranch = jdbctemplate.query(
                sql,
                new BeanPropertyRowMapper(Branch.class));
        return allbranch;
        
    }
    
    public Object getBranch(@PathVariable("branch_id") int branch_id)
    {
//        Object myObject=mydao.findById("master.branch.getById",new Object[]{branch_id},Branch.class);
//        return myObject;
        
        String sql = "SELECT * FROM branch WHERE branch_id = ?";

        Object myObject = jdbctemplate.queryForObject(
            sql, 
            new Object[]{branch_id}, 
            new BeanPropertyRowMapper(Branch.class));
        return myObject;
        
    }
    
    public List getBranchByArea(@PathVariable("area_id") int area_id)
    {
        String sql = "SELECT * FROM branch WHERE f_area_id = ?";

        List<Branch> allbranch = jdbctemplate.query(
            sql, 
            new Object[]{area_id}, 
            new BeanPropertyRowMapper(Branch.class));
        return allbranch;
        
    }
    
    public void deleteBranch(@PathVariable("branch_id") int branch_id)
    {
        String sql = "DELETE FROM branch WHERE branch_id = ?";        
        int resp=jdbctemplate.update(sql, new Object[] {branch_id});
//        return branch;
      
      
        
    }
//    
    public void updateBranch(@RequestBody Branch branch,@PathVariable("branch_id") int branch_id)
    {
    
        String updateQuery = "UPDATE branch SET branch=?,f_area_id=? WHERE branch_id=?";
        jdbctemplate.update(updateQuery, new Object[]{branch.getBranch(),branch.getF_area_id(),branch_id});
        
    }
}
