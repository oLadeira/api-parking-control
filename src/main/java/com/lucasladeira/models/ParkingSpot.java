package com.lucasladeira.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.lucasladeira.utils.ParkingSpotStatus;

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
	
	
	@NotNull(message = "{campo.block.obrigatorio}")
	@Length(max = 30, message = "padronizar em message.properties")
	private String block;
	
	private ParkingSpotStatus status;
	
//	@JoinColumn(name = "resident_id")
//	private Resident resident;
	
	@OneToOne
	@JoinColumn(name = "resident_car_id")
	private ResidentCar residentCar;
	
	
	public ParkingSpot() {}

	public ParkingSpot(UUID id, String parkingSpotNumber, String block) {
		super();
		this.id = id;
		this.parkingSpotNumber = parkingSpotNumber;
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

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public ParkingSpotStatus getStatus() {
		return status;
	}

	public void setStatus(ParkingSpotStatus status) {
		this.status = status;
	}

	public ResidentCar getResidentCar() {
		return residentCar;
	}

	public void setResidentCar(ResidentCar residentCar) {
		this.residentCar = residentCar;
	}

	
//	public Resident getResident() {
//		return resident;
//	}
//
//	public void setResident(Resident resident) {
//		this.resident = resident;
//	}
}
