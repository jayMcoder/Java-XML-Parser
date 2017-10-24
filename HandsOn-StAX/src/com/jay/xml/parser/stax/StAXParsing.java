package com.jay.xml.parser.stax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import com.jay.xml.data.office.EmployeeInfo;

public class StAXParsing 
{

	public static void main(String args[]) throws XMLStreamException, IOException 
	{
		
		final StAXParsing staxParsing = new StAXParsing();
		staxParsing.generateXML();
		staxParsing.parseXML();

	}

	public void generateXML() throws XMLStreamException, IOException 
	{
		
		System.out.println("==== Generate EmployeeInfo.xml using StAX ====");
		final File employeeInfo = new File("EmployeeInfo.xml");
		final XMLOutputFactory xmlOutput = XMLOutputFactory.newInstance();
		final XMLStreamWriter writer = xmlOutput.createXMLStreamWriter(new FileOutputStream(employeeInfo));

		writer.writeStartDocument("UTF-8", "1.0");
		
		writer.writeStartElement(EmployeeInfo.ROOT_ELEMENT);
		
		writer.writeStartElement(EmployeeInfo.EMPLOYEE_ELEMENT);
		
		writer.writeStartElement(EmployeeInfo.EMP_ID_ELEMENT);
		writer.writeCharacters("3390");
		writer.writeEndElement();
		
		writer.writeStartElement(EmployeeInfo.FIRSTNAME_ELEMENT);
		writer.writeCharacters("spider");
		writer.writeEndElement();
		
		writer.writeStartElement(EmployeeInfo.SECONDNAME_ELEMENT);
		writer.writeCharacters("man");
		writer.writeEndElement();
		
		writer.writeStartElement(EmployeeInfo.DEPARTMENT_ELEMENT);
		writer.writeCharacters("student");
		writer.writeEndElement();
		
		writer.writeStartElement(EmployeeInfo.AGE_ELEMENT);
		writer.writeCharacters("21");
		writer.writeEndElement();
		
		writer.writeEndDocument();
		
		writer.flush();
		writer.close();
		
		System.out.println(readFile(employeeInfo));
	}

	public void parseXML() throws FileNotFoundException, XMLStreamException {

		// Create XMLStreamReader for StAX parsing
		System.out.println("==== Parse ParseEmployeeInfo.xml using StAX ====");
		final File parseEmployeeInfo = new File("ParseEmployeeInfo.xml");
		final XMLInputFactory xmlInput = XMLInputFactory.newInstance();
		final XMLStreamReader parser = xmlInput.createXMLStreamReader(new FileInputStream(parseEmployeeInfo));

		// Iterate parser to get each element
		int inElement = 0;
		for (int element = parser.next(); element != XMLStreamConstants.END_DOCUMENT; element = parser.next()) {
			switch(element) {
			case XMLStreamConstants.START_ELEMENT:
				if(EmployeeInfo.startElement(parser.getLocalName())) {
					inElement++;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				if(EmployeeInfo.endElement(parser.getLocalName())) {
					inElement--;
					if(inElement == 0) { System.out.println(); }
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				if(inElement > 0) { System.out.println(parser.getText()); }
				break;
			}
		}
		
		// Close parser stream
		parser.close();
	}
	
	private String readFile(final File fileObj) throws IOException 
	{
		final FileInputStream fileInputStream = new FileInputStream(fileObj);
		final byte[] fileBytes = new byte[(int) fileObj.length()];
		fileInputStream.read(fileBytes);
		fileInputStream.close();
		
		return new String(fileBytes, "UTF-8").toString();
		
	}

}
