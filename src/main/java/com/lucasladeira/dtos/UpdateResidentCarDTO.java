package com.lucasladeira.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UpdateResidentCarDTO {
	
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
	
	public UpdateResidentCarDTO() {}

	public UpdateResidentCarDTO(String responsibleName, String licensePlateCar, String brandCar, String modelCar,
			String colorCar) {
		super();
		this.responsibleName = responsibleName;
		this.licensePlateCar = licensePlateCar;
		this.brandCar = brandCar;
		this.modelCar = modelCar;
		this.colorCar = colorCar;
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
