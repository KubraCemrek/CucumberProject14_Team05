@API_US17_US18
Feature: Student_Info_Management Add Student Info
  Scenario: Teacher kullanicisi ile not verme testi
    Given Not verme icin URL duzenlenir
      And Not verme icin payload duzenlenir
      When Not verme icin POST Request gonderilir ve Reponse alinir
      Then Gelen Status kodun 200 oldugu dogrulanir
      And Not verme icin gelen Response body dogrulanir

  #@API_US17_US18_Test_1
  Scenario: Teacher kullanicisi verdigi notlari gorebilir testi
    Given StudentInfoGetID icin URL duzenlenir
    And StudentInfoGetID icin beklenen veriler olusturulur
    When StudentInfoGetID icin POST Request gonderilir ve Reponse alinir
    Then Gelen Status kodun 200 oldugu dogrulanir
    And Verilen notlarin goruldugu dogrulanir


 # @API_US17_US18_Test_2
  Scenario: Teacher kullanicisinin verdigi notu guncelleyebilmesi testi
     Given Not guncelleme icin URL düzenlenir
     And Not guncelleme icin payload duzenlenir
     When Not guncelleme icin POST Request gonderilir ve Reponse alinir
     Then Gelen Status kodun 200 oldugu dogrulanir
     And Not guncelleme icin gelen Response body dogrulanir

 # @API_US17_US18_Test_3
  Scenario: Teacher kullanicisi verdigi notu silebilir
    Given Not silme icin URL düzenlenir
    And Not silme icin beklenen veriler olusturulur
    When Not silme icin POST Request gonderilir ve Reponse alinir
    Then Gelen Status kodun 200 oldugu dogrulanir
    And Not silme icin gelen Response body dogrulanir