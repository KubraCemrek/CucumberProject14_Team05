@UI_US007
  Feature: US007, Dean Kullanicilarin Gonderdigi Mesajlari Gorebilmelidir
    Scenario: TC01-Dean, mesajları, yazarlarını, e-maillerini, gönderilme tarihi ve  subject bilgilerini görüntüleyebilmelidir
      Given The website is visitedyk
      When click Loginyk.
      And  enter usernameyk
      And enter passwordyk.
      And click Login Buttonyk
      And click the Menu button.
      And click the Contact Get All button.
      Then Dean confirms viewing information.

      Scenario: TC02-Dean, kullanıcıların gönderdiği mesajları silebilmelidir.
        Given The website is visitedyk
        When click Loginyk.
        And  enter usernameyk
        And enter passwordyk.
        And click Login Buttonyk
        And click the Menu button.
        And click the Contact Get All button.
        Then delete button and delete messages are confirmed.
        