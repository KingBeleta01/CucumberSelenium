package com.cucumber.ui;

import org.openqa.selenium.By;

public class SalesforceLoginUiStore {

	public static final String SALESFORCE_URL = "https://test.salesforce.com/";

	public static final String SALESFORCE_USERNAME = "thd.dummycustomer@SALESFORCE.com";

	public static final String SALESFORCE_PASSWORD = "andrea123!";

	public static final String INVALID_SALESFORCE_USERNAME = "jasonpUGE69@SALESFORCE.com";

	public static final String INVALID_SALESFORCE_PASSWORD = "jasonpUGE69xxx";

	public static final By USERNAME_ELEMENT = By.cssSelector("input[id='username']");

	public static final By LOGIN_TO_SANDBOX_BUTTON = By.cssSelector("input[id='Login']");

	public static final By PASSWORD_ELEMENT = By.cssSelector("input[id='password']");
	
	public static final By SIGNIN_PASSWORD_ERROR_MESSAGE = By.cssSelector("div[id='error']");
	
}