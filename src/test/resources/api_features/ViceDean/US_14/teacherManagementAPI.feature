@API_US14 @kubra
Feature: Teacher Management API

  @TC01
  Scenario: Vice Dean should be able to get the information of the teacher named "Kubra " via API

    Given a login is performed with "ViceDean" account
    When URL is edited for Teachers getTeacherByName
    And expectedData is edited for Teachers getTeacherByName
    And a post request is sent for Teachers getTeacherByName and a response is received.
    Then verifies that the status code is 200
    And response body for Teachers getTeacherByName Lesson is verified

  @TC02
  Scenario: Vice Dean should be able to update the information of the teacher named "Kubra " (API)
    Given a login is performed with "ViceDean" account
    When URL is edited for Teachers update
    And payload is edited for Teachers update
    And a post request is sent for teachers update and a response is received
    Then verifies that the status code is 200
    And response body for Teachers update Lesson is verified