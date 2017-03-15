@gmailLogin
Feature: Gmail Login

Description: As a user, I want to log in to my Gmail account so that I can access my Gmail account.

Background:
Given the user is in gmail log in page.

Scenario: Valid user should be able to log in successfully.
When the user enter valid gmail credentials.
Then the user successfully logged in in gmail.

Scenario: Invalid user should not be able to log in.
When the user enter invalid password.
Then error message in gmail password is displayed.

Scenario: User did not enter any username
When the user enter invalid gmail username.
Then error message in gmail username is displayed.
