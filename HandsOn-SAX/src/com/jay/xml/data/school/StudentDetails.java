package com.jay.xml.data.school;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class StudentDetails extends DefaultHandler 
{
	
	boolean stuFirstName = false;
	boolean stuSecondName = false;
	boolean stuYearJoined = false;
	boolean stuGrade = false;
	
	public void startElement(final String uri, final String localName, 
			final String qName, final Attributes attributes) throws SAXException 
	{
		System.out.println("Start Element :: " + qName);
		
		if (qName.equalsIgnoreCase("FIRSTNAME")) 
		{
			stuFirstName = true;
		}
		else if (qName.equalsIgnoreCase("SECONDNAME")) 
		{
			stuSecondName = true;
		}
		else if (qName.equalsIgnoreCase("YEAR-JOINED"))
		{
			stuYearJoined = true;
		}
		else if (qName.equalsIgnoreCase("GRADE"))
		{
			stuGrade = true;
		}
	}
	
	public void endElement(final String uri, final String localName,
			final String qName) throws SAXException 
	{
		System.out.println("End Element :: " + qName);
	}
	
	public void characters(final char ch[], final int start, final int length) throws SAXException 
	{
		if (stuFirstName)
		{
			System.out.println("Student First Name :: " + new String(ch, start, length));
			stuFirstName = false;
		}
		else if (stuSecondName) 
		{
			System.out.println("Student Second Name :: " + new String(ch, start, length));
			stuSecondName = false;
		}
		else if (stuYearJoined)
		{
			System.out.println("Student Joined Year :: " + new String(ch, start, length));
			stuYearJoined = false;
		} 
		else if (stuGrade)
		{
			System.out.println("Student Grade :: " + new String(ch, start, length));
			stuGrade = false;
		}
	}

}
