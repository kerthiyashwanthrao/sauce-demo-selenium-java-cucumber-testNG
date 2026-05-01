Feature: Home page functionality

  Scenario: Verify home page loads successfully
    Given user is logged into the application
    Then home page title should contain "Swag Labs"

  Scenario: Verify all products are displayed
    Given user is on the home page
    Then product list should be visible
    And product count should be greater than 0


