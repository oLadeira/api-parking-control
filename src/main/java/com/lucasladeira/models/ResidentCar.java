package com.lucasladeira.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_RESIDENT_CARS")
public class ResidentCar implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String responsibleName;
	private String licensePlateCar;
	private String brandCar;
	private String modelCar;
	private String colorCar;
	private LocalDateTime registrationTime;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "resident_id")
	private Resident resident;
	
	@JsonIgnore
	@OneToOne(mappedBy = "residentCar")
	private ParkingSpot parkingSpot;
	
	
	public ResidentCar() {}

	public ResidentCar(UUID id, String responsibleName, String licensePlateCar, String brandCar, String modelCar,
			String colorCar, Resident resident) {
		super();
		this.id = id;
		this.responsibleName = responsibleName;
		this.licensePlateCar = licensePlateCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.colorCar = colorCar;
		this.resident = resident;
//		this.parkingSpot = parkingSpot;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
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

	public LocalDateTime getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(LocalDateTime registrationTime) {
		this.registrationTime = registrationTime;
	}

	public Resident getResident() {
		return resident;
	}

	public void setResident(Resident resident) {
		this.resident = resident;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}
}
