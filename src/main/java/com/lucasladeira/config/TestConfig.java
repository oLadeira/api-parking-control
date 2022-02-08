package com.lucasladeira.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.dtos.ParkingSpotDTO;
import com.lucasladeira.services.ParkingSpotServiceImpl;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ParkingSpotServiceImpl parkingSpotServiceImpl;
	
	@Override
	public void run(String... args) throws Exception {
		
	ParkingSpotDTO ps1 = new ParkingSpotDTO("102A", "DZA3290", "Ford", "F-250 XL 3.9 4x2 Diesel", "Marrom", "Joana Silva", "322", "A");	
	parkingSpotServiceImpl.saveParkingSpot(parkingSpotServiceImpl.fromDTO(ps1));	
	
	ParkingSpotDTO ps2 = new ParkingSpotDTO("103A", "DHX6558", "Ford", "Fusion SEL 3.0 V6  24V 243cv Aut.", "Dourado", "Maria Aparecida", "202", "A");	
	parkingSpotServiceImpl.saveParkingSpot(parkingSpotServiceImpl.fromDTO(ps2));
	
	ParkingSpotDTO ps3 = new ParkingSpotDTO("104A", "CEJ0172", "Citroen", "C4 Picasso Grand 2.0 16V 143cv Aut", "Laranha", "Paulo Augusto", "207", "A");	
	parkingSpotServiceImpl.saveParkingSpot(parkingSpotServiceImpl.fromDTO(ps3));
	
	ParkingSpotDTO ps4 = new ParkingSpotDTO("105A", "GGD1271", "BMW", "535iA M Sport 3.0 24V 306cv Bi-Turbo", "Preto", "Antonio Das Dores", "311", "A");	
	parkingSpotServiceImpl.saveParkingSpot(parkingSpotServiceImpl.fromDTO(ps4));
	}
}
