@DB_US25
  Feature: Admin, Student Information Verification
    Scenario: Admin Registered Student Information Verification Test
      Given Set up the  database connectionAdmin
      And Generate the expected Admin Student data
      When Sent the query to get registered Admin Student information
      Then Verify registered Admin Student data