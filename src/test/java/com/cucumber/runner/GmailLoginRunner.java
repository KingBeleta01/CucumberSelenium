package com.cucumber.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:feature/login/GmailLogin.feature", glue = {
		"com.cucumber.stepdefinition.gmail.login", "com.cucumber.helper" }, plugin = { "pretty" }, tags = { "@gmailLogin" })
public class GmailLoginRunner {
	public void invokeCucumberMain() {
		CucumberMain cm = new CucumberMain();
		cm.cucumberMain();
	}
}
