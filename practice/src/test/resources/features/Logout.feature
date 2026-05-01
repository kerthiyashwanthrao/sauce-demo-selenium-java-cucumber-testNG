Feature: Logout

    Scenario: Logout Functionality
    Given user is on login page
    When user logs in with username "standard_user" and password "secret_sauce"
    Then user should be redirected to inventory page
    When user clicks menu button 
    And clicks logout button
    Then user should be directed to login page