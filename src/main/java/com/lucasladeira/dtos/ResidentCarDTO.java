package com.lucasladeira.dtos;

import java.util.UUID;

public class ResidentCarDTO {

	private String responsibleName;
	private String licensePlateCar;
	private String brandCar;
	private String modelCar;
	private String colorCar;
	
	private UUID idResident;
	
	//private UUID idParkingSpot;
	
	public ResidentCarDTO(String responsibleName, String licensePlatecar, String brandCar, String modelCar,
			String colorCar, UUID idResident) {
		super();
		this.responsibleName = responsibleName;
		this.licensePlateCar = licensePlatecar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.colorCar = colorCar;
		this.idResident = idResident;
		//this.idParkingSpot = idParkingSpot;
	}
	
	public ResidentCarDTO() {}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getLicensePlateCar() {
		return licensePlateCar;
	}

	public void setLicensePlateCar(String licensePlatecar) {
		this.licensePlateCar = licensePlatecar;
	}

	public String getBrandCar() {
		return brandCar;
	}

	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}

	public String getModelCar() {
		return modelCar;
	}

	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}

	public String getColorCar() {
		return colorCar;
	}

	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}

	public UUID getIdResident() {
		return idResident;
	}

	public void setIdResident(UUID idResident) {
		this.idResident = idResident;
	}

//	public UUID getIdParkingSpot() {
//		return idParkingSpot;
//	}
//
//	public void setIdParkingSpot(UUID idParkingSpot) {
//		this.idParkingSpot = idParkingSpot;
//	}
}
