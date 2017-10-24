package com.jay.xml.data.vehicle;

public interface VehicleModels {
	public static String ROOT_ELEMENT = "VehicleModels";
	
	public static String CAR_ELEMENT = "Car";
	
	public static String CAR_ATTRIBUTE_ID = "id";
	
	public static String MODEL_NAME_ELEMENT = "ModelName";
	
	public static String COMPANY_NAME_ELEMENT = "CompanyName";
	
	public static String MODEL_YEAR_ELEMENT = "ModelYear";
	
	public static String ENGINE_SIZE_ELEMENT = "EngineSize";
	
	public void setAttributeId(final String id);
	
	public String getAttributeId();
	
	public void setModelName(final String modelName);
	
	public String getModelName();
	
	public void setCompanyName(final String companyName);
	
	public String getCompanyName();
	
	public void setModelYear(final String modelYear);
	
	public String getModelYear();
	
	public void setEngineSize(final String engineSize);
	
	public String getEngineSize();
}
