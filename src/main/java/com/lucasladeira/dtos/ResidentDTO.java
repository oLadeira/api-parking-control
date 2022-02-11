package com.lucasladeira.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class ResidentDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "{campo.name.obrigatorio}")
	@Length(max = 100)
	private String name;
	
	@CPF
	@NotEmpty
	@Length(max = 11)
	private String cpf;
	
	@Email
	@Length(max = 140)
	private String email;
	
	@NotEmpty
	@Length(max = 4)
	private String apartment;
	
	@NotEmpty
	@Length(max = 1)
	private String block;
	
	public ResidentDTO() {}
	
	public ResidentDTO(String name, String cpf, String email, String apartment, String block) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.apartment = apartment;
		this.block = block;
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
}
