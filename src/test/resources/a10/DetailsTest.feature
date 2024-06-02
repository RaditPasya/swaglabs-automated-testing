Feature: AUTOMATION TEST - Details Testing
  As a user
  I want to be able to do some shopping

  @homePage
  Scenario: Verifikasi tahapan menampilkan rincian produk, menambahkannya ke dalam keranjang
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I click the backpack photo
    And I click the add to cart button
    Then I look at the badge after backpack


    @homePage
    Scenario: Verifikasi tahapan menampilkan rincian produk,menambahkannya ke dalam keranjang ,and go back
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I click the backpack photo
    And I click the add to cart button
    And I go back to products
    Then I look at the badge after backpack

    @homePage
    Scenario: Verifikasi tahapan menampilkan rincian produk,menambahkannya ke dalam keranjang, menghapus dari keranjang ,and go back
    Given I am on the login page
    When I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I click the backpack photo
    And I click the add to cart button
    And i remove it dawg
    And I go back to products
    Then the badge is gone SIKE


