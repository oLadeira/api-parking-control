package com.lucasladeira.controllers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public ResponseEntity<Page<ParkingSpot>> getAllParkingSpots
	(
			@PageableDefault(page = 0, size = 10, sort="id", direction = Sort.Direction.ASC) Pageable pageable
	)
	{
		Page<ParkingSpot> parkingSpots = parkingSpotServiceImpl.getAllParkingSpots(pageable);
		return ResponseEntity.ok().body(parkingSpots);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getByIdParkingSpot(@PathVariable UUID id){
		Optional<ParkingSpot> parkingSpot = parkingSpotServiceImpl.getByIdParkingSpot(id);
		
		if (parkingSpot.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
		}
		
		return ResponseEntity.ok().body(parkingSpot.get());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable UUID id){
		Optional<ParkingSpot> parkingSOptional = parkingSpotServiceImpl.getByIdParkingSpot(id);
		
		if (parkingSOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found!");
		}
		
		parkingSpotServiceImpl.deleteParkingSpot(parkingSOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Parking Spot deleted successfully!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable UUID id, @RequestBody ParkingSpotDTO dto){
		parkingSpotServiceImpl.updateParkingSpot(id, parkingSpotServiceImpl.fromDTO(dto));
		return ResponseEntity.status(HttpStatus.OK).body("Parking Spot updated successfully!");
	}
}
