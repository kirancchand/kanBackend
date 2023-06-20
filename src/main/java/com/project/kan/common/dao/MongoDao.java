package com.project.kan.common.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.project.kan.admin.vo.Area;

@Repository
public class MongoDao {
    
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public Area addNewArea(Area area) {
        mongoTemplate.save(area);
        return area;
    }
}
