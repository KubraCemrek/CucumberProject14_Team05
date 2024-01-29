@E2Eus25
Feature: Admin should be able to register students
  Scenario: US25 TC01: Admin should be able to register students.
    Given Navigate to web site and Login as Admin.
    And Click on Menu Button and select Student Management from Main Menu
    And Advisor Teacher should be Selected.
    When Enters "Maya" in Name Field.
    And Enters "Turkmen" in the SurName Field.
    And Enters "Ahal" in BirthPlace Field.
    And Enters "wesson.andru@falkcia.com" in email Field
    And Enters "059-176-3275" in phone Field.
    And Select Checkbox "FEMALE".
    And Enters "05092019" in DateOfBirth Field.
    And Enters "298-59-2092" in SSN Field.
    And Enters "maya2022" in UserName Field.
    And Enters "Maksat" in Father Name Field.
    And Enters "Jumagul" in Mother Name Field.
    And Enters password in Password Field.
    And Click Submit Button.
    Then Verify that student can be Registered as Admin

  Scenario: The student created as Admin should be able to view the student with his/her id.
    Given    Login as Admin and  Get the ID number of the registered Student account information
    And       Set the URL for Student GetStudentById.
    And       Set the expected data for Student GetStudentById.
    When      Send GET Request for Student GetStudentById and get Response.
    Then      Verify that Status Code is 200
    And       Verify the Response Body for Student GetStudentById.


  Scenario: Admin Registered Student Information Verification Test
    Given Set up the  database connectionAdmin
    And Generate the expected Admin Student data
    When Sent the query to get registered Admin Student information
    Then Verify registered Admin Student data

  Scenario:   Admin should be able to delete Registered Student account
    Given     Edit teh URL for Student Delete.
    When      Send the DELETE Request and Response is received.
    And       Verify that Status Code is 200
    Then      Verify that the Response Body for Student Delete is validated.