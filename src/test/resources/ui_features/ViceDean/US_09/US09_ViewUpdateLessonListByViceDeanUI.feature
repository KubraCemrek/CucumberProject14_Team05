@UI @US09

Feature: Vice Dean should be able to view and update the course list.
  Background:
    Given Go to the given URL
    When Click on the Login link
    And Enter "ViceDeanMehmet" into the User Name field
    And Enter "Aras8891" into the Password field
    And Click on the Login button
    And Click on the Lessons tab

  @TC01
  Scenario: Vice Dean should be able to view the course list

    And Verify that Lesson Name information is visible in the Lesson List section
    And Verify that Compulsory information is visible
    And Verify that Credit Score information is visible

  @TC02
  Scenario: Vice Dean should be able to delete a course


    And Click on the trash can icon for the course named "STLC2" in the Lesson List
    Then Verify that the Lesson Deleted message is displayed

