package com.lucasladeira.dtos;

public class ResidentToParkingSpotDTO {

	private String parkingSpotNumber;
	private String licensePlateCar;
	
	
	public ResidentToParkingSpotDTO() {}


	public ResidentToParkingSpotDTO(String parkingSpotNumber, String licensePlateCar) {
		super();
		this.parkingSpotNumber = parkingSpotNumber;
		this.licensePlateCar = licensePlateCar;
	}


	public String getParkingSpotNumber() {
		return parkingSpotNumber;
	}


	public void setParkingSpotNumber(String parkingSpotNumber) {
		this.parkingSpotNumber = parkingSpotNumber;
	}


	public String getLicensePlateCar() {
		return licensePlateCar;
	}


	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}
}
