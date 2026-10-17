@Cart
Feature: Cart functionality
  As a user
  I want to manage items in my cart
  So that I can checkout or continue shopping

  Background:
  Given User is on the login page
  When User enters username "standard_user" and password "secret_sauce"
  And User clicks on the login button
  Then User should be logged in successfully
  When User views the product "Sauce Labs Backpack"
  And User clicks on Add to Cart
  And The cart icon should show the product
  
  Scenario: Validate cart contents
    Given User has added "Sauce Labs Backpack" to the cart
    When User opens the cart
    Then The cart page title should be "Your Cart"
    And The cart should display "Sauce Labs Backpack"

  Scenario: Proceed to checkout
    Given User has added "Sauce Labs Backpack" to the cart
    When User opens the cart
    And User clicks on Checkout
    Then User should be navigated to the Checkout page
