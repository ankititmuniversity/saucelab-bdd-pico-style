@Product
Feature: Product page functionality
  As a user
  I want to view products
  So that I can add them to my cart

 Background:
  Given User is on the login page
  When User enters username "standard_user" and password "secret_sauce"
  And User clicks on the login button
  Then User should be logged in successfully


  Scenario: View and add product to cart
    Then The Products page title should be "Products"
    When User views the product "Sauce Labs Backpack"
    And User clicks on Add to Cart
    Then The cart icon should show the product
