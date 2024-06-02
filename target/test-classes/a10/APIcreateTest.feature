Feature: API TEST - CREATE

  Scenario: [TC 1] Missing APP_ID header
    Given the request body is
      """
      {
        "firstName" : "Azis",
        "lastName" : "Suro",
        "email": "azis@examples.com"
      }
      """
    When I make a POST request to "user/create"
    Then the status code should be 403
    And the response should contain "error" with value "APP_ID_MISSING"

  Scenario: [TC 2] Invalid APP_ID header
    Given the request body is
      """
      {
        "firstName" : "Azis",
        "lastName" : "Suro",
        "email": "azis@examples.com"
      }
      """
    And the header "app-id" is "663679b53fb5f584f811"
    When I make a POST request to "user/create"
    Then the status code should be 403
    And the response should contain "error" with value "APP_ID_NOT_EXIST"

  Scenario: [TC 3] Valid request with correct APP_ID
    Given the request body with random email is
      """
      {
        "firstName" : "Azis",
        "lastName" : "Suro",
        "email": "{randomEmail}"
      }
      """
    And the header "app-id" is "66367c7b3ec826592a67a062"
    When I make a POST request to "user/create"
    Then the status code should be 200
    And the response should contain "firstName" with value "Azis"
    And the response should contain "lastName" with value "Suro"

  Scenario: [TC 14] Missing firstName in request body
    Given the request body is
      """
      {
        "firstName" : "",
        "lastName" : "Suro",
        "email": "suro@examples.com"
      }
      """
    And the header "app-id" is "66367c7b3ec826592a67a062"
    When I make a POST request to "user/create"
    Then the status code should be 400
    And the response should contain "error" with value "BODY_NOT_VALID"
    And the response should contain "data.firstName" with value "Path `firstName` is required."

  Scenario: [TC 5] Missing lastName in request body
    Given the request body is
      """
      {
        "firstName" : "Azis",
        "lastName" : "",
        "email": "suro@examples.com"
      }
      """
    And the header "app-id" is "66367c7b3ec826592a67a062"
    When I make a POST request to "user/create"
    Then the status code should be 400
    And the response should contain "error" with value "BODY_NOT_VALID"
    And the response should contain "data.lastName" with value "Path `lastName` is required."
