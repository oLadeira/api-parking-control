package com.lucasladeira.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.models.ResidentCar;
import com.lucasladeira.repositories.ParkingSpotRepository;
import com.lucasladeira.repositories.ResidentCarRepository;
import com.lucasladeira.utils.ParkingSpotStatus;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService{

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	
	@Autowired
	private ResidentCarRepository residentCarRepository;
	
	
	@Override
	public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
		parkingSpot.setStatus(ParkingSpotStatus.VAZIO);
		return parkingSpotRepository.save(parkingSpot);
	}

	@Override
	public void deleteParkingSpot(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateParkingSpot(UUID id, ParkingSpot parkingSpot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ParkingSpot> getAllParkingSpots(Pageable pageable) {
		return parkingSpotRepository.findAll(pageable);
	}

	@Override
	public Optional<ParkingSpot> getByIdParkingSpot(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@Override
	public void addResidentCarToParkingSpot(String parkingSpotNumber, String licenseCarPlate) {
		ParkingSpot parkingSpot = parkingSpotRepository.findByParkingSpotNumber(parkingSpotNumber);
		ResidentCar residentCar = residentCarRepository.findByLicensePlateCar(licenseCarPlate);
		
		parkingSpot.setResidentCar(residentCar);
		parkingSpot.setStatus(ParkingSpotStatus.OCUPADO);
		parkingSpotRepository.save(parkingSpot);
	}

	@Override
	public ParkingSpot fromDTO(ParkingSpotDTO parkingSpotDTO) {
		ParkingSpot parkingSpot = new ParkingSpot(null,
				parkingSpotDTO.getParkingSpotNumber(),
				parkingSpotDTO.getBlock());
		return parkingSpot;
	}
}
