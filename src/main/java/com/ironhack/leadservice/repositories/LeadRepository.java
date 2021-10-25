package com.ironhack.leadservice.repositories;

import com.ironhack.leadservice.dao.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {
}
