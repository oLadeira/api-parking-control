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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dtos.ResidentDTO;
import com.lucasladeira.models.Resident;
import com.lucasladeira.repositories.ResidentRepository;
import com.lucasladeira.services.ResidentServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/resident")
public class ResidentController {

	@Autowired
	private ResidentServiceImpl residentServiceImpl;
	
	@Autowired
	private ResidentRepository residentRepository;
	
	@PostMapping
	public ResponseEntity<Object> saveResident(@RequestBody @Valid ResidentDTO residentDTO){
		residentServiceImpl.saveResident(residentServiceImpl.fromDTO(residentDTO));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resident> getByIdResident(@PathVariable UUID id){
		Resident resident = residentServiceImpl.getByIdResident(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(resident);
	}
	
	@GetMapping
	public ResponseEntity<Page<Resident>> getAllResidents(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable){
		Page<Resident> residents = residentServiceImpl.getAllResidents(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(residents);
	}
	
	@GetMapping("/qnt")
	public ResponseEntity<Integer> getQuantityResidents(){
		return ResponseEntity.status(HttpStatus.OK).body(residentRepository.findAllResidents());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateResident(@PathVariable UUID id, @RequestBody @Valid ResidentDTO residentDTO){
		residentServiceImpl.updateResident(id, residentServiceImpl.fromDTO(residentDTO));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteResident(@PathVariable UUID id){
		residentServiceImpl.deleteResident(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
