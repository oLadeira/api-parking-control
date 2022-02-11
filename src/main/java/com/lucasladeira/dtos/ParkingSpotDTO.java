package com.lucasladeira.dtos;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.lucasladeira.utils.ParkingSpotStatus;

public class ParkingSpotDTO {

	@NotBlank(message = "{campo.parkingSpotNumber.obrigatorio}")
	private String parkingSpotNumber;
		
	@NotBlank(message = "{campo.block.obrigatorio}")
	private String block;

	private ParkingSpotStatus status;
	
	private UUID residentCar;
	
	public ParkingSpotDTO(String parkingSpotNumber, String block) {
		super();
		this.parkingSpotNumber = parkingSpotNumber;
		this.block = block;
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

	public UUID getResidentCar() {
		return residentCar;
	}

	public void setResidentCar(UUID residentCar) {
		this.residentCar = residentCar;
	}	
}
