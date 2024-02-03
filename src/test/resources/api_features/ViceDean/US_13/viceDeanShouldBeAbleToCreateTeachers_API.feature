@API_US_13
Feature: Vice Dean Controller
  Scenario: POST Reques Teacher account creation test with Vice Dean authority
    Given Login as "Vice Dean"_hu
    And Save URL for Teacher edit_hu
    And Save  Payload Teacher edit_hu
    When A POST Request is sent to Register a Teacher and a Response is received_hu
    Then Verified status code is 200_hu
    And Response Body for Teacher Save is verified_hu


  Scenario: GET Reques Teacher account creation test with Vice Dean authority
    Given Login as "Vice Dean"_hu
    And Vice Dean seved the userID after created teacher_hu
    Then Vice Dean creates GET Request with the URL and teacher-search path parameters_hu
    Then Vice Dean creates Expected Response Body for get_hu
    When Vice Dean sends GET Request gonderilir ve Response alinir_hu
    Then Verified status code is 200_hu
    And Vice Dean sends GET  Response Body as expected_hu


  Scenario: Vice Dean send DELETE Request to delete Teacher from the website_hu
    Given Login as "Vice Dean"_hu
    Then Vice Dean creates DELETE Request with the URL and teacher-search path parameters_hu
    Then Vice Dean sends DELETE Request with the URL and delete path parameters_hu
    Then Teacher deletion Status code is verified as 200_hu
    And The Vice Dean confirmed the deletion of the Teacher's Text, as expected_hu
