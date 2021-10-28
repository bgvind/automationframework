package com.cbre.runnerClass;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, tags = {"@testing"},
plugin = { 
		"pretty",
		"json:target/reports/json-report.json" 
		}, 
features = {"src/test/resources/features"}, 
glue = {"com.cbre.stepDefinitions"})
//
public class RunnerClassTest {

}
