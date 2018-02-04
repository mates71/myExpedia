package com.expedia.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpediaHomePage {
	private WebDriver driver;

	public ExpediaHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//div[@id='DEFAULT-NT-content-slider']")
	public WebElement headers;

	@FindBy(xpath = ".//*[@id='tab-flight-tab-hp']")
	public WebElement flights;

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	public WebElement roundtrip;

	@FindBy(id = "flight-origin-hp-flight")
	public WebElement originFlight;

	@FindBy(id = "flight-destination-hp-flight")
	public WebElement destinationFlight;

	@FindBy(id = "flight-departing-hp-flight")
	public WebElement departingFlight;

	@FindBy(id = "flight-returning-hp-flight")
	public WebElement returningFlight;

	@FindBy(id = "flight-adults-hp-flight")
	public WebElement selectAdults;
	

	@FindBy(id = "flight-children-hp-flight")
	public WebElement selectChildren;

	@FindBy(xpath =".//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")
	public WebElement searchButton;

	public void setOriginCity(String origin) {
		originFlight.sendKeys(origin);

	}

	public void setDestinationCity(String destination) {

		destinationFlight.sendKeys(destination);

	}

	public void setDeparting(String depDate) {
		departingFlight.sendKeys(depDate);

	}

	public void setReturning(String retrnDate) {
		returningFlight.sendKeys(retrnDate);

	}
	
}
