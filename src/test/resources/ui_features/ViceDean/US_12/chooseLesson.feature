@smokeKubra
Feature: Choose Lessons
  Scenario: creating a course schedule
    Given User enters the home page
    When User clicks Login
    And  User enters User Name "ViceDean_Kubra"
    And User enters Password "Kc1234567"
    And User clicks the Login button
    And Lesson program is selected
    And From the Add Course section select Select Course Education Period Select Day Start Time End Time
    And Click on the Submit button
    Then User can see that the created lesson is in the Choose Lesson section

