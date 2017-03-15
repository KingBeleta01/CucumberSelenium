package com.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature/login/SalesforceLogin.feature", glue = {
		"com.cucumber.stepdefinition.salesforce.login", "com.cucumber.helper" }, plugin = {"pretty"}, tags = {"@salesforceLogin"})

public class SalesforceLoginRunner {

}
