@DB_US15
Feature: Vice Dean, Student Information Verification
  Scenario: Vice Dean Registered Student Information Verification Test
    Given Set up the  database connectionVD.
    And Generate the expected Vice Dean Student data
    When Sent the query to get registered Vice Dean Student information
    Then Verify registered Vice Dean Student data