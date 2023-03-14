package com.jan23.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtility {
	
//	public static String readPropertyData(String key) throws IOException {
//		String curdir = System.getProperty("user.dir");
//		FileInputStream fis = new FileInputStream(new File(curdir+"/src/test/resources/ testData.properties"));
//		Properties ob = new Properties();
//		ob.load(fis);
//		String value = ob.getProperty(key);
//		return value;
//		
//		
//	}
	
	private FileInputStream stream = null;
	private Properties propertyFile = null;
	
	public Properties loadFile(String filename) {
		propertyFile = new Properties();
		String PropertyFilePath = null;
		switch(filename) {
		case "applicationDataProperties":
			PropertyFilePath = Constants.APPLICATION_PROPERTIES;
			break;
//		case "studentRegistrationProperties":
//			PropertyFilePath = Constants.STUDENT_REGISTRATION_PROPERTIES;
//			break;
		}
		try {
			stream = new FileInputStream(PropertyFilePath);
			propertyFile.load(stream);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return propertyFile;
	}
	public String getPropertyValue(String Key) {
		String value = propertyFile.getProperty(Key);
		System.out.println("Property we got from the file is: "+value);
		try {
			stream.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	public HashMap getAllPropertiesAsSet(Properties propertyFile) {
		return new HashMap(propertyFile);
	}

}
