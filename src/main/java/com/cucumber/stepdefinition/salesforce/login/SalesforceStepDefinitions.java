package com.cucumber.stepdefinition.salesforce.login;

import com.cucumber.helper.Hooks;
import com.cucumber.po.SalesforceLoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SalesforceStepDefinitions {

	private SalesforceLoginPage sfLoginPage;

	public SalesforceStepDefinitions() {
		sfLoginPage = new SalesforceLoginPage(Hooks.driver);
	}

	@Given("^the user is in log in page.$")
	public void verifySalesforceLoginPage() {
		sfLoginPage.navigateToSalesforce();
	}

	@When("^the user did not enter any username or invalid username.$")
	public void loginWithBlankUsername() throws Exception {
		sfLoginPage.loginWithBlankUsername();
	}

	@Then("^the user unsuccessfully logged in.$")
	public void verifyUserStaysInLoginPage() throws Exception {
		sfLoginPage.verifyLoginPage();
	}

	@When("^the user enter invalid password.$")
	public void loginToSalesforce() throws Exception {
		sfLoginPage.login();
	}

	@Then("^error message in Invalid Password is displayed.$")
	public void verifyInvalidPasswordErrorMessage() throws Exception {
		sfLoginPage.verifyInvalidPasswordErrorMessage();
	}

	@When("^the user did not enter any password.$")
	public void loginToSalesforceWithBlankPassword() throws Exception {
		sfLoginPage.loginWithBlankPassword();
	}

	@Then("^error message in Blank Password is displayed.$")
	public void verifyBlankPasswordErrorMessage() throws Exception {
		sfLoginPage.verifyBlankPasswordErrorMessage();
	}

}
