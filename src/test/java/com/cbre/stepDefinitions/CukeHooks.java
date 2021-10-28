package com.cbre.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import com.cbre.automation.DriverFactory;
import com.cbre.component.PropertiesUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CukeHooks {
	static WebDriver driver = null;

	Properties properties = PropertiesUtil.getInstance();

	@Before
	public void setUp(Scenario scenario) {
		driver = new DriverFactory().createWebDriverInstance(scenario);
	}

	public WebDriver getDriver() {
		return driver;

	}

	@After
	public void tearDown(Scenario scenario) throws IOException {
		if (driver != null) {
			try {

				driver.quit();
				System.out.println("Jarvis automation");

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
		}

	}

}