Feature: AUTOMATION TEST - End-to-End Testing
  As a user
  I want to be able to do some shopping

  @End-to-End
  Scenario: end-to-end testing
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I click the sauce labs backpack
    And I click the add to cart button
    And I go back to products
    And i go to cart
    And i checkout
    When I enter my firstname "Hanri" and lastname "Fajar" and zipcode "41151"
    And i continued
    And i finished the transaction
    Then i should be finished