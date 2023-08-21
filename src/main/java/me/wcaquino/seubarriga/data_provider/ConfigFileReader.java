package me.wcaquino.seubarriga.data_provider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "src\\\\main\\\\resources\\\\configs\\\\Config.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public Long getMaxWaitTime() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 5l;
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
		}
	}

	public Integer getPort() {
		String port = properties.getProperty("port");
		if (port != null) {
			return Integer.parseInt(port);
		} else {
			throw new RuntimeException(" port not specified in the Configuration.properties file for the Key:port");
		}
	}

	public String getContentType() {
		String contentType = properties.getProperty("contentType");

		if (contentType != null) {
			return contentType;
		} else {
			throw new RuntimeException(
					" contentType not specified in the Configuration.properties file for the Key:contentType");
		}
	}

	public String getBasePath() {
		String basePath = properties.getProperty("basePath");
		return basePath;
	}

}
