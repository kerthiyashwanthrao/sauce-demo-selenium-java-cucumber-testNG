Feature: Sorting Products

  Scenario: Sort by Price (Low to High)
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user select sorting dropdown
    And choose "Price (high to low)"
    Then products should be sorted by highest price first

  Scenario: Sort by Name
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user select sorting dropdown
    And choose "Name (A to Z)"
    Then products should be sorted alphabetically.
