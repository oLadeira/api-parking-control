package com.lucasladeira.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;


public interface ParkingSpotService {

	ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
	void deleteParkingSpot(ParkingSpot parkingSpot);
	void updateParkingSpot(UUID id, ParkingSpot parkingSpot);
	Page<ParkingSpot> getAllParkingSpots(Pageable pageable);
	Optional<ParkingSpot> getByIdParkingSpot(UUID id);
	
	ParkingSpot fromDTO(ParkingSpotDTO parkingSpotDTO);
}
