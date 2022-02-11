package com.lucasladeira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.dtos.ResidentToParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.services.ParkingSpotServiceImpl;

@RestController
@RequestMapping("api/parking-spot")
public class ParkingSpotController {

	@Autowired
	private ParkingSpotServiceImpl parkingSpotServiceImpl;
	
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody ParkingSpotDTO parkingSpotDTO){
		parkingSpotServiceImpl.saveParkingSpot(parkingSpotServiceImpl.fromDTO(parkingSpotDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body("Vaga cadastrada com sucesso!");
	}
	
	@GetMapping
	public ResponseEntity<Page<ParkingSpot>> getAllResidents(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable){
		Page<ParkingSpot> parkingSpot = parkingSpotServiceImpl.getAllParkingSpots(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpot);
	}
	
	@PostMapping("add-resident-car")
	public ResponseEntity<Object> addResidentCarToParkingSpot(@RequestBody ResidentToParkingSpotDTO residentToParkingSpotDTO){
		parkingSpotServiceImpl.addResidentCarToParkingSpot(residentToParkingSpotDTO.getParkingSpotNumber(),
															residentToParkingSpotDTO.getLicensePlateCar());
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}
	
}
