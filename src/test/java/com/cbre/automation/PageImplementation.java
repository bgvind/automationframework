package com.cbre.automation;

import static io.restassured.RestAssured.given;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.cbre.stepDefinitions.CukeHooks;
import com.paulhammant.ngwebdriver.NgWebDriver;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public abstract class PageImplementation {

	public NgWebDriver ngDriver;
	public WebDriver driver;

	public PageImplementation(WebDriver driver) {
		this.driver = new CukeHooks().getDriver();
	}

	public PageImplementation(WebDriver driver, NgWebDriver ngDriver, JavascriptExecutor jsDriver) {
		this.driver = new CukeHooks().getDriver();
		jsDriver = (JavascriptExecutor) this.driver;
		this.ngDriver = new NgWebDriver(jsDriver);
	}
	

}
