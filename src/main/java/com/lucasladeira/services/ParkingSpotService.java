package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;


public interface ParkingSpotService {

	ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
	void deleteParkingSpot(ParkingSpot parkingSpot);
	void updateParkingSpot(UUID id, ParkingSpot parkingSpot);
	Page<ParkingSpot> getAllParkingSpots(Pageable pageable);
	List<ParkingSpot> getAllParkingSpots();
	Optional<ParkingSpot> getByIdParkingSpot(UUID id);
	
	ParkingSpot fromDTO(ParkingSpotDTO parkingSpotDTO);
}
