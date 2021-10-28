package com.cbre.driver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cbre.component.PropertiesUtil;

/**
 * @author Bharathi
 *
 */
public class DriverInitializer {

	private static Properties properties = PropertiesUtil.getInstance();
	private WebDriver driver;

	static {
		try {

			String path = System.getProperty("user.dir");
			if (properties.getProperty("DefaultPlatform").equalsIgnoreCase("Windows")) {

				System.setProperty("webdriver.chrome.driver",
						path + properties.getProperty("codeTest.automation.ChromeDriverPath.windows"));
			} else {
				System.setProperty("webdriver.chrome.driver",
						path + properties.getProperty("codeTest.automation.ChromeDriverPath.mac"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  WebDriver getWebDriver(String browser) {

		if (driver == null) {
			invoke(browser);
		}
		return driver;
	}

	private  void invoke(String browser) {
		switch (getProperty("browser")) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
		}
		setWebDriver(driver);
	}

	
	private static void setWebDriver(WebDriver driver) {
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}
	}

	public static String getProperty(String key) {
		return properties == null ? null : properties.getProperty(key, "");
	}
}
