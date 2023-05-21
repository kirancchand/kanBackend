package com.project.kan.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.kan.admin.vo.Documenttype;
import com.project.kan.common.dao.MyDao;
import com.project.kan.common.vo.MasterResponse;

@Service
public class DocumenttypeService {
    
    private static final Logger logger = LoggerFactory.getLogger(DocumenttypeService.class);

    @Autowired
    private MyDao mydao;
    
    public MasterResponse saveDocumentType(@RequestBody Documenttype documenttype)
    {
        Long a=mydao.queryForSave("master.documenttype.add",new Object[] {documenttype.getDocumenttype()});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Added Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(documenttype);
        return masterResponse;
//        logger.info("Saving..!"+a);
//        if(a!=0)
//            return documenttype;
//            
//        else
//            return null;
        
    }
    public MasterResponse getAllDocumentType()
    {
        List<Documenttype> allDocumenttype=mydao.findAll("master.documenttype.all",Documenttype.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(allDocumenttype);
        return masterResponse;
        
    }
    
    public MasterResponse getDocumentType(@PathVariable("Documenttype_id") int documenttype_id)
    {
        Object myObject=mydao.findById("master.documenttype.getById",new Object[]{documenttype_id},Documenttype.class);
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Listed Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
        
    }
    
    public MasterResponse deleteDocumentType(@PathVariable("documenttype_id") int documenttype_id)
    {
        
//       staterepo.deleteById(state_id);
        mydao.delete("master.documenttype.delete",new Object[]{documenttype_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Deleted Successfully!!");
        masterResponse.setStatus(200);
        
        return masterResponse;
        
    }
    public MasterResponse updateDocumentType(@RequestBody Documenttype documenttype,@PathVariable("documenttype_id") int documenttype_id)
    {
    
        long myObject=mydao.queryForUpdate("master.documenttype.update",new Object[]{documenttype.getDocumenttype(),documenttype_id});
        MasterResponse masterResponse = new MasterResponse();
        masterResponse.setMessage("Updated Successfully!!");
        masterResponse.setStatus(200);
        masterResponse.setData(myObject);
        return masterResponse;
//      return state.getState();
        
    }
    
}
