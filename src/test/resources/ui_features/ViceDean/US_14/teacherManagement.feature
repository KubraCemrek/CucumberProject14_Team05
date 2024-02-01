@smokeKubra
Feature: Teacher Management

  Background:
    Given User enters the home page
    When User clicks Login
    And  User enters User Name "ViceDean_Kubra"
    And User enters Password "Kc1234567"
    And User clicks the Login button
    And User clicks on menu button
    And User clicks on Teacher management button

  Scenario: Vice Dean should see teachers
    Then User should see teacher list

  Scenario: Vice Dean should update teacher's information
    And User clicks on edit button
    And User update the teacher's lesson
    And User enters name in the box
    And User enters surName  in the box
    And User enters birthPlace in the box
    And User enters email in the box
    And User enters phone in the box
    And User enters is Advisor
    And User enters gender "MALE"
    And User enters dateOfBirth in the box "01/01/1983"
    And User enters SSN in the box
    And User enters userName
    And User enters password in the password box
    And User enters clicks the submit button


  Scenario: Vice Dean not update teacher's information due to missing lesson information
    And User clicks on edit button
    And User enters name in the box
    And User enters surName  in the box
    And User enters birthPlace in the box
    And User enters email in the box
    And User enters phone in the box
    And User enters is Advisor
    And User enters gender "MALE"
    And User enters dateOfBirth in the box "01/01/1983"
    And User enters SSN in the box
    And User enters userName
    And User enters password in the password box
    And User enters clicks the submit button

  Scenario: Vice Dean not update teacher's information due to missing name information
    And User clicks on edit button
    And User update the teacher's lesson
    And User enters null name in the box
    And User enters surName  in the box
    And User enters birthPlace in the box
    And User enters email in the box
    And User enters phone in the box
    And User enters is Advisor
    And User enters gender "MALE"
    And User enters dateOfBirth in the box "01/01/1983"
    And User enters SSN in the box
    And User enters userName
    And User enters password in the password box
    And User enters clicks the submit button

  Scenario: Vice Dean not update teacher's information due to missing email information
    And User clicks on edit button
    And User update the teacher's lesson
    And User enters name in the box
    And User enters surName  in the box
    And User enters birthPlace in the box
    And User enters null email in the box
    And User enters phone in the box
    And User enters is Advisor
    And User enters gender "MALE"
    And User enters dateOfBirth in the box "01/01/1983"
    And User enters SSN in the box
    And User enters userName
    And User enters password in the password box
    And User enters clicks the submit button