package com.lucasladeira.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lucasladeira.dtos.ResidentDTO;
import com.lucasladeira.models.Resident;

public interface ResidentService {

	Resident saveResident(Resident resident);
	void deleteResident(UUID id);
	void updateResident(UUID id, Resident updatedResident);
	Page<Resident> getAllResidents(Pageable pageable);
	Optional<Resident> getByIdResident(UUID id);
	
	Resident fromDTO(ResidentDTO residentDTO);
	boolean existsById(UUID id);
}
