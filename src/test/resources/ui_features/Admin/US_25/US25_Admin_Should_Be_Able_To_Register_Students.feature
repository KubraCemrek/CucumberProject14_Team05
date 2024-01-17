@US25
Feature: Admin should be able to register students

  Background:
    Given Navigate to web site and Login as Admin.
    And Click on Menu Button and select Student Management from Main Menu
    And Advisor Teacher should be Selected.

 Scenario: US25 TC01: Admin should be able to register students.

 When Enters "Ali" in Name Field.
 And Enters "Yılmaz" in the SurName Field.
 And Enters "İstanbul" in BirthPlace Field.
 And Enters "murry@gmail.com" in email Field
 And Enters "a phone number" in phone Field.
 And Select Checkbox "MALE".
 And Enters "05092017" in DateOfBirth Field.
 And Enters "an ssn number" in SSN Field.
 And Enters "a user name" in UserName Field.
 And Enters "Father" in Father Name Field.
 And Enters "Mother" in Mother Name Field.
 And Enters password in Password Field.
 And Click Submit Button.
 Then Verify that student can be Registered as Admin


Scenario: US25 TC03:  Admin cannot be able to registerd by left blank "Name" field
  When Leave blank in Name field.
  And Enters "Yılmaz" in the SurName Field.
  And Enters "İstanbul" in BirthPlace Field.
  And Enters "murry@gmail.com" in email Field
  And Enters "a phone number" in phone Field.
  And Select Checkbox "MALE".
  And Enters "05092017" in DateOfBirth Field.
  And Enters "an ssn number" in SSN Field.
  And Enters "a user name" in UserName Field.
  And Enters "Father" in Father Name Field.
  And Enters "Mother" in Mother Name Field.
  And Enters password in Password Field.
  And Click Submit Button.
  Then Verify that student registration is not completed.


Scenario: US25 TC07: Student registration should not be generated while email is entered as "example@gmailcom"
  When Enters "Ali" in Name Field.
  And Enters "Yılmaz" in the SurName Field.
  And Enters "İstanbul" in BirthPlace Field.
  And Enters invalid email adress in E-mail Field
  And Enters "a phone number" in phone Field.
  And Select Checkbox "MALE".
  And Enters "05092017" in DateOfBirth Field.
  And Enters "an ssn number" in SSN Field.
  And Enters "a user name" in UserName Field.
  And Enters "Father" in Father Name Field.
  And Enters "Mother" in Mother Name Field.
  And Enters password in Password Field.
  And Click Submit Button.
  Then Verify that student registration cannot be created with an invalid email.


Scenario: US25 TC09: Admin cannot be able to generate student registiration by leaving "Gender" field blank
  When Enters "Ali" in Name Field.
  And Enters "Yılmaz" in the SurName Field.
  And Enters "İstanbul" in BirthPlace Field.
  And Enters "murry@gmail.com" in email Field
  And Enters "a phone number" in phone Field.
  And Select Checkbox "".
  And Enters "05092017" in DateOfBirth Field.
  And Enters "an ssn number" in SSN Field.
  And Enters "a user name" in UserName Field.
  And Enters "Father" in Father Name Field.
  And Enters "Mother" in Mother Name Field.
  And Enters password in Password Field.
  And Click Submit Button.
  Then Verify that student registiration cannot be formed without gender selection.

Scenario:US25 TC12: Admin cannot be able to generate student registiration by leaving "SSN" field blank
  When Enters "Ali" in Name Field.
  And Enters "Yılmaz" in the SurName Field.
  And Enters "İstanbul" in BirthPlace Field.
  And Enters "murry@gmail.com" in email Field
  And Enters "a phone number" in phone Field.
  And Select Checkbox "MALE".
  And Enters "05092017" in DateOfBirth Field.
  And Enters "2" in SSN Field.
  And Enters "a user name" in UserName Field.
  And Enters "Father" in Father Name Field.
  And Enters "Mother" in Mother Name Field.
  And Enters password in Password Field.
  And Click Submit Button.
  Then Verify that student registiration cannot be formed without entering a valid SSN selection.


 Scenario:US25 TC15: Admin cannot be able to generate student registiration by leaving "User Name" field blank
   When Enters "Ali" in Name Field.
   And Enters "Yılmaz" in the SurName Field.
   And Enters "İstanbul" in BirthPlace Field.
   And Enters "murry@gmail.com" in email Field
   And Enters "a phone number" in phone Field.
   And Select Checkbox "MALE".
   And Enters "05092017" in DateOfBirth Field.
   And Enters "an ssn number" in SSN Field.
   And Enters "" in UserName Field.
   And Enters "Father" in Father Name Field.
   And Enters "Mother" in Mother Name Field.
   And Enters password in Password Field.
   And Click Submit Button.
   Then Verify that student registration cannot be created by leaving user name field blank.



Scenario Outline: US25 TC18: Fill the field enters a password of less than eight characters, no uppercase or lowercase letters, no numbers
  When Enters "Ali" in Name Field.
And Enters "Yılmaz" in the SurName Field.
And Enters "İstanbul" in BirthPlace Field.
And Enters "murry@gmail.com" in email Field
And Enters "a phone number" in phone Field.
And Select Checkbox "MALE".
And Enters "05092017" in DateOfBirth Field.
And Enters "an ssn number" in SSN Field.
And Enters "a user name" in UserName Field.
And Enters "Father" in Father Name Field.
And Enters "Mother" in Mother Name Field.
  And "<Password>" Fill the field enters a password of less than eight characters, no uppercase or lowercase letters, no numbers.
  And Click Submit button
  Then Verify that a student registiration cannot be successfully created with invalid passwords entered

  Examples:
    | Password |
    | Gakky12  |
    | gakky123 |
    | GAKKY123 |
    | Gakkylar |

