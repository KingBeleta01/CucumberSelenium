package com.cucumber.po;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.helper.WebDriverHelper;
import com.cucumber.ui.SalesforceLoginUiStore;

public class SalesforceLoginPage {

	private WebDriverHelper wd;

	public SalesforceLoginPage(WebDriver webdriver) {
		wd = new WebDriverHelper(webdriver);
	}

	public void navigateToSalesforce() {
		wd.get(SalesforceLoginUiStore.SALESFORCE_URL);
	}

	public void login() throws Exception {
		wd.sendKeys(SalesforceLoginUiStore.USERNAME_ELEMENT,
				SalesforceLoginUiStore.SALESFORCE_USERNAME);
		wd.sendKeys(SalesforceLoginUiStore.PASSWORD_ELEMENT,
				SalesforceLoginUiStore.SALESFORCE_PASSWORD);
		wd.clickElement(SalesforceLoginUiStore.LOGIN_TO_SANDBOX_BUTTON);
	}

	public void loginWithBlankUsername() throws Exception {
		wd.sendKeys(SalesforceLoginUiStore.USERNAME_ELEMENT, "");
		wd.sendKeys(SalesforceLoginUiStore.PASSWORD_ELEMENT,
				SalesforceLoginUiStore.SALESFORCE_PASSWORD);
		wd.clickElement(SalesforceLoginUiStore.LOGIN_TO_SANDBOX_BUTTON);
	}

	public void loginWithBlankPassword() throws Exception {
		wd.sendKeys(SalesforceLoginUiStore.USERNAME_ELEMENT,
				SalesforceLoginUiStore.SALESFORCE_USERNAME);
		wd.sendKeys(SalesforceLoginUiStore.PASSWORD_ELEMENT, "");
		wd.clickElement(SalesforceLoginUiStore.LOGIN_TO_SANDBOX_BUTTON);
	}

	public void verifyInvalidPasswordErrorMessage() throws Exception {
		String expectedErrorMessage = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		wd.verifyElement(SalesforceLoginUiStore.SIGNIN_PASSWORD_ERROR_MESSAGE,
				true);
		String errorMessage = wd
				.getElementText(SalesforceLoginUiStore.SIGNIN_PASSWORD_ERROR_MESSAGE);
		if (errorMessage.equalsIgnoreCase(expectedErrorMessage)) {
			Assert.assertTrue(errorMessage, true);
		} else {
			Assert.assertFalse(errorMessage, false);
		}
	}

	public void verifyBlankPasswordErrorMessage() throws Exception {
		String expectedErrorMessage = "Please enter your password.";
		wd.verifyElement(SalesforceLoginUiStore.SIGNIN_PASSWORD_ERROR_MESSAGE,
				true);
		String errorMessage = wd
				.getElementText(SalesforceLoginUiStore.SIGNIN_PASSWORD_ERROR_MESSAGE);
		if (errorMessage.equalsIgnoreCase(expectedErrorMessage)) {
			Assert.assertTrue(errorMessage, true);
		} else {
			Assert.assertFalse(errorMessage, false);
		}
	}

	public void verifyLoginPage() throws Exception {
		wd.verifyElement(SalesforceLoginUiStore.USERNAME_ELEMENT, true);

	}
}
