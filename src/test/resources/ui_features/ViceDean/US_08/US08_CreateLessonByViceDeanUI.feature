@UI @US08

Feature: Vice Dean should be able to create a lesson
  Background:
    Given Go to the given URL
    When Click on the Login link
    And Enter "ViceDeanMehmet" into the User Name field
    And Enter "Aras8891" into the Password field
    And Click on the Login button
    And Click on the Lessons tab
    And In the Add Lesson section, enter "Cypress1" into the Lesson Name field

  @TC01
  Scenario: TC01 Vice Dean should be able to create a lesson

    And Verify that data is entered into the Lesson Name field
    And Click on the Compulsory checkbox
    And Verify that the Compulsory checkbox is checked
    And Enter 5 into the Credit Score field
    And Verify that data is entered into the Credit Score field
    And Click on the Submit button
    Then Verify that the "Lesson Created" message is displayed


  @TC02
  Scenario: TC02 The Vice Dean should not be able to create a course with a previously registered name.

    And Click on the Compulsory checkbox
    And Enter 5 into the Credit Score field
    And Click on the Submit button
    Then Verify that the message "Error: Lesson with lesson name Cypress1 already registered" is displayed


