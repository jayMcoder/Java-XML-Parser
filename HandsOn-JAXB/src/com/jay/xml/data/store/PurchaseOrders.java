package com.jay.xml.data.store;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrders")
public class PurchaseOrders 
{
	@XmlElement(name = "PurchaseOrder", type = PurchaseOrder.class)
	private ArrayList<PurchaseOrder> purchaseOrdersList;

	
	public void setPurchaseOrders(final ArrayList<PurchaseOrder> purchaseOrderList) 
	{
		this.purchaseOrdersList = purchaseOrderList;
	}
	
	public ArrayList<PurchaseOrder> getPurchaseOrders() 
	{
		return this.purchaseOrdersList;
	}
	
	public String toString() 
	{
		final StringBuffer sb = new StringBuffer();
		for (final PurchaseOrder purchaseOrder : this.purchaseOrdersList) 
		{
			sb.append(purchaseOrder.toString());
			sb.append('\n');
		}
		return sb.toString();
	}
}
