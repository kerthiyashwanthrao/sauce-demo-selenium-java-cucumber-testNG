Feature: Checkout Process

  Scenario: Successful Checkout
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user add product to cart
    And go to cart
    And click checkout
    And enter firstname "yashwanth",lastname "kerthi" and zipcode "503001"
    And click continue button
    And click finish
    Then thank you for your order message should be displayed

  Scenario: Validate error message when checkout fields are left blank
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user add product to cart
    And go to cart
    And click checkout
    Given user is on checkout page
    When user leaves fields blank
    And click continue button
    Then error message should be displayed
