package com.lucasladeira.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dtos.ResidentCarDTO;
import com.lucasladeira.services.ResidentCarServiceImpl;

@RestController
@RequestMapping("api/resident-car")
public class ResidentCarController {

	@Autowired
	private ResidentCarServiceImpl residentCarServiceImpl;
	
	
	@PostMapping
	public ResponseEntity<Object> saveResidentCar(@RequestBody ResidentCarDTO residentCarDTO){
		residentCarServiceImpl.saveResidentCar(residentCarServiceImpl.fromDTO(residentCarDTO));
		return ResponseEntity.status(HttpStatus.CREATED).body("Veiculo cadastrado com sucesso!");
	}
	
}
