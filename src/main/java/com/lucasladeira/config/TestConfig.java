package com.lucasladeira.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.models.ParkingSpot;
import com.lucasladeira.models.Resident;
import com.lucasladeira.models.ResidentCar;
import com.lucasladeira.services.ParkingSpotServiceImpl;
import com.lucasladeira.services.ResidentCarServiceImpl;
import com.lucasladeira.services.ResidentServiceImpl;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ResidentServiceImpl residentServiceImpl;
	
	@Autowired
	private ResidentCarServiceImpl residentCarServiceImpl;
	
	@Autowired
	private ParkingSpotServiceImpl parkingSpotServiceImpl;
	
	@Override
	public void run(String... args) throws Exception {
		
		Resident r1 = new Resident(null, "Henrique Silva", "58640869081", "henrique@gmail.com", "101A", "A");
		residentServiceImpl.saveResident(r1);		
		ResidentCar rc1 = new ResidentCar(null, "Henrique Silva", "DSF5075", "BMW", "M3 3.2 24V", "Azul", r1);
		residentCarServiceImpl.saveResidentCar(rc1);
		
		Resident r2 = new Resident(null, "Gustavo Soares", "15167702003", "gustavin33@gmail.com", "102A", "A");
		residentServiceImpl.saveResident(r2);		
		ResidentCar rc2 = new ResidentCar(null, "Gustavo Soares", "DMF6491", "Fiat", "Stilo 1.8 MS Lim.Edit./ MS Season 16V", "Vermelho", r2);
		residentCarServiceImpl.saveResidentCar(rc2);
		
		
		Resident r3 = new Resident(null, "Lucas Ladeira", "94481917075", "ladeira11@gmail.com", "103A", "A");
		residentServiceImpl.saveResident(r3);
		Resident r4 = new Resident(null, "Paulo Henrique", "15069926098", "paulinho@gmail.com", "104A", "A");
		residentServiceImpl.saveResident(r4);	
		Resident r5 = new Resident(null, "Gustavo Lima", "15315412083", "gustavilima@gmail.com", "105A", "A");
		residentServiceImpl.saveResident(r5);	
		Resident r6 = new Resident(null, "Gabriel Augusto", "21915714095", "gabriel51@gmail.com", "106A", "A");
		residentServiceImpl.saveResident(r6);	
		Resident r7 = new Resident(null, "Rafael Santos", "05062798043", "rafa99@gmail.com", "107A", "A");
		residentServiceImpl.saveResident(r7);	
		Resident r8 = new Resident(null, "Antonio Luiz", "66726920024", "tonhao22@gmail.com", "108A", "A");
		residentServiceImpl.saveResident(r8);	
		
		
		ParkingSpot p1 = new ParkingSpot(null, "100", "A");
		ParkingSpot p2 = new ParkingSpot(null, "101", "A");
		ParkingSpot p3 = new ParkingSpot(null, "102", "A");
		
		parkingSpotServiceImpl.saveParkingSpot(p1);
		parkingSpotServiceImpl.saveParkingSpot(p2);
		parkingSpotServiceImpl.saveParkingSpot(p3);
		
		parkingSpotServiceImpl.addResidentCarToParkingSpot("102", "DMF6491");
	}
}
