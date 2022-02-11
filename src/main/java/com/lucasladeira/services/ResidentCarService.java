package com.lucasladeira.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lucasladeira.dtos.ResidentCarDTO;
import com.lucasladeira.models.ResidentCar;

public interface ResidentCarService {

	ResidentCar saveResidentCar(ResidentCar residentCar);
	void updateResidentCar(UUID id, ResidentCar updatedResidentCar);
	void deleteResidentCar(UUID id);
	Page<ResidentCar> getAllResidentCars(Pageable pageable);
	Optional<ResidentCar> getByIdResidentCar(UUID id);
	
	ResidentCar fromDTO (ResidentCarDTO residentCarDTO);
}
