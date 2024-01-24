@UI_US006
Feature: US006 The Dean should be able to create a Vice Dean account.

  Scenario: TC01 Dean should be able to add a Vice Dean on the website.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean confirmed.

  Scenario: TC02 Vice Dean cannot be added with the Name field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Name field is empty.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC03 Vice Dean cannot be added with the Surname field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Surname field is empty.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC04 Vice Dean cannot be added with the Birthplace field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And BirthPlace field is empty.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC05 Vice Dean cannot be added with the Gender field not selected.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Gender box is not selected.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC06 Vice Dean cannot be added with the Date of Birth field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And DateOfBirth field is empty.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC07 Vice Dean cannot be added with the PhoneNumber field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Phone field is empty.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC08 Vice Dean cannot be added with the SSN field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And SSN field is empty.
    And Enters "bir kullanici adi" into the username field.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC09 Vice Dean cannot be added with the UserName field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Username field is empty.
    And Enter passwords into the password field.
    And click the Submit Button.
    Then Vice Dean record has not been created.

  Scenario: TC10 Vice Dean cannot be added with the Password field left empty.
    Given The website is visited.
    When click Login.
    And  enter username.
    And enter password.
    And click Login Button.
    And Enters "bir isim" into the name field.
    And Enters "bir soyisim" into the surname field.
    And Enters "bir yer isim" into the birthplace field.
    And Select "Male" options.
    And Enters "05051975" into the dateOfBirth field.
    And Enters "bir telefon numarasi" into the phone field.
    And Enters "bir ssn numarasi" into the SSN field.
    And Enters "bir kullanici adi" into the username field.
    And Password field is empty.
    And click the Submit Button.
    Then Vice Dean record has not been created.