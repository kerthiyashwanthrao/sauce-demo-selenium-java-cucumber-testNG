Feature: Product page 

Scenario: Verify Products Display
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    And all products should be displayed 
    And each product should have image
    And each product should have name
    And each product should have description 
    And each product should have price 

    Scenario: Verify Product Details Page
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user clicks on product name 
    Then product detail page should open 
    And product information should be displayed
    