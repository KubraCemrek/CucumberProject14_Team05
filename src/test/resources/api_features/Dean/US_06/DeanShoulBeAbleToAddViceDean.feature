@API_US006
Feature: Dean should be able to register students

  Scenario: TC01 Dean must be successfully added with Vice Dean Account
    Given Login as Dean and set the URL for Vice Dean SAVE
    When Create the Payload for Student Saveas Admin
    And Admin sends a POST request for adding a student and receives a response
    Then Verify that the Status Code is 200
    Then Verify that the response body for Student Save.

#Scenario: The student created as Admin should be able to view the student with his/her id.
#  Given    Login as Admin and  Get the ID number of the registered Student account information
#  And       Set the URL for Student GetStudentById.
#  And       Set the expected data for Student GetStudentById.
#  When      Send GET Request for Student GetStudentById and get Response.
#  Then      Verify that Status Code is 200
#  And       Verify the Response Body for Student GetStudentById.
#
# Scenario:   TC03 - Admin should be able to delete Registered Student account
#   Given     Edit teh URL for Student Delete.
#   When      Send the DELETE Request and Response is received.
#   And       Verify that Status Code is 200
#   Then      Verify that the Response Body for Student Delete is validated.