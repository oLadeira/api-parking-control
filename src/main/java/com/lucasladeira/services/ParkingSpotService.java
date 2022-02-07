package com.lucasladeira.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;

import com.lucasladeira.models.ParkingSpot;


public interface ParkingSpotService {

	ParkingSpot saveParkingSpot(ParkingSpot parkingSpot);
	void deleteParkingSpot(ParkingSpot parkingSpot);
	Page<ParkingSpot> getAllParkingSpots();
	Optional<ParkingSpot> getByIdParkingSpot(UUID id);
}
