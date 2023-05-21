package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Area;
import com.project.kan.admin.vo.Personaldocument;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class PersonaldocumentService {
    
    private static final Logger logger = LoggerFactory.getLogger(PersonaldocumentService.class);

    @Autowired
    private MyDao mydao;
    
    public MasterResponse savePersonalDocument(@RequestBody Personaldocument personaldocument)
    {
        Long a=mydao.queryForSave("master.personaldocument.add",new Object[] {personaldocument.getDocument_no(),personaldocument.getF_documenttype_id(),personaldocument.getDocument()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(personaldocument);
        return masterResponse;
//        logger.info("Saving..!"+a);
//        if(a!=0)
//            return personaldocument;
//            
//        else
//            return null;
        
    }
    public MasterResponse getAllPersonalDocument()
    {
        List<Personaldocument> allPersonaldocument=mydao.findAll("master.personaldocument.all",Personaldocument.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allPersonaldocument);
        return masterResponse;
//         return allPersonaldocument;
        
    }
    
    public MasterResponse getPersonalDocument(@PathVariable("personaldocument_id") int personaldocument_id)
    {
        Object myObject=mydao.findById("master.personaldocument.getById",new Object[]{personaldocument_id},Personaldocument.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
  
        
    }
    
    public MasterResponse deletePersonalDocument(@PathVariable("personaldocument_id") int personaldocument_id)
    {
        
//       staterepo.deleteById(state_id);
        mydao.delete("master.personaldocument.delete",new Object[]{personaldocument_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Deleted Successfully!!");
        masterResponse.setStatus(200);
        
        return masterResponse;
        
    }
//    public Personaldocument updatePersonalDocument(@RequestBody Personaldocument personaldocument,@PathVariable("personaldocument_id") int personaldocument_id)
//    {
////        logger.info(personaldocument.getF_documenttype_id());
//        long myObject=mydao.queryForUpdate("master.personaldocument.update",new Object[]{personaldocument.getDocument_no(),personaldocument.getF_documenttype_id(),personaldocument.getDocument(),personaldocument_id});
//        return personaldocument;
//        
//    }
    
    public MasterResponse updatePersonalDocument(@RequestBody Personaldocument personaldocument,@PathVariable("personaldocument_id") int personaldocument_id)
    {
    
        mydao.queryNameForUpdate("master.personaldocument.update",new Object[]{personaldocument.getDocument_no(),personaldocument.getF_documenttype_id(),personaldocument.getDocument(),personaldocument_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(personaldocument);
        return masterResponse;
        
    }

}
