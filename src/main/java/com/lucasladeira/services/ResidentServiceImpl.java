package com.lucasladeira.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lucasladeira.dtos.ResidentDTO;
import com.lucasladeira.models.Resident;
import com.lucasladeira.repositories.ResidentRepository;
import com.lucasladeira.services.exceptions.DataIntegrityException;
import com.lucasladeira.services.exceptions.ObjectNotFoundException;

@Service
public class ResidentServiceImpl implements ResidentService{

	@Autowired
	private ResidentRepository residentRepository;
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public Resident saveResident(Resident resident) {
		resident.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC")));
		return residentRepository.save(resident);
	}

	@Override
	public void deleteResident(UUID id) {
		if (!existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.resident.naoEncontrado", null, Locale.getDefault()));
		}
		
		try {
			residentRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException(
					messageSource.getMessage("integrity.resident.entidadesRelacionadas", null, Locale.getDefault()));
		}
		
	}

	@Override
	public void updateResident(UUID id, Resident updatedResident) {
		if (!existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.resident.naoEncontrado", null, Locale.getDefault()));
		}
		
		Resident resident = residentRepository.findById(id).get();
		resident.setName(updatedResident.getName());
		resident.setCpf(updatedResident.getCpf());
		resident.setEmail(updatedResident.getEmail());
		resident.setApartment(updatedResident.getApartment());
		resident.setBlock(updatedResident.getBlock());
		
		residentRepository.save(resident);
	}

	@Override
	public Page<Resident> getAllResidents(Pageable pageable) {
		return residentRepository.findAll(pageable);
	}

	@Override
	public Optional<Resident> getByIdResident(UUID id) {
		if (!existsById(id)) {
			throw new ObjectNotFoundException(
					messageSource.getMessage("objeto.resident.naoEncontrado", null, Locale.getDefault()));
		}
		return residentRepository.findById(id);
	}

	
	@Override
	public Resident fromDTO(ResidentDTO residentDTO) {
		Resident resident = new Resident(null,
				residentDTO.getName(),
				residentDTO.getCpf(),
				residentDTO.getEmail(),
				residentDTO.getApartment(),
				residentDTO.getBlock());
		return resident;
	}

	@Override
	public boolean existsById(UUID id) {
		return residentRepository.existsById(id);
	}
}
