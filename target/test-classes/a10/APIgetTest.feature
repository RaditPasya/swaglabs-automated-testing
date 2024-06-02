Feature: API TEST - GET

  Scenario: [TC 1] Missing APP_ID header
    Given the GET header "app-id" is ""
    When I make a GET request to "60d0fe4f5311236168a10a00"
    Then the GET status code should be 403
    And the GET response should contain "error" with value "APP_ID_MISSING"

  Scenario: [TC 2] Invalid APP_ID header
    Given the GET header "app-id" is "6635747e0de1363eba89ff1g"
    When I make a GET request to "60d0fe4f5311236168a10a00"
    Then the GET status code should be 403
    And the GET response should contain "error" with value "APP_ID_NOT_EXIST"

  Scenario: [TC 3] Valid request with correct APP_ID
    Given the GET header "app-id" is "66367c7b3ec826592a67a062"
    When I make a GET request to "60d0fe4f5311236168a10a00"
    Then the GET status code should be 200
    And the GET response should contain "id" with value "60d0fe4f5311236168a10a00"
    And the GET response should contain "firstName" with value "Els"
    And the GET response should contain "lastName" with value "Ijsseldijk"

  Scenario: [TC 4] User ID not found
    Given the GET header "app-id" is "66367c7b3ec826592a67a062"
    When I make a GET request to "60d0fe4f5311236168a109f1"
    Then the GET status code should be 404
    And the GET response should contain "error" with value "RESOURCE_NOT_FOUND"

  Scenario: [TC 5] Invalid User ID
    Given the GET header "app-id" is "66367c7b3ec826592a67a062"
    When I make a GET request to "0"
    Then the GET status code should be 400
    And the GET response should contain "error" with value "PARAMS_NOT_VALID"
