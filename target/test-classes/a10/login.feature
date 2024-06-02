Feature: AUTOMATION TEST - User Login
  As a user
  I want to be able to login to my account
  So that I can access my personalized content

  @raditTest
  Scenario: [T0.0.1] Login successful with valid credentials
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully and view the menu

  @hanriTest
  Scenario: [T0.0.3] Login with wrong password
    Given I am on the login page
    When I enter my username "standard_user" and password "wrongpass"
    And I click the login button
    Then I should see a message saying "Username and password do not match any user in this service!"

    @hanriTest
  Scenario: [T0.0.2] Login with wrong username
    Given I am on the login page
    When I enter my username "ganteng2_bau" and password "wrongpass"
    And I click the login button
    Then I should see a message saying "Username and password do not match any user in this service!"

    @hanriTest
  Scenario: [T0.0.4] Login with no password
    Given I am on the login page
    When I enter my username "standard_user" and password ""
    And I click the login button
    Then I should see a message saying "You need Password !"

    @hanriTest
  Scenario: [T0.0.5] Login with no username
    Given I am on the login page
    When I enter my username "" and password "wrongpass"
    And I click the login button
    Then I should see a message saying "You need Username !"

    @hanriTest
  Scenario: [T0.0.6] Login with nothing cuz im a dumbass
    Given I am on the login page
    When I enter my username "" and password ""
    And I click the login button
    Then I should see a message saying "You need Username & Password !"
