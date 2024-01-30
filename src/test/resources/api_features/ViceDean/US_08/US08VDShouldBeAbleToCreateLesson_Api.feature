@API @US08

Feature: US08 Vice Dean should be able to create a lessons
  Background:
    Given a login is performed with "ViceDean" account
    And the URL is formatted to create a lesson

  Scenario: TC01 Vice Dean should be able to create a lessons

    And the payload is prepared for the lesson
    When a POST request is sent for the lesson and a response is received
    Then it is verified that the status code for the lesson is 200
    And the response body for the lesson is validated

  Scenario: TC02 Vice Dean should not be able to create same lessons

    And the payload is prepared for the same lesson
    When a POST request is sent for the lesson and a response is received
    Then it is verified that the status code for the lesson is 409
    And the response body for the same lesson is validated