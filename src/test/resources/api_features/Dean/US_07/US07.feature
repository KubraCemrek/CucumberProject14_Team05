@API007
Feature: The Dean should be able to view messages

  Scenario: TC01 The Dean should be able to view messages
    Given Login as Dean and set the URL for Vice Dean SAVE.
    When Create the Payload for Vice Dean Save as Dean.
    And Dean sends a POST request for adding a Vice Dean and receives a response.
    Then Verify that the Status Code is 200.
    Then Verify that the response body for Vice Dean Save.
