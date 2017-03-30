@amazonitemsearch
Feature: Amazon Item Search
Description: As a user, I should be able to search an item in the search box.

Background:
Given the User is in home page.

Scenario: The user should be able to see the results when a valid item is searched.
When the user search for a valid item.
Then the user should be able to see the results.

Scenario: The user stays in home page when the user did not enter an item in search box.
When the user did not enter an item in search box.
Then the user stays in home page.
#Scenario: Suggested items is displayed when the user tries to search for an item.
#When the user is searching for "ca" item.
#Then the suggested items is displayed.


Scenario: Results page is not displayed if item is not valid.
When the user search for an invalid item.
Then the results page is not displayed.

