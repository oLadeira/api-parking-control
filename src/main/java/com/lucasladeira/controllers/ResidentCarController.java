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

import com.lucasladeira.dtos.SaveResidentCarDTO;
import com.lucasladeira.dtos.UpdateResidentCarDTO;
import com.lucasladeira.models.ResidentCar;
import com.lucasladeira.services.ResidentCarServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/resident-car")
public class ResidentCarController {

	@Autowired
	private ResidentCarServiceImpl residentCarServiceImpl;
	
	
	@PostMapping
	public ResponseEntity<Object> saveResidentCar(@RequestBody @Valid SaveResidentCarDTO saveResidentCarDTO){
		residentCarServiceImpl.saveResidentCar(residentCarServiceImpl.fromDTO(saveResidentCarDTO));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping
	public ResponseEntity<Page<ResidentCar>> getAllResidentCar(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC ) Pageable pageable){
		Page<ResidentCar> page = residentCarServiceImpl.getAllResidentCars(pageable);
		return ResponseEntity.status(HttpStatus.OK).body(page);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResidentCar> getByIdResidentCar(@PathVariable UUID id){
		ResidentCar residentCar = residentCarServiceImpl.getByIdResidentCar(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(residentCar);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateResidentCar(@PathVariable UUID id, @RequestBody @Valid UpdateResidentCarDTO updateResidentCarDTO){
		residentCarServiceImpl.updateResidentCar(id, residentCarServiceImpl.fromDTO(updateResidentCarDTO));
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteResidentCar (@PathVariable UUID id){
		residentCarServiceImpl.deleteResidentCar(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
