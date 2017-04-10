package com.cucumber.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.LogStatus;

public class WebDriverHelper {

	public WebDriver driver;
	private static final Logger logger = LogManager.getLogger();
	
	public WebDriverHelper(WebDriver webdriver) {
		driver = webdriver;
	}

	Hooks h = new Hooks();

	public void get(String url) {
		driver.get(url);
		
	}
	
	public void sendKeys(By ELEMENT, String KEY) {
		try {
			driver.findElement(ELEMENT).clear();
			driver.findElement(ELEMENT).sendKeys(KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickElement(By element) throws Exception {

		try {
			String expected = "Element was clicked";
			driver.findElement(element).click();
			logger.info(expected);
			h.extentLogScreenshot(LogStatus.INFO, expected);
		} catch (ElementNotFoundException e) {
			String notExpected = "Element was NOT clicked";
			e.printStackTrace();
			logger.error(notExpected);
			h.extentLogScreenshot(LogStatus.FAIL, notExpected);
			
			driver.quit();
		}
	}

	public void verifyElement(By elementPath, Boolean isPresent) throws Exception {
		if (isPresent) {
			String expected = "Element was Verified! " + elementPath;
			String notExpected = "Element Not Found! Element was expected to be displayed! " + elementPath;
			try {
				WebElement element = driver.findElement(elementPath);
				if (element.isDisplayed()) {

					Assert.assertTrue(element.isDisplayed());
					logger.info(expected);
					h.extentLogScreenshot(LogStatus.PASS, expected);
				}
			} catch (ElementNotFoundException e) {
				e.printStackTrace();
				logger.error(notExpected);
				h.extentLogScreenshot(LogStatus.FAIL, notExpected);
				
				driver.quit();
			}
		} else {
			String expected = "Element Verified Not Displayed!";
			String notExpected = "Element was displayed!";
			try {
				WebElement element = driver.findElement(elementPath);
				if (!element.isDisplayed()) {
					Assert.assertTrue(!element.isDisplayed());
					logger.info(expected);
					h.extentLogScreenshot(LogStatus.PASS, expected);
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error(notExpected);
				h.extentLogScreenshot(LogStatus.FAIL, notExpected);
				
				driver.quit();
			}
		}

	}

	public String getElementText(By element) {
		String elementText = "";
		try {
			elementText = driver.findElement(element).getText();
			logger.info(elementText);
			h.extentLog(LogStatus.INFO, "Element text : " + elementText);

		} catch (ElementNotFoundException e) {
			String elementNotFound = "Unable to find Element to getText with";
			e.printStackTrace();
			logger.error(elementNotFound);
			h.extentLog(LogStatus.FAIL, elementNotFound);
			
			driver.quit();
		}

		return elementText;

	}

	public void moveToElement(By elementPath) {
		
		Actions act = new Actions(driver);
		WebElement element = null;
		
		try{ 
			String moveToElementMessage = "Driver was able to moved to element " + elementPath;
			driver.findElement(elementPath);
			act.moveToElement(element).build().perform();
			logger.info(moveToElementMessage);
			h.extentLog(LogStatus.INFO, moveToElementMessage);
		}catch (ElementNotFoundException e) {
			String errorMsg = "Driver was NOT able to moved to element " + elementPath;
			e.printStackTrace();
			logger.error(errorMsg);
			h.extentLog(LogStatus.FAIL, errorMsg);
			
			driver.quit();
		}
	}
		
}

