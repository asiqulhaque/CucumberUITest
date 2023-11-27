Feature: Treatment Experience in Orlando Hospital

  @myTest
  Scenario: The User opens Hospital Home Page
    Given User Launches Chrome Browser
    When user visit Orlando Hospital and click on Find a Doctor
    Then User will be able to land Doctor Search page

  @myTest
  Scenario: The User Make an appointment to visit
    Given User Launches Chrome Browser
    When User click Appointment Tab
    And User click Request a Call back
    And User Fill required info and click submit
    Then User will get a success Message for an appointment
