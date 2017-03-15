@salesforceLogin
Feature: Salesforce Login
Description: As a user, I want to log in to Salesforce so that I can access it.

Background:
Given the user is in log in page.

Scenario: The user did not enter any username or invalid username.
When the user did not enter any username or invalid username.
Then the user unsuccessfully logged in.

Scenario: Invalid user should not be able to log in.
When the user enter invalid password.
Then error message in Invalid Password is displayed.

Scenario: User did not enter any password
When the user did not enter any password.
Then error message in Blank Password is displayed.
