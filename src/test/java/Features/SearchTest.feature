Feature: Arabam.com test cases

  Background:
    Given Navigate to the website

    Scenario Outline: Daica Arama testi
      And son yirmi dort saat linkine tıkla
      Then Otomobil linkine tıkla
      And Dacia markayı sec
      Then model  sec
      And Minimum fiyat belirle "<minimumFiyat>"
      Then verify thet the filters are applied
      And get the filtered list of cars "<minimumFiyat>"
      Examples:
        | minimumFiyat |
        |250000        |
        |400000        |


      Scenario: Register test
        And Uye ol linkine tıkla
        Then fill in the register form
        |firstname|lastname|05534567623|Password123|
        And click the check boxes and hit the registerButton
        Then verify that confirmation phone number button is visible




















