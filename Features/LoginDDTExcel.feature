Feature: Login DataDriven with Excel
Scenario Outline: Login TestData with Excel
Given User Launch Browser
And Opens URL "http://flights.qedgetech.com/"
Then Check User navigates to MyAccountPage by passing Email and Password with excel row "<row_index>"

Examples:
|row_index|
|1|
|2|
|3|

