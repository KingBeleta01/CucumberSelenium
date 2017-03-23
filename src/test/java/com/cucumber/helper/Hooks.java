package com.cucumber.helper;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	private static final Logger logger = LogManager.getLogger();
	public static WebDriver driver;

	String extentReportFile = System.getProperty("user.dir") + "/Reports/"
			+ "extentReportFile.html";
	String extentReportImage = System.getProperty("user.dir") + "/Reports/img/";

	public static ExtentReports reports;
	public static ExtentTest extentTest;

	@Before
	/**
	 * Delete all cookies at the start of each scenario to avoid shared state
	 * between tests
	 */
	public String before(Scenario scenario) throws MalformedURLException {
		reports = new ExtentReports(extentReportFile, false);
		extentTest = reports.startTest(scenario.getName().toString());
		logger.info("Called openBrowser for scenario [{}]", scenario.getId());
		System.setProperty("webdriver.chrome.driver",
				"drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		return scenario.getName().toString();
	}

	public void extentLog(LogStatus expectedResult, String log) {
		extentTest.log(expectedResult, log);
	}

	public void extentLogScreenshot(LogStatus expectedResult, String log)
			throws Exception {
		String src = log.replaceAll("[^A-Za-z0-9]", "");
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
				.getScreenSize());
		BufferedImage capture = new Robot().createScreenCapture(screenRect);
		ImageIO.write(capture, "jpg",
				new File(extentReportImage + src + ".jpg"));

		String img = extentTest.addScreenCapture(extentReportImage + src
				+ ".jpg");
		extentTest.log(expectedResult, log, img);
	}

	@After
	/**
	 * Embed a screenshot in test report if test is marked as failed
	 */
	public void after(Scenario scenario) throws Exception {

		try {
			if (!scenario.isFailed()) {
				extentLogScreenshot(LogStatus.PASS, "Done Testing!");
			}
		} catch (WebDriverException wde) {
			logger.error("Error: " + wde.getMessage());
			extentLogScreenshot(LogStatus.FAIL, wde.getMessage());
		} finally {
			if (driver != null) {
				reports.endTest(extentTest);
				reports.flush();
				driver.quit();
			}
		}

	}
}