package com.jay.xml.parser.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.jay.xml.data.school.StudentDetails;

public class SAXParsing 
{
	public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException 
	{
		final SAXParsing saxParsing = new SAXParsing();
		saxParsing.parseXML();
	}
	
	public void parseXML() throws ParserConfigurationException, SAXException, IOException 
	{		
		final SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
		
		// Parse xml file
		System.out.println("==== Parse ParseStudentRecord.xml using SAX ====");
		final File parseStudentRecordFile = new File("ParseStudentRecord.xml");
		saxParser.parse(parseStudentRecordFile, new StudentDetails());
		
	}

}
