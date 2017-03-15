package com.cucumber.ui;

import org.openqa.selenium.By;

public class GmailLoginUiStore {

	public static final String GMAIL_URL = "https://mail.google.com/mail/";

	public static final String GMAIL_USERNAME = "thd.dummycustomer@gmail.com";

	public static final String GMAIL_PASSWORD = "andrea123!";

	public static final String INVALID_GMAIL_USERNAME = "jasonpUGE69@gmail.com";

	public static final String INVALID_GMAIL_PASSWORD = "jasonpUGE69xxx";

	public static final By USERNAME_ELEMENT = By.cssSelector("input[id='Email']");

	public static final By NEXT_BUTTON = By.cssSelector("input[id='next']");

	public static final By PASSWORD_ELEMENT = By.cssSelector("input[id='Passwd']");

	public static final By SIGNIN_ELEMENT = By.cssSelector("input[id='signIn']");

	public static final By SIGNIN_ELEMENT_ACCOUNT_ICON = By.cssSelector("a[title*='Google Account:']");

	public static final By SIGNIN_PASSWORD_ERROR_MESSAGE = By.cssSelector("span[id='errormsg_0_Passwd']");

	public static final By SIGNIN_USERNAME_ERROR_MESSAGE = By.cssSelector("span[id='errormsg_0_Email']");
}
