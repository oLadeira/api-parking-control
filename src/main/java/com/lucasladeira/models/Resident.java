package com.lucasladeira.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_RESIDENT")
public class Resident implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	private String name;
	
	@CPF
	@Column(unique = true)
	private String cpf;
	
	@Email
	private String email;
	private String apartment;
	private String block;
	private LocalDateTime registrationDate;
	
//	cascade = CascadeType.ALL
//	@OneToOne(mappedBy = "resident")
//	private ParkingSpot parkingSpot;
	
	@OneToMany(mappedBy = "resident")
	private List<ResidentCar> residentCars;
	
	@PrePersist
	void prePersist() {
		this.registrationDate = LocalDateTime.now(ZoneId.of("UTC"));
	}
	
	public Resident() {}

	public Resident(UUID id, String name, String cpf, String email, String apartment, String block) {
		super();
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.apartment = apartment;
		this.block = block;
	}

	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<ResidentCar> getResidentCars() {
		return residentCars;
	}
}
