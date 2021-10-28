package com.cbre.component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.log4testng.Logger;

public class PropertiesUtil {
	private static Properties properties = getFromPropertiesFile();
	static Logger log = Logger.getLogger(PropertiesUtil.class);

	private PropertiesUtil() {
		// To prevent external instantiation of this class
	}

	public static Properties getInstance() {
		return properties;
	}

	private static Properties getFromPropertiesFile() {
		Properties properties = new Properties();
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		String appRelativePath=relativePath+getFileSeparator() + "src" + getFileSeparator() + "main" + getFileSeparator()
		+ "resources";
		relativePath = relativePath + getFileSeparator() + "src" + getFileSeparator() + "test" + getFileSeparator()
				+ "resources"+ getFileSeparator()+"config";
		try {
			properties.load(new FileInputStream(relativePath + getFileSeparator() + "config.properties"));
			properties.load(new FileInputStream(appRelativePath + getFileSeparator() + "application.properties"));
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

		return properties;
	}

	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}

	public static String getAbsolutePath() {
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		return relativePath;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}