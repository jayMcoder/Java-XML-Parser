package com.jay.xml.data.store;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "customerId", "customerName" })
@XmlRootElement(name = "CustomerInfo")
public class CustomerInfo 
{
	
	private Long customerId;
	
	private String customerName;

	public Long getCustomerId() 
	{
		return customerId;
	}

	@XmlElement(name = "CustomerInfo_CustomerId", type = Long.class)
	public void setCustomerId(final Long customerId) 
	{
		this.customerId = customerId;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	@XmlElement(name = "CustomerInfo_CustomerName", type = String.class)
	public void setCustomerName(final String customerName) 
	{
		this.customerName = customerName;
	}
	
	public String toString() 
	{
		return this.customerId + "-" + this.customerName;
	}

}
