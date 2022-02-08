package com.lucasladeira.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.repositories.ParkingSpotRepository;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService{

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	
	
	@Override
	@Transactional
	public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
		parkingSpot.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); 
		return parkingSpotRepository.save(parkingSpot);
	}

	@Override
	public Page<ParkingSpot> getAllParkingSpots(Pageable pageable){
		return parkingSpotRepository.findAll(pageable);
	}

	@Override
	public Optional<ParkingSpot> getByIdParkingSpot(UUID id) {
		return parkingSpotRepository.findById(id);
	}
	
	@Override
	public void deleteParkingSpot(ParkingSpot parkingSpot) {
		parkingSpotRepository.delete(parkingSpot);	
	}
	
	@Override
	public void updateParkingSpot(UUID id, ParkingSpot parkingSpot) {
		Optional<ParkingSpot> optional = parkingSpotRepository.findById(id);
		
		if (optional.isEmpty()) {
			//todo
		}
		
		parkingSpot.setId(optional.get().getId());
		parkingSpot.setRegistrationDate(optional.get().getRegistrationDate());
		parkingSpotRepository.save(parkingSpot);
	}
	
	
	public boolean existsByLicensePlateCar(String licenseCarPlate) {
		return parkingSpotRepository.existsByLicensePlateCar(licenseCarPlate);
	}
	
	public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
		return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
	}
	
	public boolean existsByApartmentAndBlock(String apartment, String block) {
		return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
	}

	@Override
	public ParkingSpot fromDTO(ParkingSpotDTO parkingSpotDTO) {
		ParkingSpot parkingSpot = new ParkingSpot();
		parkingSpot.setParkingSpotNumber(parkingSpotDTO.getParkingSpotNumber());
		parkingSpot.setLicensePlateCar(parkingSpotDTO.getLicensePlateCar());
		parkingSpot.setBrandCar(parkingSpotDTO.getBrandCar());
		parkingSpot.setModelCar(parkingSpotDTO.getModelCar());
		parkingSpot.setColorCar(parkingSpotDTO.getColorCar());
		parkingSpot.setResponsibleName(parkingSpotDTO.getResponsibleName());
		parkingSpot.setApartment(parkingSpotDTO.getApartment());
		parkingSpot.setBlock(parkingSpotDTO.getBlock());
		return parkingSpot;
	}
}
