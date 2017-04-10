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
			try {
				AmazonItemSearchPage.navigateToAmazon();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		When("^the user search for a valid item.$", () -> {
			try {
				AmazonItemSearchPage.enterItemInItemSearchBox();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
		Then("^the user should be able to see the results.$", () -> {
			try {
				AmazonItemSearchPage.verifyResultsPageIsDisplayed();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		When("^the user did not enter an item in search box.$", () -> {
			try {
				AmazonItemSearchPage.enterBlankItemNameInSearchBox();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Then("^the user stays in home page.$", () -> {
			try {
				AmazonItemSearchPage.verifyHomePage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		When("^the user search for an invalid item.$", () -> {
			try {
				AmazonItemSearchPage.enterInvalidItem();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Then("^the results page is not displayed.$", () -> {
			try {
				AmazonItemSearchPage.verifyNoItemErrorMessage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
