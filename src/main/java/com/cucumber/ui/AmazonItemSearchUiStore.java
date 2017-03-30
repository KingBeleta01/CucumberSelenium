package com.cucumber.ui;

import org.openqa.selenium.By;

public class AmazonItemSearchUiStore {

	public static final String AMAZON_URL = "https://www.amazon.com/";
	
	public static final By SEARCH_BOX = By.xpath("//input[@id='twotabsearchtextbox']");
	
	public static final By SEARCH_BUTTON = By.xpath("//input[@value='Go']");
	
	public static final By RESULTS_PAGE = By.xpath("//ul[@id='s-results-list-atf']");
	
	public static final By WELCOME_SIGNIN_COLUMN = By.xpath("//div[@id='gw-sign-in-widget-http-in']");
	
	public static final By CAROULSEL_HOME_PAGE = By.xpath("//div[@id='anonCarousel1']");
	
	public static final By NO_RESULTS_MESSAGE = By.xpath("//h1[@id='noResultsTitle']");
	
	public static final String AMAZON_ITEM = "camera";
	
	public static final String AMAZON_INCOMPLETE_ITEM_NAME = "ca";

	public static final String AMAZON_BLANK_ITEM_NAME = "";
	
	public static final String AMAZON_INVALID_ITEM = "sdfasd1f654615asdfdsfa";
}
