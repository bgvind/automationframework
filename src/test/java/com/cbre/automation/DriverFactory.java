
package com.cbre.automation;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.cbre.component.PropertiesUtil;
import com.cbre.driver.DriverInitializer;

import cucumber.api.Scenario;

public class DriverFactory {

	private static Properties property = PropertiesUtil.getInstance();

	public WebDriver createWebDriverInstance(Scenario scenario) {
		WebDriver driver = null;
		try {
			switch (property.getProperty("Execution")) {

			case "LOCAL":
				if (property.getProperty("ExecutionMode").equalsIgnoreCase("UI")) {
					driver = new DriverInitializer().getWebDriver(property.getProperty("Browser"));
				}

				break;

			default:
				throw new Exception("Unhandled Execution Mode!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		}
		return driver;
	}

}
