package com.expedia.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin={"html:target/cucumber-reports","json:target/cucumber.json"},
		
		features="./src/test/resources/features",
		glue ="com.expedia.step_definatons",
				
	
		dryRun=false)

public class CukesRunner {

}