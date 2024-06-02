Feature: AUTOMATION TEST - User Logout
  As a user
  I want to be able to logout of my account
  So that I can do something else

  @raditTest
  Scenario: [T0.1.1] Positive logout
    Given the user is logged in and on the dashboard page with "standard_user" username and "secret_sauce" password
    When they press the logout button
    Then they should be navigated back to the login page
