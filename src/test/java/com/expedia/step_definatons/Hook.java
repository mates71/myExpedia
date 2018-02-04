package com.expedia.step_definatons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.expedia.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
WebDriver driver;
	@Before
	public void setUp(){
		Driver.getInstance().manage().window().maximize();
		Driver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	
	
	
	@After
	public void tearDown(Scenario scenario){
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) 
					Driver.getInstance()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		//Driver.closeDriver();
	}

		
	}

