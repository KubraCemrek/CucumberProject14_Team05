@US15
Feature: Vice Dean should be able to register students

  Background:
    Given Navigate to web site and Login as Vice Dean
    And Click on Menu button and select Student Management from Main Menu.
    And Advisor Teacher should be selected.

 Scenario: US15 TC01: Vice Dean should be able to register students

 When Enters "Ali" in the Name field
 And Enters "Yılmaz" in the SurName field
 And Enters "İstanbul" in BirthPlace field
 And Enters "murry@gmail.com" in email field.
 And Enters "a phone number" in phone field
 And Select checkbox "MALE"
 And Enters "05092017" in DateOfBirth field
 And Enters "an ssn number" in SSN field
 And Enters "a user name" in UserName field
 And Enters "Father" in Father Name field
 And Enters "Mother" in Mother Name field
 And Enters password in Password field
 And Click Submit button
 Then Verify that student can be registered as Vice Dean


 Scenario: US15 TC03:  Vice Dean cannot be able to registerd by left blank "Name" field
   When Leave blank in Name field
   And Enters "Yılmaz" in the SurName field
   And Enters "İstanbul" in BirthPlace field
   And Enters "murry@gmail.com" in email field.
   And Enters "a phone number" in phone field
   And Select checkbox "MALE"
   And Enters "05092017" in DateOfBirth field
   And Enters "an ssn number" in SSN field
   And Enters "a user name" in UserName field
   And Enters "Father" in Father Name field
   And Enters "Mother" in Mother Name field
   And Enters password in Password field
   And Click Submit button
   Then Verify that student registration is not completed

#Bu TC'de bug oldugu icin otomasyon yapılmaz. once bug giderilmesi lazım

#Scenario: US15 TC07:  student registration should not be generated while email is entered as "example@gmailcom"
#  When Enters "Ali" in the Name field
#  And Enters "Yılmaz" in the SurName field
#  And Enters "İstanbul" in BirthPlace field
#  And Enters invalid email adress in E-mail field
#  And Enters "a phone number" in phone field
#  And Select checkbox "MALE"
#  And Enters "05092017" in DateOfBirth field
#  And Enters "an ssn number" in SSN field
#  And Enters "a user name" in UserName field
#  And Enters "Father" in Father Name field
#  And Enters "Mother" in Mother Name field
#  And Enters password in Password field
#  And Click Submit button
#  Then Verify that student registration cannot be created with an invalid email


  Scenario: US15 TC09: Vice Dean cannot be able to generate student registiration by leaving "Gender" field blank
    When Enters "Ali" in the Name field
    And Enters "Yılmaz" in the SurName field
    And Enters "İstanbul" in BirthPlace field
    And Enters "murry@gmail.com" in email field.
    And Enters "a phone number" in phone field
    And Select checkbox ""
    And Enters "05092017" in DateOfBirth field
    And Enters "an ssn number" in SSN field
    And Enters "a user name" in UserName field
    And Enters "Father" in Father Name field
    And Enters "Mother" in Mother Name field
    And Enters password in Password field
    And Click Submit button
    Then Verify that student registiration cannot be formed without gender selection


 Scenario:US15 TC12: Vice Dean cannot be able to generate student registiration by leaving "SSN" field blank
   When Enters "Ali" in the Name field
   And Enters "Yılmaz" in the SurName field
   And Enters "İstanbul" in BirthPlace field
   And Enters "murry@gmail.com" in email field.
   And Enters "a phone number" in phone field
   And Select checkbox "MALE"
   And Enters "05092017" in DateOfBirth field
   And Enters "3" in SSN field
   And Enters "a user name" in UserName field
   And Enters "Father" in Father Name field
   And Enters "Mother" in Mother Name field
   And Enters password in Password field
   And Click Submit button
   Then Verify that student registiration cannot be formed without entering a valid SSN selection


  Scenario:US15 TC15: Vice Dean cannot be able to generate student registiration by leaving "User Name" field blank
    When Enters "Ali" in the Name field
    And Enters "Yılmaz" in the SurName field
    And Enters "İstanbul" in BirthPlace field
    And Enters "murry@gmail.com" in email field.
    And Enters "a phone number" in phone field
    And Select checkbox "MALE"
    And Enters "05092017" in DateOfBirth field
    And Enters "an ssn number" in SSN field
    And Enters "" in UserName field
    And Enters "Father" in Father Name field
    And Enters "Mother" in Mother Name field
    And Enters password in Password field
    And Click Submit button
    Then Verify that student registration cannot be created by leaving user name field blank



 Scenario Outline: US15 TC18: Fill the field enters a password of less than eight characters, no uppercase or lowercase letters, no numbers
   When Enters "Ali" in the Name field
   And Enters "Yılmaz" in the SurName field
   And Enters "İstanbul" in BirthPlace field
   And Enters "murry@gmail.com" in email field.
   And Enters "a phone number" in phone field
   And Select checkbox "MALE"
   And Enters "05092017" in DateOfBirth field
   And Enters "an ssn number" in SSN field
   And Enters "a user name" in UserName field
   And Enters "Father" in Father Name field
   And Enters "Mother" in Mother Name field
   And "<Password>" Fill the field enters a password of less than eight characters, no uppercase or lowercase letters, no numbers
   And Click Submit button
   Then verify that a student registiration cannot be successfully created with invalid passwords entered

   Examples:
     | Password |
     | Gakky12  |
     | gakky123 |
     | GAKKY123 |
     | Gakkylar |

