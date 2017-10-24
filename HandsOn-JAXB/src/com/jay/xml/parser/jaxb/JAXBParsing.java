
package com.jay.xml.parser.jaxb;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.jay.xml.data.store.CustomerInfo;
import com.jay.xml.data.store.PurchaseOrder;
import com.jay.xml.data.store.PurchaseOrders;

/**
 * @author jay
 * 
 */
public class JAXBParsing
{
	public static void main (String args[]) throws JAXBException, IOException 
	{
		final JAXBParsing jaxbParser = new JAXBParsing();
		jaxbParser.generateXML();
		jaxbParser.parseXML();
	}

	public void generateXML() throws JAXBException, IOException 
	{
		System.out.println("==== Generate XML using JAXB ====");
		// Customer Info
		final CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustomerId(0002L);
		customerInfo.setCustomerName("New Name");
		
		// One purchase order
		final PurchaseOrder purchase1 = new PurchaseOrder();
		purchase1.setImportance(1);
		purchase1.setOrderDate(LocalDate.now());
		purchase1.setOrderId(Math.round(Math.random() * 1000));
		purchase1.setProductCost(10.5);
		purchase1.setProductName("Test Product");
		purchase1.setProductQuantity(10);
		purchase1.setTotalCost(10.5 * 10);
		purchase1.setCustomerInfo(customerInfo);

		// Init jaxb marshaler
		final JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// Set property to generate formated output xml
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshall java object to xml
		final File purchaseOrderFile = new File("PurchaseOrder.xml");
		System.out.println("==== One purchase order ====");
		jaxbMarshaller.marshal(purchase1, new File("PurchaseOrder.xml"));
		System.out.println(readFile(purchaseOrderFile));

		// Multiple purchase order
		final PurchaseOrder purchase2 = new PurchaseOrder();
		purchase2.setImportance(0);
		purchase2.setOrderDate(LocalDate.now());
		purchase2.setOrderId(Math.round(Math.random() * 1000));
		purchase2.setProductCost(102.5);
		purchase2.setProductName("Test Product 2");
		purchase2.setProductQuantity(3);
		purchase2.setTotalCost(102.5 * 3);
		purchase2.setCustomerInfo(customerInfo);

		final PurchaseOrder purchase3 = new PurchaseOrder();
		purchase3.setImportance(0);
		purchase3.setOrderDate(LocalDate.now());
		purchase3.setOrderId(Math.round(Math.random() * 1000));
		purchase3.setProductCost(1.5);
		purchase3.setProductName("Test Product 3");
		purchase3.setProductQuantity(14);
		purchase3.setTotalCost(1.5 * 140);
		purchase3.setCustomerInfo(customerInfo);

		final ArrayList<PurchaseOrder> listOrders = new ArrayList<PurchaseOrder>();
		listOrders.add(purchase1);
		listOrders.add(purchase2);
		listOrders.add(purchase3);

		final PurchaseOrders purchaseOrders = new PurchaseOrders();
		purchaseOrders.setPurchaseOrders(listOrders);

		// Init jaxb marshaler
		final JAXBContext jaxbContextMultiple = JAXBContext.newInstance(PurchaseOrders.class);
		final Marshaller jaxbMarshallerMultiple = jaxbContextMultiple.createMarshaller();

		// Set property to generate formated output xml
		jaxbMarshallerMultiple.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshall java object to xml
		final File purchaseOrdersFile = new File("PurchaseOrders.xml");
		System.out.println("==== Multiple purchase order ====");
		jaxbMarshallerMultiple.marshal(purchaseOrders, purchaseOrdersFile);
		System.out.println(readFile(purchaseOrdersFile));
	}
	
	public void parseXML() throws JAXBException 
	{
		// Init jaxb unmarshaller
		final File parsePurchaseOrderFile = new File("ParsePurchaseOrder.xml");
		final JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrder.class);
		final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		
		// Unmarshall xml to java object
		System.out.println("==== Unmarshall ParsePurchaseOrder.xml to java object ====");
		final PurchaseOrder purchaseOrder = (PurchaseOrder) jaxbUnmarshaller.unmarshal(parsePurchaseOrderFile);
		System.out.println(purchaseOrder);
		
		// Init jaxb unmarshaller multiple purchase order
		final File parsePurchaseOrdersFile = new File("ParsePurchaseOrders.xml");
		final JAXBContext jaxbContextMultiple = JAXBContext.newInstance(PurchaseOrders.class);
		final Unmarshaller jaxbUnmarshallerMultiple = jaxbContextMultiple.createUnmarshaller();
		
		//Unmarshall xml with multiple records to java object
		System.out.println("==== Unmarshall ParsePurchaseOrders.xml to java object ====");
		final PurchaseOrders purchaseOrders = (PurchaseOrders) jaxbUnmarshallerMultiple.unmarshal(parsePurchaseOrdersFile);
		System.out.println(purchaseOrders);
	}

	/**
	 *  Read file and return as string
	 * @param fileObj
	 * @return String file content as string
	 * @throws IOException
	 */
	private String readFile(final File fileObj) throws IOException
	{
		final FileInputStream fileInputStream = new FileInputStream(fileObj);
		final byte[] fileBytes = new byte[(int) fileObj.length()];
		fileInputStream.read(fileBytes);
		fileInputStream.close();

		return new String(fileBytes, "UTF-8").toString();
	}
}
