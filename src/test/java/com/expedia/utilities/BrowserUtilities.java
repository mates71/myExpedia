package com.expedia.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {

	public static void waitForPageLoad(){
		
		WebDriverWait wait=new WebDriverWait(Driver.getInstance(), 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.se-pre-con")));
	try {
		Thread.sleep(1000);
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();  // never delete this line,if you delete you never know where propl
	}
	}
	public static void switchTabs(String url){
		String defaultTab=Driver.getInstance().getWindowHandle();
		for(String windowHandle:Driver.getInstance().getWindowHandles()){
			Driver.getInstance().switchTo().window(windowHandle);
			if(Driver.getInstance().getCurrentUrl().contains(url)){
				return;
			}
		}
		Driver.getInstance().switchTo().window(defaultTab);
	}
}
