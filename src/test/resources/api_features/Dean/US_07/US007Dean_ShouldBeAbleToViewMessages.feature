@API007
Feature: The Dean should be able to view messages

  Scenario: TC01 The Dean should be able to create messages
    Given Login as Dean and set the URL for create message.
    When Create the Payload for Save Message.
    When Dean sends a POST request for create Messages and receives a response.
    And Verify that The Status Code is 200.
    Then Verify that the response body for create messages.

  Scenario: TC02 The Dean should be able to view messages
    Given Login as Dean and set the URL for view message.
    When Dean sends a GET request for Views Messages.
    And Verify that The Status Code is 200.
    Then Create expected Data for Views Messages
    Then Verify that the response body for view messages.
