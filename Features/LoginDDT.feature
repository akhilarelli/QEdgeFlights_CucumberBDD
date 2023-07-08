Feature: Login Data Drievn without Excel

  Scenario Outline: Login Test with Test Data
    Given User Launch Browser
    And Opens URL "http://flights.qedgetech.com/"
    When User enters Email as "<email>" and Password as "<password>"
    And click on Login button
    Then User navigates to MyAccountPage

    Examples: 
      | email                   | password   |
      | akhilarelli55@gmail.com | akhil123  |
      | admin@gmail.com         | admin123   |
      | nikhil555@gmail.com     | nikhil123  |
