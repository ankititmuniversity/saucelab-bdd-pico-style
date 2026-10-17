@OrderConfirmation
Feature: Order confirmation functionality
  As a user
  I want to see confirmation after purchase
  So that I know my order is complete

  Background:
  Given User is on the login page
  When User enters username "standard_user" and password "secret_sauce"
  And User clicks on the login button
  Then User should be logged in successfully
  When User views the product "Sauce Labs Backpack"
  And User clicks on Add to Cart
  And The cart icon should show the product
  Given User has added "Sauce Labs Backpack" to the cart
  When User opens the cart
  Then The cart page title should be "Your Cart"
  And The cart should display "Sauce Labs Backpack"
  Given User has added "Sauce Labs Backpack" to the cart
  When User opens the cart
  And User clicks on Checkout
  Then User should be navigated to the Checkout page
  Then The Checkout page title should be "Checkout: Your Information"
  When User enters first name "John"
  And User enters last name "Doe"
  And User enters postal code "12345"
  And User clicks Continue
  Then User should be navigated to the Payment page
  Then The Payment page title should be "Checkout: Overview"
  And User should see payment info
  And User should see shipping info
  And User should see subtotal and total
  When User clicks Finish
  Then User should be navigated to the Order Confirmation page


  Scenario: Validate order confirmation
    Then The Order Confirmation page title should be "Checkout: Complete!"
    And User should see "Thank you for your order!" message
    When User clicks Back to Home
    Then User should be navigated back to the Products page
