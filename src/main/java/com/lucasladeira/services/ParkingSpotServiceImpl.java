package com.lucasladeira.services;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

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
	public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
		parkingSpot.setRegistrationDate(LocalDateTime.now()); 
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
	public Optional<ParkingSpot> getByIdParkingSpot(UUID id) {
		// TODO Auto-generated method stub
		return null;
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
