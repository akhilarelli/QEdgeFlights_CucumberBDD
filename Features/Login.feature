Feature: Login with valid credentials

#comments should be with hash#
#Scenario 1
@sanity
Scenario: Successful login with Valid credentials

#preconditions are declared using 'Given' and as it has multiple conditions they are splitted by 'And'
Given User Launch Browser
And Opens URL "http://flights.qedgetech.com/"

#Actions are declared using 'When' and as there are multiple actions those are are splitted by 'And'
		
		When User enters Email as "akhilarelli55@gmail.com" and Password as "akhil123"
		And click on Login button
		
#Validations are declared by 'Then' keyword
		Then User navigates to MyAccountPage
