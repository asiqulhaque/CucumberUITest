Feature: Login to Application

  Background: The User opens login Page
    Given User Launches Chrome Browser
    When user opens facebook portal link
    Then User should see the page Title "Facebook - log in or sign up"

  Scenario Outline: Validating Login Functionality
    When User enters UserName as "<userName>" and Password as "<password>"
    Then User should see the Facebook Home Page on successful login status "<status>"

    Examples:
    | userName    | password    | status           |
    |  userName   | password    | Pass             |

