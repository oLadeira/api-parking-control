package com.lucasladeira.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.models.Resident;

public interface ResidentRepository extends JpaRepository<Resident, UUID>{
	
	
	
}
