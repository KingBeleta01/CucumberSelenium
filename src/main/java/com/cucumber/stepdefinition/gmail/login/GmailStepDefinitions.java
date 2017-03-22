package com.cucumber.stepdefinition.gmail.login;

import com.cucumber.helper.Hooks;
import com.cucumber.po.GmailLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GmailStepDefinitions {
	
	private GmailLoginPage gmailLoginPage;

	public GmailStepDefinitions() {
		gmailLoginPage = new GmailLoginPage(Hooks.driver);
	}
 
	@Given("^the user is in gmail log in page.$")
	public void navigateToGmail() {
		gmailLoginPage.navigateToGmail();
	}

	@When("^the user enter valid gmail credentials.$")
	public void userLogin() throws Exception {
		gmailLoginPage.login();
	}

	@Then("^the user successfully logged in in gmail.$")
	public void verifyLogin() throws Exception {
		gmailLoginPage.verifySuccessfullyLoggedIn();
	}

	@When("^the user enter invalid gmail password.$")
	public void userLoginUsingInvalidUserPassword() throws Exception {
		gmailLoginPage.invalidUserPassword();
	}

	@Then("^error message in gmail password is displayed.$")
	public void verifyUserLoginUsingInvalidUserPassword() throws Exception {
		gmailLoginPage.verifyInvalidPasswordUnsuccessfulLogIn();
	}
	
	@When("^the user enter invalid gmail username.$")
	public void verifyUserLoginUsingInvalidUsername() throws Exception {
		gmailLoginPage.invalidUserName();
	}

	@Then("^error message in gmail username is displayed.$")
	public void verifyUnsuccessfullUserLogin() throws Exception {
		gmailLoginPage.verifyUnsuccessfulUsernameLogIn();
	}
}
