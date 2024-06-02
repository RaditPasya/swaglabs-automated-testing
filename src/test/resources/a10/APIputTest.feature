Feature: API TEST - PUT

  Scenario: Missing APP_ID header
    Given the PUT header "app-id" is ""
    And the PUT request body is
      """
      {
        "title": "mrs",
        "firstName": "Josefina",
        "lastName": "Calvo",
        "picture": "https://randomuser.me/api/portraits/med/women/3.jpg",
        "gender": "female",
        "email": "josefina.calvo@example.com",
        "dateOfBirth": "1982-01-27T16:01:51.717Z",
        "phone": "976-538-478",
        "location": {
          "street": "8941, Calle de Argumosa",
          "city": "Orihuela",
          "state": "Ceuta",
          "country": "Spain",
          "timezone": "0:00"
        }
      }
      """
    When I make a PUT request to "60d0fe4f5311236168a109ff"
    Then the PUT status code should be 403
    And the PUT response should contain "error" with value "APP_ID_MISSING"

  Scenario: Invalid APP_ID header
    Given the PUT header "app-id" is "6635747e0de1363eba89ff1g"
    And the PUT request body is
      """
      {
        "title": "mrs",
        "firstName": "Josefina",
        "lastName": "Calvo",
        "picture": "https://randomuser.me/api/portraits/med/women/3.jpg",
        "gender": "female",
        "email": "josefina.calvo@example.com",
        "dateOfBirth": "1982-01-27T16:01:51.717Z",
        "phone": "976-538-478",
        "location": {
          "street": "8941, Calle de Argumosa",
          "city": "Orihuela",
          "state": "Ceuta",
          "country": "Spain",
          "timezone": "0:00"
        }
      }
      """
    When I make a PUT request to "60d0fe4f5311236168a109ff"
    Then the PUT status code should be 403
    And the PUT response should contain "error" with value "APP_ID_NOT_EXIST"

  Scenario: Valid request with correct APP_ID
    Given the PUT header "app-id" is "6635747e0de1363eba89ff1f"
    And the PUT request body is
      """
      {
        "firstName": "Josefina",
        "lastName": "Calvi"
      }
      """
    When I make a PUT request to "60d0fe4f5311236168a109ff"
    Then the PUT status code should be 200
    And the PUT response should contain "id" with value "60d0fe4f5311236168a109ff"
    And the PUT response should contain "firstName" with value "Josefina"
    And the PUT response should contain "lastName" with value "Calvi"

  Scenario: Valid request with full update
    Given the PUT header "app-id" is "6635747e0de1363eba89ff1f"
    And the PUT request body is
      """
      {
        "title": "mr",
        "firstName": "Josafina",
        "lastName": "Calvi",
        "picture": "https://randomuser.me/api/portraits/med/women/3.jpg",
        "gender": "male",
        "email": "josefina.calvo@example.com",
        "dateOfBirth": "1995-01-27T16:01:51.717Z",
        "phone": "977-538-478",
        "location": {
          "street": "8951, Calle de Argumosa",
          "city": "Orichuela",
          "state": "Cheuta",
          "country": "USA",
          "timezone": "1:00"
        }
      }
      """
    When I make a PUT request to "60d0fe4f5311236168a109ff"
    Then the PUT status code should be 200
    And the PUT response should contain "id" with value "60d0fe4f5311236168a109ff"
    And the PUT response should contain "firstName" with value "Josafina"
    And the PUT response should contain "lastName" with value "Calvi"

  Scenario: Invalid request with incorrect gender type
    Given the PUT header "app-id" is "6635747e0de1363eba89ff1f"
    And the PUT request body is
      """
      {
        "gender": 69
      }
      """
    When I make a PUT request to "60d0fe4f5311236168a109ff"
    Then the PUT status code should be 400
    And the PUT response should contain "error" with value "BODY_NOT_VALID"
