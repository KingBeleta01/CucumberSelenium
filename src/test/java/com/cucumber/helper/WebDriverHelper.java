package com.cucumber.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class WebDriverHelper {

	public WebDriver driver;
	private static final Logger logger = LogManager.getLogger();

	public WebDriverHelper(WebDriver webdriver) {
		driver = webdriver;
	}

	public void getUrl(String URL) {
		driver.get(URL);
	}

	public void sendKeys(By ELEMENT, String KEY) {
		try {
			driver.findElement(ELEMENT).clear();
			driver.findElement(ELEMENT).sendKeys(KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickElement(By ELEMENT) {
		driver.findElement(ELEMENT).click();
	}

	public void verifyElement(By ELEMENT, boolean ISPRESENT) {
		if (ISPRESENT) {
			try {
				WebElement element = driver.findElement(ELEMENT);
				if (element.isDisplayed()) {
					Assert.assertTrue(element.isDisplayed());
					logger.error("Element Verified!");
				}
			} catch (ElementNotFoundException e) {
				e.printStackTrace();
				logger.error("Element Not Found!");
				driver.quit();
			}
		} else {
			try {
				WebElement element = driver.findElement(ELEMENT);
				if (!element.isDisplayed()) {
					Assert.assertTrue(!element.isDisplayed());
					logger.info("Element Verified Not Displayed!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Element Was Displayed!");
				driver.quit();
			}
		}

	}
	
	public String getElementText(By element){
		String elementText = driver.findElement(element).getText();
		logger.info(elementText);
		return elementText;
		
	}
	
	public void moveToElement(By element){
		Actions act = new Actions(driver);
        WebElement mainMenu = driver.findElement(element);
        act.moveToElement(mainMenu).build().perform();
	}
	
	
}
