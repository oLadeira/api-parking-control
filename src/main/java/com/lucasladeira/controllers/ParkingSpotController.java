package com.lucasladeira.controllers;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.dtos.ResidentCarToParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.services.ParkingSpotServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/parking-spot")
public class ParkingSpotController {

	@Autowired
	private ParkingSpotServiceImpl parkingSpotServiceImpl;
	
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDTO parkingSpotDTO){
		parkingSpotServiceImpl.saveParkingSpot(parkingSpotServiceImpl.fromDTO(parkingSpotDTO));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("add-resident-car")
	public ResponseEntity<Object> addResidentCarToParkingSpot(@RequestBody ResidentCarToParkingSpotDTO residentToParkingSpotDTO){
		parkingSpotServiceImpl.addResidentCarToParkingSpot(residentToParkingSpotDTO.getParkingSpotNumber(),
															residentToParkingSpotDTO.getLicensePlateCar());
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PostMapping("/remove-resident-car")
	public ResponseEntity<Object> removeResidentCarFromParkingSpot(@RequestBody ResidentCarToParkingSpotDTO residentCarToParkingSpotDTO){
		parkingSpotServiceImpl.removeResidentCarFromParkingSpot(residentCarToParkingSpotDTO);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@GetMapping
	public ResponseEntity<Page<ParkingSpot>> getAllParkingSpot(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable){
		Page<ParkingSpot> parkingSpot = parkingSpotServiceImpl.getAllParkingSpots(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpot);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable UUID id, @RequestBody ParkingSpotDTO parkingSpotDTO){
		parkingSpotServiceImpl.updateParkingSpot(id, parkingSpotServiceImpl.fromDTO(parkingSpotDTO));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
