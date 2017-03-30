package com.cucumber.stepdefinition.amazon.itemsearch;

import org.openqa.selenium.support.PageFactory;

import com.cucumber.helper.Hooks;
import com.cucumber.po.AmazonItemSearchPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;

public class AmazonStepDefinitions implements En{

	private AmazonItemSearchPage amazonItemSearch;
	
	public AmazonStepDefinitions() {
		amazonItemSearch = new AmazonItemSearchPage(Hooks.driver);
		
		Given("^the User is in home page.$", () -> {
			PageFactory.initElements(Hooks.driver, AmazonItemSearchPage.class);
			AmazonItemSearchPage.navigateToAmazon();
		});
		
		When("^the user search for a valid item.$", () -> {
			AmazonItemSearchPage.enterItemInItemSearchBox();
		});
		
		
		Then("^the user should be able to see the results.$", () -> {
			AmazonItemSearchPage.verifyResultsPageIsDisplayed();
		});
		
		When("^the user did not enter an item in search box.$", () -> {
			AmazonItemSearchPage.enterBlankItemNameInSearchBox();
		});
		
		Then("^the user stays in home page.$", () -> {
			AmazonItemSearchPage.verifyHomePage();
		});
		
		When("^the user search for an invalid item.$", () -> {
			AmazonItemSearchPage.enterInvalidItem();
		});
		
		Then("^the results page is not displayed.$", () -> {
			AmazonItemSearchPage.verifyNoItemErrorMessage();
		});
		
	}
	
	
//	@Given("^the User is in home page.$")
//	public void verifyAmazonHomePage() {
//		amazonItemSearch.navigateToAmazon();
//	}
//	

//	
//	@When("^the user search for a valid item.$")
//	public void enterItemInSearchBox() {
//		amazonItemSearch.enterItemInItemSearchBox();
//	}
//	
//	@Then("^the user should be able to see the results.$")
//	public void verifyResultsPageIsDisplayed() {
//		amazonItemSearch.verifyResultsPageIsDisplayed();
//	}
//	
//	@When("^the user did not enter an item in search box.$")
//	public void enterBlankItemNameInSearchBox() {
//		amazonItemSearch.enterBlankItemNameInSearchBox();
//	}
//	
//	@Then("^the user stays in home page.$")
//	public void verifyHomePage() {
//		amazonItemSearch.verifyHomePage();
//	}
//	
////	@When("^the user search for an invalid item.$")
////	public void enterInvalidItem() {
////		amazonItemSearch.enterInvalidItem();
////	}
////	
////	@Then("^the results page is not displayed.$")
////	public void verifyNoItemErrorMessage() {
////		amazonItemSearch.verifyNoItemErrorMessage();
////	}
}
