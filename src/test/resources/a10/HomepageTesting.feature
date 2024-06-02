Feature: AUTOMATION TEST - HomePage Testing
  As a user
  I want to be able to do some shopping

  @homePage
  Scenario: Menambah 6 produk
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add 6 items
    Then I look at the badge

@homePage
  Scenario: menghapus 6 produk
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I add 6 items
    And I remove all items
    Then the badge is gone

@homePage
Scenario: menghapus 6 produk
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I sorted it
    And i checked the sort
