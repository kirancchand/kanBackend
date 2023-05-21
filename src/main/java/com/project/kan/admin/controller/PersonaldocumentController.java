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

import com.project.kan.admin.service.PersonaldocumentService;
import com.project.kan.admin.vo.Personaldocument;
import com.project.kan.common.vo.MasterResponse;


@RestController
@RequestMapping("/master/personaldocument")
public class PersonaldocumentController {
    
    @Autowired
    private PersonaldocumentService personaldocumentservice;
    
    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }
    
    @PostMapping("/add")
    public MasterResponse addPersonalDocument(@RequestBody Personaldocument personaldocument)
    {
        return personaldocumentservice.savePersonalDocument(personaldocument);
    }
    
    @RequestMapping("/getAll")
    @ResponseBody
    public MasterResponse getAllPersonalDocument()
    {
        
        return personaldocumentservice.getAllPersonalDocument();
        
    }
    @RequestMapping("/get/{personaldocument_id}")
    @ResponseBody
    public MasterResponse getPersonalDocument(@PathVariable("personaldocument_id") int personaldocument_id)
    {
        
        return personaldocumentservice.getPersonalDocument(personaldocument_id);
        
    }
    @DeleteMapping("/delete/{personaldocument_id}")
    @ResponseBody
    public MasterResponse deletePersonalDocument(@PathVariable("personaldocument_id") int personaldocument_id)
    {
        
        return personaldocumentservice.deletePersonalDocument(personaldocument_id);
        
    }
    @PutMapping("/update/{personaldocument_id}")
    @ResponseBody
    public MasterResponse updatePersonalDocument(@RequestBody Personaldocument personaldocument,@PathVariable("personaldocument_id") int personaldocument_id)
    {
        return personaldocumentservice.updatePersonalDocument(personaldocument,personaldocument_id);
    }
    

}
