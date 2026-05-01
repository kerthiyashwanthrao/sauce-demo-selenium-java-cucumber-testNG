Feature: Login functionality

  Scenario: Valid login
    Given user opens the login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page

  Scenario: Invalid password
    Given user opens the login page
    When user logs in with username "standard_user" and password "wrongpassword"
    Then error message should contain "Username and password do not match"

  Scenario: Empty username and password
    Given user opens the login page
    When user logs in with username "" and password ""
    Then error message should contain "Username is required"

  Scenario: Locked out user
    Given user opens the login page
    When user logs in with username "locked_out_user" and password "secret_sauce"
    Then error message should contain "Sorry, this user has been locked out."
    
    