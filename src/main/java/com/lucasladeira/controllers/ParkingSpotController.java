package com.lucasladeira.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.services.ParkingSpotServiceImpl;

@RestController
@RequestMapping("/api/parking-spot")
public class ParkingSpotController {

	@Autowired
	private ParkingSpotServiceImpl parkingSpotServiceImpl;
	
		
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
		
		if (parkingSpotServiceImpl.existsByLicensePlateCar(parkingSpotDTO.getLicensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: License Plate Car is already in use");
		}
		if (parkingSpotServiceImpl.existsByParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot Number is already in use");
		}
		if (parkingSpotServiceImpl.existsByApartmentAndBlock(parkingSpotDTO.getApartment(), parkingSpotDTO.getBlock())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking Spot already registered for this apartment/block!");
		}
		
		ParkingSpot parkingSpot = parkingSpotServiceImpl.fromDTO(parkingSpotDTO);
		parkingSpotServiceImpl.saveParkingSpot(parkingSpot);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
}
