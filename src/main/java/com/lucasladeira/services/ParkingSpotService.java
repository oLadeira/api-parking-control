package com.lucasladeira.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;


public interface ParkingSpotService {

	ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
	void deleteParkingSpot(UUID id);
	void updateParkingSpot(UUID id, ParkingSpot parkingSpot);
	Page<ParkingSpot> getAllParkingSpots(Pageable pageable);
	Optional<ParkingSpot> getByIdParkingSpot(UUID id);
	
	void addResidentCarToParkingSpot(String parkingSpotNumber, String licenseCarPlate);

	ParkingSpot fromDTO(ParkingSpotDTO parkingSpotDTO);
}
