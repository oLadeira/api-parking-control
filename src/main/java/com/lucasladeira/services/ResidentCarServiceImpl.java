package com.lucasladeira.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasladeira.dtos.ResidentCarDTO;
import com.lucasladeira.dtos.UpdateResidentCarDTO;
import com.lucasladeira.models.Resident;
import com.lucasladeira.models.ResidentCar;
import com.lucasladeira.repositories.ResidentCarRepository;
import com.lucasladeira.repositories.ResidentRepository;
import com.lucasladeira.services.exceptions.ObjectNotFoundException;

@Service
public class ResidentCarServiceImpl implements ResidentCarService{

	@Autowired
	private ResidentCarRepository residentCarRepository;
	
	@Autowired
	private ResidentRepository residentRepository; 
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public ResidentCar saveResidentCar(ResidentCar residentCar) {
		
		residentCar.setRegistrationTime(LocalDateTime.now(ZoneId.of("UTC")));
		return residentCarRepository.save(residentCar);
	}

	@Override
	public void updateResidentCar(UUID id, ResidentCar updatedResidentCar) {
		
		if (!residentCarRepository.existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.residentCar.naoEncontrado", null, Locale.getDefault()));
		}
		
		ResidentCar residentCar = residentCarRepository.findById(id).get();
		
		residentCar.setResponsibleName(updatedResidentCar.getResponsibleName());
		residentCar.setLicensePlateCar(updatedResidentCar.getLicensePlateCar());
		residentCar.setBrandCar(updatedResidentCar.getBrandCar());
		residentCar.setModelCar(updatedResidentCar.getModelCar());
		residentCar.setColorCar(updatedResidentCar.getColorCar());
		
		residentCarRepository.save(residentCar);
	}

	@Override
	public void deleteResidentCar(UUID id) {
		
		if (residentCarRepository.existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.residentCar.naoEncontrado", null, Locale.getDefault()));
		}
		residentCarRepository.deleteById(id);
	}

	@Override
	public Page<ResidentCar> getAllResidentCars(Pageable pageable) {
		return residentCarRepository.findAll(pageable);
	}

	@Override
	public Optional<ResidentCar> getByIdResidentCar(UUID id) {
		
		if (!residentCarRepository.existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.residentCar.naoEncontrado", null, Locale.getDefault()));
		}
		
		return residentCarRepository.findById(id);
	}

	
	@Override
	public ResidentCar fromDTO(ResidentCarDTO residentCarDTO) {
		
		Optional<Resident> resident = residentRepository.findById(residentCarDTO.getIdResident());
		resident.orElseThrow(() -> new ObjectNotFoundException(
				messageSource.getMessage("objeto.resident.naoEncontrado", null, Locale.getDefault())));
	
//		ParkingSpot parkingSpot = parkingSpotRepository.findById(residentCarDTO.getIdParkingSpot()).get();
		ResidentCar residentCar = new ResidentCar(null,
				residentCarDTO.getResponsibleName(),
				residentCarDTO.getLicensePlateCar(),
				residentCarDTO.getBrandCar(),
				residentCarDTO.getModelCar(),
				residentCarDTO.getColorCar(),
				resident.get());
		return residentCar;
	}

	@Override
	public ResidentCar fromDTO(UpdateResidentCarDTO updateResidentCarDTO) {
		ResidentCar residentCar = new ResidentCar(null,
				updateResidentCarDTO.getResponsibleName(),
				updateResidentCarDTO.getLicensePlateCar(),
				updateResidentCarDTO.getBrandCar(),
				updateResidentCarDTO.getModelCar(),
				updateResidentCarDTO.getColorCar(),
				null);
		return residentCar;
	}

}
