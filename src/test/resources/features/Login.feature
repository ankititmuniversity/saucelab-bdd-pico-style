@Login
Feature: Login functionality
  As a user
  I want to log into SauceDemo
  So that I can access the product inventory

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "standard_user" and password "secret_sauce"
    And User clicks on the login button
    Then User should be logged in successfully

  Scenario: Unsuccessful login with invalid credentials
    Given User is on the login page
    When User enters username "wrong_user" and password "wrong_pass"
    And User clicks on the login button
    Then User should see an error message
