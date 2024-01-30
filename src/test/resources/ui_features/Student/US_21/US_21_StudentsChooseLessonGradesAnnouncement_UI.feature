@UI_US21

Feature: US21 Students_Choose_Lesson_Grades_Announcement

  Background:
    Given go to url
    And click Login button
    And enter "xaydin" to the Username textbox
    And enter "Hüsamettin3342." to the Password textbox
    When click blue Login button
    Then verify that Choose Lesson Management page appears

  Scenario: US21_TC01 Positive_01
    Then Verify that the title Teacher appears on the page
    Then Verify that the title Day appears on the page
    Then Verify that the title Start Time appears on the page
    Then Verify that the title Stop Time appears on the page

  Scenario: US21_TC02 Positive_02
    When Click on the checkbox of the first Lesson
    Then Verify that the checkbox of the first lesson is selected
    When Click on the checkbox of the second Lesson (not having the same time period with first lesson)
    Then Verify that the checkbox of the second lesson is selected
    When click submit button
    Then Verify that the lessons that choosen are in the Lesson Program List at the bottom of the page

   Scenario: US21_TC03 Negative_01
   When Click on the checkbox of the first Lesson
   Then Verify that the checkbox of the first lesson is selected
   When Click on the checkbox of the second Lesson (having the same time period with first lesson)
   Then Verify that the checkbox of the second lesson is selected
   When click submit button
   Then Verify that the warning message about unability to select same time period lessons appears on the top of the page

     Scenario: US21_TC04 Positive_03 Delete Lesson
       # Bug here
     When Click on the checkbox of the first Lesson
     Then Verify that the checkbox of the first lesson is selected
     When Click Delete button
     Then Verify that selected lesson is deleted

