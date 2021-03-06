package com.lucasladeira.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.models.ResidentCar;

public interface ResidentCarRepository extends JpaRepository<ResidentCar, UUID>{

	ResidentCar findByLicensePlateCar(String licensePlateCar);
	boolean existsById(UUID id);
	boolean existsByLicensePlateCar(String licensePlateCar);
}
