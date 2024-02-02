@API_US11 @kubra
Feature: Must be able to view course schedule API

  Background:
    Given Login as "Vice Dean"

    #PostSave #GetById #Delete
  Scenario: TC_01 Must be able to view and update course schedule API
    And VdURL is prepared for Lesson Program Save
    And Payload is arranged for the Lesson Program
    When POST Request is sent and Response is received for the Lesson Program
    Then Verify that the status code for lesson programs is 200
    And The response body for lessons programs is verified
    And URL is edited for Vice Dean GetById
    Then Verify that the status code for lesson programs getbyId is 200
    And  VdUrl is edited to delete lesson programs
    When For Lesson programs, a DELETE Request is issued and a Response is received
    Then In order to delete lessons programs, it is verified that the Status code is 200


  Scenario: GetAll - You Should Be Able to View Lesson Programs with Vice Dean Account
    And VdUrl is edited for getting all lesson programs
    When For Lesson programs, a GETALL Request is issued and a Response is received
    Then In order to see the lessons programs, it is verified that the Status code is 200