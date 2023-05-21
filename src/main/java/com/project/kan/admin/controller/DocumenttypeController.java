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

import com.project.kan.admin.service.DocumenttypeService;
import com.project.kan.admin.vo.Documenttype;
import com.project.kan.common.vo.MasterResponse;

@RestController
@RequestMapping("/master/documenttype")
public class DocumenttypeController {
    @Autowired
    private DocumenttypeService documenttypeservice;
    
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }
    
    @PostMapping("/add")
    public MasterResponse addDocumentType(@RequestBody Documenttype documenttype)
    {
        return documenttypeservice.saveDocumentType(documenttype);
    }
    
    @RequestMapping("/getAll")
    @ResponseBody
    public MasterResponse getAllDocumentType()
    {
        
        return documenttypeservice.getAllDocumentType();
        
    }
    @RequestMapping("/get/{document_type_id}")
    @ResponseBody
    public MasterResponse getDocumentType(@PathVariable("document_type_id") int document_type_id)
    {
        
        return documenttypeservice.getDocumentType(document_type_id);
        
    }
    @DeleteMapping("/delete/{document_type_id}")
    @ResponseBody
    public MasterResponse deleteDocumentType(@PathVariable("document_type_id") int document_type_id)
    {
        
        return documenttypeservice.deleteDocumentType(document_type_id);
        
    }
    @PutMapping("/update/{document_type_id}")
    @ResponseBody
    public MasterResponse updateDocumentType(@RequestBody Documenttype documenttype,@PathVariable("document_type_id") int document_type_id)
    {
        return documenttypeservice.updateDocumentType(documenttype,document_type_id);
    }
    
    

}
