package com.jay.xml.data.office;

public class EmployeeInfo 
{
	
	public static String ROOT_ELEMENT = "office";
	
	public static String EMPLOYEE_ELEMENT = "employee";
	
	public static String EMP_ID_ELEMENT = "empid";
	
	public static String FIRSTNAME_ELEMENT = "firstname";
	
	public static String SECONDNAME_ELEMENT = "secondname";
	
	public static String DEPARTMENT_ELEMENT = "department";
	
	public static String AGE_ELEMENT = "age";
	
	public static boolean startElement(final String elementTag) 
	{
		
		System.out.println("Start Element :: " + elementTag);
		
		if(EMP_ID_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(FIRSTNAME_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(SECONDNAME_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(DEPARTMENT_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(AGE_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		return false;
	}
	
	public static boolean endElement(final String elementTag) 
	{
		System.out.println("End Element :: " + elementTag);
		
		if(EMP_ID_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(FIRSTNAME_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(SECONDNAME_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(DEPARTMENT_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		if(AGE_ELEMENT.equals(elementTag)) 
		{
			return true;
		}
		return false;
	}

}
