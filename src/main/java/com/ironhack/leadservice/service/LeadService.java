package com.ironhack.leadservice.service;

import com.ironhack.leadservice.dao.Lead;
import com.ironhack.leadservice.dto.LeadDTO;
import com.ironhack.leadservice.repositories.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    LeadRepository repository;

    public List<Lead> getList(){
        return repository.findAll();
    }

    public Lead validateCreate(LeadDTO leadDTO){
        // Check salesRepId is valid
        Lead lead = new Lead(leadDTO.getName(), leadDTO.getPhoneNumber(), leadDTO.getEmail(), leadDTO.getCompanyName(), leadDTO.getSalesRepId());
        return repository.save(lead);
    }

    public Lead findLead(Long id){
        Optional<Lead> lead = repository.findById(id);
        return lead.orElse(null);
    }
}
