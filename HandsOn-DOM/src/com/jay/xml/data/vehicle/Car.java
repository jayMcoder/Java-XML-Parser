package com.jay.xml.data.vehicle;

public class Car implements VehicleModels{
	
	private String id;
	
	private String modelName;
	
	private String companyName;
	
	private String modelYear;
	
	private String engineSize;
	
	public Car() {}
	
	public Car(final String id, final String modelName, 
			final String companyName, final String modelYear, 
			final String engineSize) {
		this.id = id;
		this.modelName = modelName;
		this.companyName = companyName;
		this.modelYear = modelYear;
		this.engineSize = engineSize;
	}

	@Override
	public void setAttributeId(String id) {
		this.id = id;
	}

	@Override
	public String getAttributeId() {
		return id;
	}

	@Override
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	@Override
	public String getModelName() {
		return modelName;
	}

	@Override
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String getCompanyName() {
		return companyName;
	}

	@Override
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}

	@Override
	public String getModelYear() {
		return modelYear;
	}

	@Override
	public void setEngineSize(String engineSize) {
		this.engineSize = engineSize;
	}

	@Override
	public String getEngineSize() {
		return engineSize;
	}

}
