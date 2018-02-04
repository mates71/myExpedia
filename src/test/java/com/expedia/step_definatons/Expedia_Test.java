package com.expedia.step_definatons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.expedia.pages.ExpediaHomePage;

public class Expedia_Test {

	WebDriver driver;
	ExpediaHomePage expediaHomePage;

	@BeforeTest
	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"/Users/musaates/Documents/Libraries/drivers/chromedriver");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().setSize(new Dimension(400, 500));
		driver.get("https://www.expedia.com");
		Thread.sleep(1000);
		driver.get(driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.navigate().to(driver.getCurrentUrl());
		Thread.sleep(1000);
		driver.findElement(By.xpath("//h1[@class='title']")).sendKeys(Keys.F5);

	}

	@Test
	public void expediaTest() throws InterruptedException {
		expediaHomePage = new ExpediaHomePage(driver);

		Thread.sleep(2000);

		expediaHomePage.flights.click();
		expediaHomePage.roundtrip.click();
		expediaHomePage.setOriginCity("Washington,DC");
		expediaHomePage.setDestinationCity("Istanbul,Turkey");

		expediaHomePage.setDeparting("10/31/2017");
		Thread.sleep(2000);
		expediaHomePage.returningFlight.clear();
		expediaHomePage.setReturning("12/30/2017");

		WebElement list = driver.findElement(By.id("flight-adults-hp-flight"));
		Select dropdownList = new Select(list);
		Thread.sleep(2000);
		System.out.println("select by value");
		dropdownList.selectByValue("2");

		WebDriverWait wait = new WebDriverWait(driver, 30);

		WebElement list2 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("flight-children-hp-flight")));
		// driver.findElement(By.id("flight-children-hp-flight"));
		Select dropDownList2 = new Select(list2);
		Thread.sleep(2000);
		System.out.println("select By index");
		dropDownList2.selectByIndex(1);

		WebElement list3 = driver.findElement(By.id("flight-age-select-1-hp-flight"));
		Select dropDownList3 = new Select(list3);
		System.out.println("select By index");
		dropDownList3.selectByIndex(3);

		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		WebElement list4 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='gcw-flights-form-hp-flight']/div[8]/label/button")));

		expediaHomePage.searchButton.click();
	}

	@Test
	public void priceList() {
		List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='dollars price-emphasis']"));

		List<WebElement> compList = driver.findElements(By.xpath("//div[@class='secondary truncate']"));

		for (WebElement prsList1 : priceList) {

			// String subs = prsList1.getText().substring(1, 4);
			int topPrice = Integer.parseInt(prsList1.getText().substring(1, 4).replace(",", ""));

			if (topPrice < 999) {

				for (WebElement compL : compList) {

					System.out.println(topPrice + " " + compL.getText());

				}
			}

		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
