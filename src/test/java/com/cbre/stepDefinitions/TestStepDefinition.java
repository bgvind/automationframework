package com.cbre.stepDefinitions;

import static io.restassured.RestAssured.given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.paulhammant.ngwebdriver.NgWebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestStepDefinition {
	WebDriver driver;
	JavascriptExecutor jsDriver;
	NgWebDriver ngDriver;


}