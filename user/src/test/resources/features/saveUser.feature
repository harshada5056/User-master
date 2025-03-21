Feature: Test User API

  Scenario: Create a new user
    Given I send a POST request to "http://localhost:9003/user/saveUser"
    Then the response status should be 200
    And the response body should contain "userId"

