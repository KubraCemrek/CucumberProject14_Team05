@UI @US10

Feature: The Vice Dean should be able to create a lesson schedule
  Background:
    Given Go to the given URL
    When Click on the Login link
    And Enter "ViceDeanMehmet" into the User Name field
    And Enter "Aras8891" into the Password field
    And Click on the Login button
    And Click on the Lesson Program tab
    And Choose a lesson from the Choose Lessons menu
    And Select an education term from the Choose Education Term menu

  @TC01
  Scenario: TC01 The Vice Dean should be able to create a lesson schedule

    And Select a day from the Choose Day menu
    And Enter a start time in the Start Time box
    And Enter a stop time in the Stop Time box
    And Click on the Lesson Submit button
    Then Verify that the "Created Lesson Program" message is displayed.



  @TC02
  Scenario: TC02 The Vice Dean should not be able to create a lesson schedule without selecting a day.

    And Leave the Choose Day menu EMPTY
    And Enter a start time in the Start Time box
    And Enter a stop time in the Stop Time box
    And Click on the Lesson Submit button
    Then Verify that the Lesson Program is not created