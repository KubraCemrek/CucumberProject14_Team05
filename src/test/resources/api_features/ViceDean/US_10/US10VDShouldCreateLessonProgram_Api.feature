@API @US10
Feature: US10 Vice Dean should be able to create a lesson program

  Scenario: TC01 Vice Dean should be able to create a lesson program
    Given a login is performed with "ViceDean" account
    And the URL is configured for creating a lesson program
    And the payload is prepared for the lesson program
    When a POST request is sent for the lesson program, and a response is received
    Then it is verified that the status code for the lesson program is 200
    And the response body for the lesson program is verified