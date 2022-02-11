package com.lucasladeira.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasladeira.dtos.ResidentCarDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.models.Resident;
import com.lucasladeira.models.ResidentCar;
import com.lucasladeira.repositories.ParkingSpotRepository;
import com.lucasladeira.repositories.ResidentCarRepository;
import com.lucasladeira.repositories.ResidentRepository;

@Service
public class ResidentCarServiceImpl implements ResidentCarService{

	@Autowired
	private ResidentCarRepository residentCarRepository;
	
	@Autowired
	private ResidentRepository residentRepository; 
	
	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	
	@Override
	public ResidentCar saveResidentCar(ResidentCar residentCar) {
		residentCar.setRegistrationTime(LocalDateTime.now(ZoneId.of("UTC")));
		return residentCarRepository.save(residentCar);
	}

	@Override
	public void updateResidentCar(UUID id, ResidentCar updatedResidentCar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResidentCar(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<ResidentCar> getAllResidentCars(Pageable pageable) {
		return residentCarRepository.findAll(pageable);
	}

	@Override
	public Optional<ResidentCar> getByIdResidentCar(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ResidentCar fromDTO(ResidentCarDTO residentCarDTO) {
		Resident resident = residentRepository.findById(residentCarDTO.getIdResident()).get();
//		ParkingSpot parkingSpot = parkingSpotRepository.findById(residentCarDTO.getIdParkingSpot()).get();
		ResidentCar residentCar = new ResidentCar(null,
				residentCarDTO.getResponsibleName(),
				residentCarDTO.getLicensePlateCar(),
				residentCarDTO.getBrandCar(),
				residentCarDTO.getModelCar(),
				residentCarDTO.getColorCar(),
				resident);
		return residentCar;
	}

}
