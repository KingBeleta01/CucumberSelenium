package com.cucumber.helper;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static final Logger logger = LogManager.getLogger();
	public static WebDriver driver;

	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid shared state
	 * between tests
	 */
	public void before(Scenario scenario) throws MalformedURLException {
		logger.info("Called openBrowser for scenario [{}]", scenario.getId());
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void after(Scenario scenario) {
		try {
			if (!scenario.isFailed()) {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		} catch (WebDriverException wde) {
			logger.error("Error: " + wde.getMessage());
		} finally {
			if (driver != null) {
				driver.quit();
			}
		}
	}
}