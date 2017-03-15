package com.cucumber.po;

import org.openqa.selenium.WebDriver;

import com.cucumber.helper.WebDriverHelper;
import com.cucumber.ui.GmailLoginUiStore;

public class GmailLoginPage {

	private WebDriverHelper wd;

	public GmailLoginPage(WebDriver webdriver) {
		wd = new WebDriverHelper(webdriver);
	}

	public void navigateToGmail() {
		wd.getUrl(GmailLoginUiStore.GMAIL_URL);
	}

/*	@FindBy(css = "input[id='Email']")
	public WebElement USERNAME_ELEMENT;*/

	public void login() {
		wd.sendKeys(GmailLoginUiStore.USERNAME_ELEMENT, GmailLoginUiStore.GMAIL_USERNAME);
		wd.clickElement(GmailLoginUiStore.NEXT_BUTTON);
		wd.sendKeys(GmailLoginUiStore.PASSWORD_ELEMENT, GmailLoginUiStore.GMAIL_PASSWORD);
		wd.clickElement(GmailLoginUiStore.SIGNIN_ELEMENT);
	}

	public void invalidUserPassword() {
		wd.sendKeys(GmailLoginUiStore.USERNAME_ELEMENT, GmailLoginUiStore.GMAIL_USERNAME);
		wd.clickElement(GmailLoginUiStore.NEXT_BUTTON);
		wd.sendKeys(GmailLoginUiStore.PASSWORD_ELEMENT, GmailLoginUiStore.INVALID_GMAIL_PASSWORD);
		wd.clickElement(GmailLoginUiStore.SIGNIN_ELEMENT);
	}

	public void verifySuccessfullyLoggedIn() {
		wd.verifyElement(GmailLoginUiStore.SIGNIN_ELEMENT_ACCOUNT_ICON, true);

	}

	public void verifyInvalidPasswordUnsuccessfulLogIn() {
		wd.verifyElement(GmailLoginUiStore.SIGNIN_PASSWORD_ERROR_MESSAGE, true);

	}

	public void verifyUnsuccessfulUsernameLogIn() {
		wd.verifyElement(GmailLoginUiStore.SIGNIN_USERNAME_ERROR_MESSAGE, true);

	}

	public void invalidUserName() {
		wd.sendKeys(GmailLoginUiStore.USERNAME_ELEMENT, GmailLoginUiStore.INVALID_GMAIL_USERNAME);
		wd.clickElement(GmailLoginUiStore.NEXT_BUTTON);
	}
}
