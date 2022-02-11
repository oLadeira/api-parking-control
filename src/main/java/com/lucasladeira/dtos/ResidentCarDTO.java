package com.lucasladeira.dtos;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ResidentCarDTO {

	private String responsibleName;
	
	@NotEmpty(message = "{campo.licensePlateCar.obrigatorio}")
	@Length(max = 6, message = "{campo.licensePlateCar.tamanhoMaximo}")
	private String licensePlateCar;
	
	@NotEmpty(message = "{campo.brandCar.obrigatorio}")
	@Length(max = 50, message = "{campo.brandCar.tamanhoMaximo}")
	private String brandCar;
	
	@NotEmpty(message = "{campo.modelCar.obrigatorio}")
	@Length(max = 255, message = "{campo.modelCar.tamanhoMaximo}")
	private String modelCar;
	
	@NotEmpty(message = "{campo.colorCar.obrigatorio}")
	@Length(max = 20, message = "{campo.colorCar.tamanhoMaximo}")
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
