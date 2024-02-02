@DB_US_24

Feature: Verify Teacher Information
  Scenario: Verify Registered Teacher Information
    Given Connect to the Database_hu.
    Then Vice Dean creates Expected Response Body for get_DB_hu.
    And send a Query to get the Vice Dean Get Manager ById_hu.
    And verify registered teacher information_hu.
    And Cut the connection_hu.

