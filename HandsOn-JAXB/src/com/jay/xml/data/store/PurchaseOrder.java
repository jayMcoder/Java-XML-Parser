package com.jay.xml.data.store;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.jay.xml.parser.jaxb.adapter.DateAdapter;

@XmlType(propOrder = { "orderId", "orderDate", "productName", "productQuantity", "productCost", "totalCost", "customerInfo" })
@XmlRootElement(name = "PurchaseOrder")
public class PurchaseOrder 
{
	
	private String productName;
	
	private Integer productQuantity;
	
	private Long orderId;
	
	private LocalDate orderDate;
	
	private Double productCost;
	
	private Double totalCost;
	
	private CustomerInfo customerInfo;

	private Integer importance;

	@XmlElement(name = "PurchaseOrder_ProductName", type = String.class)
	public void setProductName(final String productName) 
	{
		this.productName = productName;
	}
	
	@XmlElement(name = "PurchaseOrder_ProductQuantity", type = Integer.class)
	public void setProductQuantity(final Integer productQuantity)
	{
		this.productQuantity = productQuantity;
	}
	
	@XmlElement(name = "PurchaseOrder_ProductCost", type = Double.class)
	public void setProductCost(final Double productCost) 
	{
		this.productCost = productCost;
	}
	
	@XmlElement(name = "PurchaseOrder_OrderId", type = Long.class)
	public void setOrderId( final Long orderId) 
	{
		this.orderId = orderId;
	}
	
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement(name = "PurchaseOrder_OrderDate")
	public void setOrderDate(final LocalDate orderDate) 
	{
		this.orderDate = orderDate;
	}
	
	@XmlElement(name = "PurchaseOrder_TotalCost", type = Double.class)
	public void setTotalCost( final Double totalCost) 
	{
		this.totalCost = totalCost;
	}
	
	@XmlElement(name = "PurchaseOrder_CustomerInfo", type = CustomerInfo.class)
	public void setCustomerInfo(CustomerInfo customerInfo) 
	{
		this.customerInfo = customerInfo;
	}
	
	@XmlAttribute(name = "Importance", required = true)
	public void setImportance(final Integer importance) 
	{
		this.importance = importance;
	}
	
	public Integer getImportance() 
	{
		return this.importance;
	}
	
	public Long getOrderId() 
	{
		return this.orderId;
	}
	
	public String getProductName() 
	{
		return this.productName;
	}
	
	public Double getProductCost() 
	{
		return this.productCost;
	}
	
	public Integer getProductQuantity() 
	{
		return this.productQuantity;
	}
	
	public Double getTotalCost() 
	{
		return this.totalCost;
	}
	
	public LocalDate getOrderDate() 
	{
		return this.orderDate;
	}
	
	public CustomerInfo getCustomerInfo() 
	{
		return customerInfo;
	}
	
	public String toString() 
	{
		return this.importance + "-" + this.orderId + "-" + this.orderDate + "-" + this.productName + "-"
				+ this.productCost + "-" + this.productQuantity + "-" + this.totalCost + "-" + this.customerInfo;
	}
	
}
