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
	public ResponseEntity<Void> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
		ParkingSpot parkingSpot = parkingSpotServiceImpl.fromDTO(parkingSpotDTO);
		parkingSpotServiceImpl.saveParkingSpot(parkingSpot);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	
}
