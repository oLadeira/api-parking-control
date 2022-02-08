package com.lucasladeira.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDTO {

	@NotBlank(message = "{campo.parkingSpotNumber.obrigatorio}")
	private String parkingSpotNumber;
	
	@NotBlank(message = "{campo.licensePlateCar.obrigatorio}")
	@Size(max = 7)
	private String licensePlateCar;
	
	@NotBlank(message = "{campo.brandCar.obrigatorio}")
	private String brandCar;
	
	@NotBlank(message = "{campo.modelCar.obrigatorio}")
	private String modelCar;
	
	@NotBlank(message = "{campo.colorCar.obrigatorio}")
	private String colorCar;
	
	@NotBlank(message = "{campo.responsibleName.obrigatorio}")
	private String responsibleName;
	
	@NotBlank(message = "{campo.apartment.obrigatorio}")
	private String apartment;
	
	@NotBlank(message = "{campo.block.obrigatorio}")
	private String block;

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

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getApartment() {
		return apartment;
	}

	public void setApartment(String apartment) {
		this.apartment = apartment;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}	
}
