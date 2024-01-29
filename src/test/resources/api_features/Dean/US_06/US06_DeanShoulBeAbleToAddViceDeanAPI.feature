@API006
Feature: The Dean should be able to create a Vice Dean account.

  Scenario: TC01 Vice Dean must be successfully added by Dean Account
    Given Login as Dean and set the URL for Vice Dean SAVE.
    When Create the Payload for Vice Dean Save as Dean.
    And Dean sends a POST request for adding a Vice Dean and receives a response.
    Then Verify that the Status Code is 200.
    Then Verify that the response body for Vice Dean Save.

  Scenario: TC02 Views that the created Vice Dean.
    Given Login as Dean and set the URL for Vice Dean Views.
    And Dean sends a POST request for Views a Vice Dean and receives a response.
    Then Verify that the Status Code is 200.
    And Create expected Data for Views Vice Dean
    And Verify that the response body for Vice Dean Views.

  Scenario: TC03 Delete that the created Vice Dean.
    Given Login as Dean and set the URL for Vice Dean Delete.
    And Dean sends a POST request for Delete a Vice Dean and receives a response.
    Then Verify that the Status Code is 200.
    And Verify that the response body for Vice Dean Delete.