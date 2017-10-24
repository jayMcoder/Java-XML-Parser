package com.jay.xml.parser.dom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jay.xml.data.vehicle.Car;
import com.jay.xml.data.vehicle.VehicleModels;

public class DOMParsing {
	
	public static void main(String args[]) throws 
	ParserConfigurationException, TransformerFactoryConfigurationError,
	TransformerException, IOException, SAXException
	{
		final DOMParsing domParsing = new DOMParsing();
		domParsing.generateXML();
		domParsing.parseXML();
	}
	
	public void generateXML() throws ParserConfigurationException, 
		TransformerFactoryConfigurationError, TransformerException, IOException 
	{
		final Car car = new Car("1", "3", "Mazda", "2003-2009", "1349cc");
		final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
		// Root element
		final Element rootElement = doc.createElement(VehicleModels.ROOT_ELEMENT);
		doc.appendChild(rootElement);
		
		// Car element
		final Element carElement = doc.createElement(VehicleModels.CAR_ELEMENT);
		rootElement.appendChild(carElement);
		
		// set attribute to car element
		carElement.setAttribute(VehicleModels.CAR_ATTRIBUTE_ID, car.getAttributeId());
		
		// ModelName element
		final Element modelNameElement = doc.createElement(VehicleModels.MODEL_NAME_ELEMENT);
		modelNameElement.appendChild(doc.createTextNode(car.getModelName()));
		carElement.appendChild(modelNameElement);
		
		// CompanyName element
		final Element companyNameElement = doc.createElement(VehicleModels.COMPANY_NAME_ELEMENT);
		companyNameElement.appendChild(doc.createTextNode(car.getCompanyName()));
		carElement.appendChild(companyNameElement);
		
		// ModelYear element
		final Element modelYearElement = doc.createElement(VehicleModels.MODEL_YEAR_ELEMENT);
		modelYearElement.appendChild(doc.createTextNode(car.getModelYear()));
		carElement.appendChild(modelYearElement);
		
		// EngineSize element
		final Element engineSizeElement = doc.createElement(VehicleModels.ENGINE_SIZE_ELEMENT);
		engineSizeElement.appendChild(doc.createTextNode(car.getEngineSize()));
		carElement.appendChild(engineSizeElement);
		
		// Create xml file
		final Transformer transformer = TransformerFactory.newInstance().newTransformer();
		final DOMSource domSource = new DOMSource(doc);
		final File vehicleModelsFile = new File("VehicleModels.xml");
		final StreamResult streamResult = new StreamResult(vehicleModelsFile);
		
		// Set transformer property
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		
		transformer.transform(domSource, streamResult);
		
		System.out.println("==== Dom parser generate xml ====");
		System.out.println(readFile(vehicleModelsFile));
	}
	
	public void parseXML() throws SAXException, IOException, ParserConfigurationException
	{
		System.out.println("==== Parse ParseVehicleModels.xml using DOM ====");
		final File parseVehicleModelsFile = new File("ParseVehicleModels.xml");
		final Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(parseVehicleModelsFile);
		
		doc.getDocumentElement().normalize();
		
		System.out.println("Root Element :: " + doc.getDocumentElement().getNodeName());
		
		final NodeList nodeList = doc.getElementsByTagName(VehicleModels.CAR_ELEMENT);
		
		for (int i = 0; i < nodeList.getLength(); i++) 
		{
			final Node node = nodeList.item(i);
			System.out.println("--------------------------------");
			System.out.println("Element :: " + node.getNodeName());
			
			if (node.getNodeType() == Node.ELEMENT_NODE) 
			{
				final Element element = (Element) node;
				
				System.out.println("Car Id :: " + element.getAttribute(VehicleModels.CAR_ATTRIBUTE_ID));
				System.out.println("Model Name :: " + element.getElementsByTagName(VehicleModels.MODEL_NAME_ELEMENT).item(0).getTextContent());
				System.out.println("Company Name :: " + element.getElementsByTagName(VehicleModels.COMPANY_NAME_ELEMENT).item(0).getTextContent());
				System.out.println("Model Year :: " + element.getElementsByTagName(VehicleModels.MODEL_YEAR_ELEMENT).item(0).getTextContent());
				System.out.println("Engine Size :: " + element.getElementsByTagName(VehicleModels.ENGINE_SIZE_ELEMENT).item(0).getTextContent());
			}
		}
		
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
