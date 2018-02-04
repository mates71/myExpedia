package com.expedia.step_definatons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.pages.HomePage;
import com.expedia.utilities.ConfigurationReader;
import com.expedia.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ExpediaStepDefination {
	WebDriver driver;
	HomePage homePage = new HomePage();

	@Given("^the use on expedia home page$")
	public void the_use_on_expedia_home_page() throws Throwable {

		Driver.getInstance().get(ConfigurationReader.getProperty("url"));

	}

	@When("^user clict the flight button$")
	public void user_clict_the_flight_button() throws Throwable {

		homePage.flightTab.click();

	}

	@Then("^user should be fill out flight origne and destination field$")
	public void user_should_be_fill_out_flight_origne_and_destination_field() throws Throwable {
		homePage.flightFrom.sendKeys("Washington,DC");
		homePage.flightTo.sendKeys("Istanbul, Turkey");

	}

	@Then("^user also chose departing and returning date$")
	public void user_also_chose_departing_and_returning_date() throws Throwable {
		homePage.departDate.sendKeys("10/30/2017");
		homePage.returnDate.clear();
		homePage.returnDate.sendKeys("10/25/2017");

	}

	@Then("^user should chose Adault count$")
	public void user_should_chose_Adault_count() throws Throwable {
		Thread.sleep(3000);
		// WebElement selAdalt =
		// driver.findElement(By.id("flight-adults-hp-flight"));
		Select selectAdlt = new Select(homePage.selectAdault);
		selectAdlt.selectByValue("3");

	}

	@Then("^user should be define children count and ages$")
	public void user_should_be_define_children_count_and_ages() throws Throwable {
		Thread.sleep(3000);
		Select selChild = new Select(homePage.selectChild);
		selChild.selectByValue("2");

		Select selage1 = new Select(homePage.selectChildAge);
		selage1.selectByValue("7");

		Select selAge2 = new Select(homePage.selectChildAge2);
		selAge2.selectByValue("1");
		
		homePage.inSitRadio.click();

	}

	@Then("^user should be clict search button$")
	public void user_should_be_clict_search_button() throws Throwable {
		Actions actions2=new Actions(driver);
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
	    jsx.executeScript("window.scrollBy(0,2500)", ""); //scroll down, value 4500 you can change as per your req
	    Thread.sleep(2000);
		//jsx.executeScript("window.scrollBy(450,0)", ""); //scroll up
	    
	    Thread.sleep(4000);
		WebElement btn = driver.findElement(By.id("search-button-hp-package"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(btn));
		actions2.moveToElement(btn).perform();
		//btn.click();
		//homePage.searchBtn.click();
		driver.findElement(By.id("search-button-hp-package")).click();

	}

}
