Feature: AUTOMATION TEST - Checkout Testing
  As a user
  I want to be able to do some shopping

  @homePage
  Scenario: Go to cart then continue shopping
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And i go to cart
    And i checkout
    When I enter my firstname "123123" and lastname "Fajar" and zipcode "41151"
    Then the button should be grey and error message "Invalid First Name" shows up

  @homePage
  Scenario: Go to cart then continue shopping
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And i go to cart
    And i checkout
    When I enter my firstname "" and lastname "Fajar" and zipcode "41151"
    Then shows up error message "Error: First Name is required"


 @homePage
  Scenario: Go to cart then continue shopping
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And i go to cart
    And i checkout
    When I enter my firstname "Hanri" and lastname "Fajar" and zipcode "Bandung50"
    Then the button should be grey and error message "Invalid Zip Code" shows up
    


