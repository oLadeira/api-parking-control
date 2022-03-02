package com.lucasladeira.services;

import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.dtos.ResidentCarToParkingSpotDTO;
import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.models.ResidentCar;
import com.lucasladeira.repositories.ParkingSpotRepository;
import com.lucasladeira.repositories.ResidentCarRepository;
import com.lucasladeira.services.exceptions.DataIntegrityException;
import com.lucasladeira.services.exceptions.ObjectNotFoundException;
import com.lucasladeira.utils.ParkingSpotStatus;

@Service
public class ParkingSpotServiceImpl implements ParkingSpotService{

	@Autowired
	private ParkingSpotRepository parkingSpotRepository;
	
	@Autowired
	private ResidentCarRepository residentCarRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public ParkingSpot saveParkingSpot(ParkingSpot parkingSpot) {
		
		if (parkingSpotRepository.existsByParkingSpotNumber(parkingSpot.getParkingSpotNumber())) {
			throw new DataIntegrityException(
					messageSource.getMessage("integrity.parkingSpot.entidadePreviamenteCadastrada", null, Locale.getDefault()));
		}
		
		parkingSpot.setStatus(ParkingSpotStatus.VAZIO);
		return parkingSpotRepository.save(parkingSpot);
	}

	@Override
	public void deleteParkingSpot(UUID id) {
		
		if (!parkingSpotRepository.existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.parkingSpot.naoEncontrado", null, Locale.getDefault()));
		}
		parkingSpotRepository.deleteById(id);
	}

	@Override
	public void updateParkingSpot(UUID id, ParkingSpot updatedParkingSpot) {
		if (!parkingSpotRepository.existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.parkingSpot.naoEncontrado", null, Locale.getDefault()));
		}
		
		if (parkingSpotRepository.existsByParkingSpotNumber(updatedParkingSpot.getParkingSpotNumber())) {
			throw new DataIntegrityException(
					messageSource.getMessage("integrity.parkingSpot.entidadePreviamenteCadastrada", null, Locale.getDefault()));
		}

		ParkingSpot parkingSpot = parkingSpotRepository.findById(id).get();
		
		parkingSpot.setParkingSpotNumber(updatedParkingSpot.getParkingSpotNumber());
		parkingSpot.setBlock(updatedParkingSpot.getBlock());
		parkingSpotRepository.save(parkingSpot);
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
		
		if (!parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.parkingSpot.naoEncontrado", null, Locale.getDefault()));
		}
		
		if (!residentCarRepository.existsByLicensePlateCar(licenseCarPlate)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.resident.naoEncontrado", null, Locale.getDefault()));
		}
		
		if (parkingSpot.getResidentCar() != null) {
			throw new DataIntegrityException(
					messageSource.getMessage("integrity.parkingSpot.entidadeResidentCarPreviamenteCadastrada", null, Locale.getDefault()));
		}
		
		parkingSpot.setResidentCar(residentCar);
		parkingSpot.setStatus(ParkingSpotStatus.OCUPADO);
		parkingSpotRepository.save(parkingSpot);
	}
	
	@Override
	public void removeResidentCarFromParkingSpot(ResidentCarToParkingSpotDTO residentCarToParkingSpotDTO) {
		
		ParkingSpot parkingSpot = parkingSpotRepository.findByParkingSpotNumber(residentCarToParkingSpotDTO.getParkingSpotNumber());
		parkingSpot.setResidentCar(null);
		parkingSpot.setStatus(ParkingSpotStatus.VAZIO);
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
