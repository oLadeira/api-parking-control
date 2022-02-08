package com.lucasladeira.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "TB_PARKING_SPOT")
public class ParkingSpot implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(unique = true)
	@NotNull(message = "{campo.parkingSpotNumber.obrigatorio}")
	@Length(max = 10, message = "padronizar em message.properties")
	private String parkingSpotNumber;
	
	@Column(unique = true)
	@NotNull(message = "{campo.licensePlateCar.obrigatorio}")
	@Length(max = 7, message = "padronizar em message.properties")
	private String licensePlateCar;
	
	@NotNull(message = "{campo.brandCar.obrigatorio}")
	@Length(max = 70, message = "padronizar em message.properties")
	private String brandCar;
	
	@NotNull(message = "{campo.modelCar.obrigatorio}")
	@Length(max = 70, message = "padronizar em message.properties")
	private String modelCar;
	
	@NotNull(message = "{campo.colorCar.obrigatorio}")
	@Length(max = 70, message = "padronizar em message.properties")
	private String colorCar;
	
	@NotNull(message = "Data de registro obrigatoria")
	private LocalDateTime registrationDate;

	@NotNull(message = "{campo.responsibleName.obrigatorio}")
	@Length(max = 130, message = "padronizar em message.properties")
	private String responsibleName;
	
	@NotNull(message = "{campo.apartment.obrigatorio}")
	@Length(max = 30, message = "padronizar em message.properties")
	private String apartment;
	
	@NotNull(message = "{campo.block.obrigatorio}")
	@Length(max = 30, message = "padronizar em message.properties")
	private String block;
	
	
	public ParkingSpot() {}

	public ParkingSpot(UUID id, String parkingSpotNumber, String licensePlateCar, String brandCar, 
			String modelCar, String colorCar, LocalDateTime registrationDate, String responsibleName, String apartment,
			String block) {
		super();
		this.id = id;
		this.parkingSpotNumber = parkingSpotNumber;
		this.licensePlateCar = licensePlateCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.colorCar = colorCar;
		this.registrationDate = registrationDate;
		this.responsibleName = responsibleName;
		this.apartment = apartment;
		this.block = block;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
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
