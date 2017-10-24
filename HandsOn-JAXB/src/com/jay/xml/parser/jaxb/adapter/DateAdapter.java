package com.jay.xml.parser.jaxb.adapter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> 
{

	@Override
	public LocalDate unmarshal(final String date) throws Exception 
	{
		return LocalDate.parse(date);
	}

	@Override
	public String marshal(final LocalDate date) throws Exception 
	{
		return date.toString();
	}

	
}
