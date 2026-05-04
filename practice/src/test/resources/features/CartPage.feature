Feature: Add to cart

Scenario: Add Product to Cart
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user clicks on add to cart on any product 
    Then cart badge increases by 1
    And button changes to remove
  
Scenario: Add Multiple Products
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user adds 3 products to cart 
    Then cart icon shows 3 items

Scenario: Add Multiple Products
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user clicks on add to cart on any product 
    And clicks remove button 
    Then product should be removed
    And cart badge should be updated 