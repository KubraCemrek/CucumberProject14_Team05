@API_US15
Feature: Vice Dean should be able to register students

Scenario: TC01- Student must be successfully added with Vice Dean Account
  Given Login as Vice Dean and set the URL for student SAVE
  And Create the Payload for Student Save
  When Vice Dean sends a POST request for adding a student and receives a response
  Then Verify that the status code is 200
  And Verify that the response body for Student Save

Scenario: TC02- The student created as Vice Dean should be able to view the student with his/her id.
  Given    Login as Vice Dean and  Get the ID number of the registered Student account information
  And       Set the URL for Student GetStudentById
  And       Set the expected data for Student GetStudentById
  When      Send GET Request for Student GetStudentById and get Response
  Then      Verify that Status code is 200
  And       Verify the Response Body for Student GetStudentById

 Scenario:   TC03 - Vice Dean should be able to delete Registered Student account
   Given     Edit teh URL for Student Delete
   When      Send the DELETE Request and Response is received
   And       Verify that Status code is 200
   Then      Verify that the Response Body for Student Delete is validated
