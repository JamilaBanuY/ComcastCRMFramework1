package com.comcast.genric.fileutility;

import java.io.FileInputStream;

import java.util.Properties;

public class FileUtility {

	public String getDataFromPropertiesFile(String Key) throws Throwable
	{
	FileInputStream fis=new FileInputStream("./ConfigAppData/DataDT.properties"); //get Java object of physical file
	Properties p=new Properties();
	p.load(fis);
	String data=p.getProperty(Key);
	
	return data;
	
	
}
}