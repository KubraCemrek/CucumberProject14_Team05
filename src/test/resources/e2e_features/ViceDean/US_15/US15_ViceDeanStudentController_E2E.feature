@E2Eus15
Feature: Vice Dean Student Controller E2E
  Scenario:  Vice Dean should be able to register students
    Given Navigate to web site and Login as Vice Dean
    And Click on Menu button and select Student Management from Main Menu.
    And Advisor Teacher should be selected.
    When Enters "Courtney" in the Name field
    And Enters "Hilpert" in the SurName field
    And Enters "impedit" in BirthPlace field
    And Enters "branda.beier@yahoo.com" in email field.
    And Enters "059-166-0285" in phone field
    And Select checkbox "MALE"
    And Enters "05052017" in DateOfBirth field
    And Enters "086-95-1091" in SSN field
    And Enters "2443gakky" in UserName field
    And Enters "Laree" in Father Name field
    And Enters "Anne" in Mother Name field
    And Enters password in Password field
    And Click Submit button
    Then Verify that student can be registered as Vice Dean


  Scenario: The student created as Vice Dean should be able to view the student with his/her id.
    Given    Login as Vice Dean and  Get the ID number of the registered Student account information
    And       Set the URL for Student GetStudentById
    And       Set the expected data for Student GetStudentById
    When      Send GET Request for Student GetStudentById and get Response
    Then      Verify that Status code is 200
    And       Verify the Response Body for Student GetStudentById


  Scenario: Vice Dean Registered Student Information Verification Test
    Given Set up the  database connectionVD.
    And Generate the expected Vice Dean Student data
    When Sent the query to get registered Vice Dean Student information
    Then Verify registered Vice Dean Student data

  Scenario:   Vice Dean should be able to delete Registered Student account
    Given     Edit teh URL for Student Delete
    When      Send the DELETE Request and Response is received
    And       Verify that Status code is 200
    Then      Verify that the Response Body for Student Delete is validated

