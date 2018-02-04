package com.expedia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utilities.Driver;

public class HomePage {

	

	public HomePage() {
		PageFactory.initElements(Driver.getInstance(),this);
		
	}
	
	@FindBy(id="tab-flight-tab-hp")
	public WebElement flightTab;
	
	@FindBy(id="flight-origin-hp-flight")
	public WebElement flightFrom;
	
	@FindBy(id="flight-destination-hp-flight")
	public WebElement flightTo;
	
	@FindBy(id="flight-departing-hp-flight")
	public WebElement departDate;
	
	@FindBy(id="flight-returning-hp-flight")
	public WebElement returnDate;
	
	@FindBy(id="flight-adults-hp-flight")
	public WebElement selectAdault;
	
	@FindBy(id="flight-children-hp-flight")
	public WebElement selectChild;
	
	@FindBy(id="flight-age-select-1-hp-flight")
	public WebElement selectChildAge;
	
	@FindBy(id="flight-age-select-2-hp-flight")
	public WebElement selectChildAge2;
	
	@FindBy(id="flight-children-in-seat-hp-flight")
	public WebElement inSitRadio;
	
	
	
	@FindBy(id="search-button-hp-package")
	public WebElement searchBtn;
	

	
	
	
	
	
	
	
	
	
	

}
