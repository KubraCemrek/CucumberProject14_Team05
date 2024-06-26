@API23
Feature: The Admin should be able to create a Vice Dean account.

  Scenario: TC01 Vice Dean must be successfully added by Admin Account
    Given Login as Admin and set the URL for Vice Dean SAVE.
    When Create the Payload for Vice Dean Save as Admin.
    And Admin sends a POST request for adding a Vice Dean and receives a response.
    Then Verify that the Status Code Is 200
    Then Verify that the response body for Vice Dean Save

  Scenario: TC02 Views that the created Vice Dean by Admin
    Given Login as Admin and set the URL for Vice Dean Views.
    And Admin sends a GET request for Views a Vice Dean and receives a response.
    Then Verify that the Status Code Is 200
    And Verify that the response body And Create expected Data for Vice Dean Views

  Scenario: TC03 Delete that the created Vice Dean by Admin
    Given Login as Admin and set the URL for Vice Dean Delete.
    And Admin sends a DELETE request for Delete a Vice Dean and receives a response.
    Then Verify that the Status Code Is 200
    And  Verify that the response body for Vice Dean Delete
