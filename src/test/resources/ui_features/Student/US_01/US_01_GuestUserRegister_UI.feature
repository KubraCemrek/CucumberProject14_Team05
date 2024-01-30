@UI_US01

Feature: Aday ogrenci sisteme kayit olabilmeli (Register)

  Background:
    Given Kisi "url" adresine gider
    Then Aday ogrenci Register ikonuna tiklar


  Scenario: TC01 Name bos birakilamamalidir
    Given Kullanici "name" alaninda tab tusuna basar
    Then Kullanici "name" icin required uyarisini goruntuler

  Scenario Outline: TC02 Herhangi bir karakter iceren "Name" olmalidir (Positive- en az 2 karakter)
    Given Kullanici Name kutusuna "<name>" girer
    Then Kullanici at least iki character uyarisini goruntulemez
    Examples:
      | name               |
      | aa                 |
      | pera               |

  Scenario Outline: TC03 Herhangi bir karakter iceren "Name" olmalidir (Negative - 1 karakter)
    Given Kullanici Name kutusuna "<name>" girer
    Given Kullanici name disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici at least iki character uyarisini goruntuler
    Examples:
      | name  |
      | a     |

  Scenario: TC04 Surname bos birakilamamalidir
    Given Kullanici "surname"  alaninda tab tusuna basar
    Then Kullanici "surname" icin required uyarisini goruntuler

  Scenario Outline: TC05 Herhangi bir karakter iceren "Surname" olmalidir (Positive- en az 2 karakter)
    Given Kullanici Surname kutusuna "<surname>" girer
    Then Kullanici at least iki character uyarisini goruntulemez
    Examples:
      | surname            |
      | ka                 |
      | kaca               |

  Scenario Outline: TC06 Herhangi bir karakter iceren "Surname" olmalidir (Negative - 1 karakter)
    Given Kullanici Surname kutusuna "<surname>" girer
    Given Kullanici surname disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici at least iki character uyarisini goruntuler
    Examples:
      | surname  |
      | k        |

  Scenario: TC07 Birth place bos birakilamamalidir
    Given Kullanici "birth place"   alaninda tab tusuna basar
    Then Kullanici "birth place" icin required uyarisini goruntuler

  Scenario Outline: TC08 Herhangi bir karakter iceren "Birth place" olmalidir (Positive- en az 2 karakter)
    Given Kullanici Birth place kutusuna "<birthplace>" girer
    Then Kullanici at least iki character uyarisini goruntulemez
    Examples:
      | birthplace         |
      | bc                 |
      | bese               |

  Scenario Outline: TC09 Herhangi bir karakter iceren "Birth place" olmalidir (Negative - 1 karakter)
    Given Kullanici Birth place kutusuna "<birthplace>" girer
    Given Kullanici birth place disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici at least iki character uyarisini goruntuler
    Examples:
      | birthplace  |
      | s           |

  Scenario Outline: TC10 Kullanici telefon numarasini girebilmelidir. (Positive- istenen karakterleri (XXX-XXX-XXXX) iceren)
    Given Kullanici Phone Number kutusuna "<phone>" girer
    Then Kullanici enter valid phone number uyarisini goruntulemez
    Examples:
      | phone        |
      | 357-357-1811 |
      | 357 357 1811 |

  Scenario Outline: TC11 Kullanici telefon numarasini girebilmelidir. (Negative1 - istenen karakterleri (XXX-XXX-XXXX) icermeyen)
    Given Kullanici Phone Number kutusuna "<phone>" girer
    Given Kullanici phone number disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici exact oniki character uyarisini goruntuler
    Examples:
      | phone           |
      | 1256-953-345647 |

  Scenario Outline: TC12 Kullanici telefon numarasini girebilmelidir. (Negative2 - toplam 12 karakterden az)
    Given Kullanici Phone Number kutusuna "<phone>" girer
    Given Kullanici phone number disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici minumum 12 character uyarisini goruntuler
    Examples:
      | phone          |
      | 364 369 265    |

  Scenario: TC13  Kullanici cinsiyetini secebilmelidir.(Gender)
    Then Kullanici Gender radio butonlarindan gender secer

  Scenario Outline: TC14 Kullanici dogum tarihini girebilmelidir. (Positive- gecmis tarihli)
    Given Kullanici Date Of Birth kutusuna "<dateofbirth>" girer
    Then kullanici gecmis tarih olmali uyarisini goruntulemez
    Examples:
      | dateofbirth  |
      | 28.12.2001   |

  Scenario Outline: TC15 Kullanici dogum tarihini girebilmelidir. (Negative - gelecek tarihli)
    Given Kullanici Date Of Birth kutusuna "<dateofbirth>" girer
    Given Kullanici date of birth disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then kullanici gecmis tarih olmali uyarisini goruntuler
    Examples:
      | dateofbirth  |
      | 01.01.2042   |

  Scenario: TC16 SSN bos birakilamamalidir
    Given Kullanici  "SSN" alaninda tab tusuna basar
    Then Kullanici "SSN" icin required uyarisini goruntuler

  Scenario Outline: TC17 SSN girilmelidir. SSN; 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan  olusmalidir. (Positive- istenen sekilde (XXX-XXX-XXXX) 9 karakterli)
    Given Kullanici SSN kutusuna "<SSN>" girer
    Then Kullanici enter valid SSN number alertini goruntulemez
    Examples:
      | SSN         |
      | 672-56-1258 |

  Scenario Outline: TC18 SSN girilmelidir. SSN; 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan  olusmalidir. (Negative1 - istenen sekilde (XXX-XXX-XXXX) veya 9 karakterli degil)
    Given Kullanici SSN kutusuna "<SSN>" girer
    Given Kullanici SSN disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici please enter valid SSN number alertini goruntuler
    Examples:
      | SSN           |
      | 352-65-58700  |
      | abc-ab-uvyz   |
      | 352-65-587a   |
      | 352-65-587/   |
      | 352+65-5870   |
      | 352-65+5870   |
      | 35265-5870-   |

  Scenario Outline: TC19 SSN girilmelidir. SSN; 3. ve 5. rakamdan sonra "-" icermeli ve 9 rakamdan  olusmalidir. (Negative2 - toplam 11 karakterli degil)
    Given Kullanici SSN kutusuna "<SSN>" girer
    Given Kullanici SSN disindaki tum alanlara valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici minimum onbir character alertini goruntuler
    Examples:
      | SSN           |
      | 35265-5870    |
      | 352-655870    |

  Scenario: TC20 User Name bos birakilamamalidir
    Given Kullanici   "username" alaninda tab tusuna basar
    Then Kullanici "username" icin required uyarisini goruntuler

  Scenario Outline: TC21 User Name girilmelidir. (Positive- en az 4 karakter)
    Given Kullanici User Name kutusuna "<username>" girer
    Then Kullanici at least dort character uyarisini goruntulemez
    Examples:
      | username  |
      | alpr      |

  Scenario Outline: TC22 User Name girilmelidir. (Negative - en az 4 karakter degil)
    Given Kullanici User Name kutusuna "<username>" girer
    Given Kullanici user name disindaki alanlar icin valid deger girer
    Then Kullanici register butonuna tiklar
    Then Kullanici at least dort character uyarisini goruntuler
    Examples:
      | username  |
      | prl       |

  Scenario: TC23 Password bos birakilamamalidir
    Given Kullanici"password" alaninda tab tusuna basar
    Then Kullanici "password" icin required uyarisini goruntuler

  Scenario Outline: TC24 Password girilmelidir.  Password (buyuk harf, kucuk harf ve bir rakam iceren) en az 8 karakterden olusmalidir. (Positive- istenen ozelliklerde)
    Given Kullanici Password kutusuna "<password>" girer
    Given Kullanici password disindaki alanlar icin valid deger girer
    Then Kullanici username icin valid deger girer
    And Kullanici register butonuna tiklar
    And Kullanici guest user registered mesajini gorerek basarili kayit yapabildigini dogrular
    Examples:
      | password |
      | Ak425678 |

  Scenario Outline: TC25 Password girilmelidir. Password (buyuk harf, kucuk harf ve bir rakam iceren) en az 8 karakterden olusmalidir. (Negative1 - en az 8 karakter degil)
    Given Kullanici Password kutusuna "<password>" girer
    Given Kullanici password disindaki alanlar icin valid deger girer
    Then Kullanici username icin valid deger girer
    And Kullanici register butonuna tiklar
    And Kullanici minimum sekiz karakter uyarisini goruntuler
    Examples:
      | password |
      | Ak42567  |

  Scenario Outline: TC26 Password girilmelidir. Password (buyuk harf, kucuk harf ve bir rakam iceren) en az 8 karakterden olusmalidir. (Negative2 - istenen ozelliklerde degil)
    Given Kullanici Password kutusuna "<password>" girer
    Given Kullanici password disindaki alanlar icin valid deger girer
    Then Kullanici username icin valid deger girer

    And Kullanici register butonuna tiklar

    And Kullanici guest user registered mesajini gormeyerek basarili kayit yapamadigini dogrular
    Examples:
      | password |
      | KNKNKNKN |
      | ngngngng |
      | 12345678 |
      | KNKNngng |
      | ngng6789 |
      | KNKN6789 |

  Scenario: TC 27 US01 Aday ogrenciler sisteme kayit olabilmelidir.(Happy Scenario for all)
    Then Kullanici user name disindaki alanlar icin valid deger girer
    Then Kullanici username icin valid deger girer
    Then Kullanici register butonuna tiklar
    And Kullanici guest user registered mesajini gorerek basarili kayit yapabildigini dogrular
