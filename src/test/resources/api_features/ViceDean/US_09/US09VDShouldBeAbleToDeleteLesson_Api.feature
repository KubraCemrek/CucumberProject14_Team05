@API @US09

Feature: US09 Vice Dean should be able to delete a lesson
  Background:
    Given a login is performed with "ViceDean" account


  Scenario: TC01 Vice Dean should be able to create a lesson
    And the URL is formatted to see a lesson
    And the payload is prepared for the current lesson
    When a GET request is sent for the current lesson and a response is received
    Then it is verified that the status code for the current lesson is 200
    And the response body for the current lesson is validated

  Scenario: TC02 Vice Dean should be able to delete a lesson
    And the URL is formatted to delete a lesson
    When a DELETE request is sent for the lesson and a response is received
    Then it is verified that the status code for the deleted lesson is 200
    And the response body for the deleted lesson is validated

