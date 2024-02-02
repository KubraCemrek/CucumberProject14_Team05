@smokeKubra
Feature: Must be able to view course schedule

  Scenario: TC_01 Must be able to view and update course schedule
    Given User enters the home page_k
    When User clicks Login_k
    And  User enters User Name "ViceDean_Kubra" _k
    And User enters Password "Kc1234567" _k
    And User clicks the Login button_k
    Then From Lesson Program List; Must be able to see Lesson, Day, Start Time, Stop Time.