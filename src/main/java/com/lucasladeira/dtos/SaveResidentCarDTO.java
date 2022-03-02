package com.lucasladeira.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class SaveResidentCarDTO {

	@CPF
	private String residentCPF;
	
	private String responsibleName;
	
	@NotEmpty(message = "{campo.licensePlateCar.obrigatorio}")
	@Length(max = 7, message = "{campo.licensePlateCar.tamanhoMaximo}")
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
	
	public SaveResidentCarDTO() {}

	public SaveResidentCarDTO(String residentCPF, String responsibleName,
			@NotEmpty(message = "{campo.licensePlateCar.obrigatorio}") @Length(max = 7, message = "{campo.licensePlateCar.tamanhoMaximo}") String licensePlateCar,
			@NotEmpty(message = "{campo.brandCar.obrigatorio}") @Length(max = 50, message = "{campo.brandCar.tamanhoMaximo}") String brandCar,
			@NotEmpty(message = "{campo.modelCar.obrigatorio}") @Length(max = 255, message = "{campo.modelCar.tamanhoMaximo}") String modelCar,
			@NotEmpty(message = "{campo.colorCar.obrigatorio}") @Length(max = 20, message = "{campo.colorCar.tamanhoMaximo}") String colorCar) {
		super();
		this.residentCPF = residentCPF;
		this.responsibleName = responsibleName;
		this.licensePlateCar = licensePlateCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.colorCar = colorCar;
	}

	public String getResidentCPF() {
		return residentCPF;
	}

	public void setResidentCPF(String residentCPF) {
		this.residentCPF = residentCPF;
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
}
