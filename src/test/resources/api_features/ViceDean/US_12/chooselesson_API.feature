@API_US12 @kubra
Feature: US12 Choose Lessons

  Scenario: TC01 creating a course schedule API
    Given a login is performed with "ViceDean" account
    When the URL is configured for creating a lesson program
    And the payload is prepared for the lesson program
    And a POST request is sent for the lesson program, and a response is received
    And it is verified that the status code for the lesson program is 200
    Then the response body for the lesson program is verified

  Scenario: ViceDean course assignment (Post)
    Given a login is performed with "ViceDean" account
    When teacher ID is obtained
    And URL is edited for Choose Lesson(teacher)_k
    And payload is arranged for Choose Lesson(teacher)_k
    And a POST Request is sent for Choose Lesson(teacher) and a response is received_k
    Then response body for Choose Lesson(teacher) is verified_k