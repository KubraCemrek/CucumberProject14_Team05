@smokeKubra
Feature: Must be able to view course schedule.

  Scenario: TC_01 Must be able to view and update course schedule.
    Given User enters the home page
    When User clicks Login
    And  User enters User Name "ViceDean_Kubra"
    And User enters Password "Kc1234567"
    And User clicks the Login button
    Then From Lesson Program List; Must be able to see Lesson, Day, Start Time, Stop Time.