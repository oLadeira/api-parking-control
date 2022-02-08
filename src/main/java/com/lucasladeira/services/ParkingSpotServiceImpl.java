package com.lucasladeira.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
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
	public void deleteParkingSpot(ParkingSpot parkingSpot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ParkingSpot> getAllParkingSpots(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<ParkingSpot> getAllParkingSpots() {
		return parkingSpotRepository.findAll();
	}

	@Override
	public Optional<ParkingSpot> getByIdParkingSpot(UUID id) {
		return parkingSpotRepository.findById(id);
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
