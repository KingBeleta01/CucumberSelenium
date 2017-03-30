package com.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature/login/AmazonItemSearch.feature", glue = {
		"com.cucumber.stepdefinition.amazon.itemsearch", "com.cucumber.helper" }, plugin = {"pretty"}, tags = {"@amazonitemsearch"})


public class AmazonItemSearchRunner {

}
