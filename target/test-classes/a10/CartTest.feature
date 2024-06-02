Feature: AUTOMATION TEST - Cart Testing
  As a user
  I want to be able to do some shopping

  @homePage
  Scenario: Go to cart then continue shopping
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And i go to cart
    And I continue shopping

  @homePage
  Scenario: Go to cart then continue shopping
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add 6 items
    And i go to cart
    And i checkout
    Then i check if i really got that dawg in me


@homePage
  Scenario: Go to cart then checkout with nothing cuz im broke fr fr
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And i go to cart
    Then i check if i really dont got that dawg in me
    


