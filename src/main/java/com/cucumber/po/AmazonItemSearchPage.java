package com.cucumber.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.helper.Hooks;
import com.cucumber.helper.WebDriverHelper;
import com.cucumber.ui.AmazonItemSearchUiStore;
import com.cucumber.ui.SalesforceLoginUiStore;

public class AmazonItemSearchPage {

	
	private static WebDriverHelper wd;

	public AmazonItemSearchPage(WebDriver webdriver) {
//		PageFactory.initElements(Hooks.driver, AmazonItemSearchPage.class);
		wd = new WebDriverHelper(webdriver);
	}

	
	public static void navigateToAmazon() throws Exception {
		PageFactory.initElements(Hooks.driver, AmazonItemSearchPage.class);
		wd.get(AmazonItemSearchUiStore.AMAZON_URL);
	}

	public static void enterItemInItemSearchBox() throws Exception {
		wd.sendKeys(AmazonItemSearchUiStore.SEARCH_BOX, AmazonItemSearchUiStore.AMAZON_ITEM);
		wd.clickElement(AmazonItemSearchUiStore.SEARCH_BUTTON);
	}
	
	public static void verifyResultsPageIsDisplayed() throws Exception {
		wd.verifyElement(AmazonItemSearchUiStore.RESULTS_PAGE, true);
	}
	
	public static void enterIncompleteItemNameInSearchBox() throws Exception {
		wd.sendKeys(AmazonItemSearchUiStore.SEARCH_BOX, AmazonItemSearchUiStore.AMAZON_INCOMPLETE_ITEM_NAME);
		wd.clickElement(AmazonItemSearchUiStore.SEARCH_BUTTON);
	}
	
	public static void enterBlankItemNameInSearchBox() throws Exception {
		wd.sendKeys(AmazonItemSearchUiStore.SEARCH_BOX, AmazonItemSearchUiStore.AMAZON_BLANK_ITEM_NAME);
		wd.clickElement(AmazonItemSearchUiStore.SEARCH_BUTTON);
	}
	
	public static void verifyHomePage() throws Exception {
		wd.verifyElement(AmazonItemSearchUiStore.CAROULSEL_HOME_PAGE, true);
	}
	
	public static void enterInvalidItem() throws Exception {
		wd.sendKeys(AmazonItemSearchUiStore.SEARCH_BOX, AmazonItemSearchUiStore.AMAZON_INVALID_ITEM);
		wd.clickElement(AmazonItemSearchUiStore.SEARCH_BUTTON);
	}
	
	public static void verifyNoItemErrorMessage() throws Exception {
		wd.verifyElement(AmazonItemSearchUiStore.NO_RESULTS_MESSAGE, true);
	}
	
	public static void sample1234() {
		
	}
	
}
