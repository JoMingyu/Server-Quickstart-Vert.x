package com.planb.support.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	public static String getValue(String attribute) {
		try {
        	Properties props = new Properties();
			props.load(new FileReader(new File("config.properties")));
			
			return props.get(attribute).toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
