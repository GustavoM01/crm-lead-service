package com.ironhack.leadservice.controller;

import com.ironhack.leadservice.dao.Lead;
import com.ironhack.leadservice.dto.LeadDTO;
import com.ironhack.leadservice.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    LeadService leadService;

    @GetMapping("/{id}")
    public Lead findById(@PathVariable Long id){
        return leadService.findLead(id);
    }

    @GetMapping("/all")
    public List<Lead> findAll(){
        return leadService.getList();
    }

    @PostMapping("/new")
    public Lead create(@RequestBody @Valid LeadDTO leadDTO){
        return leadService.validateCreate(leadDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteLead(@PathVariable Long id) { leadService.delete(id); }
}
