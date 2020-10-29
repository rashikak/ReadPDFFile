Feature: Verify the login functionality 

#without examples keyword-regular expression
#Scenario: Verify the login test functionality 
#	Given User is on login
#	When title of login page is CRM PRO
#	Then user enters "batchautomation" and "Test@12345"
#	And user clicks on login button
#	And user is in homepage
#	Then close the browser

	
#with examples keyword-
Scenario Outline: Verify the login test functionality 
	Given User is on login
	When title of login page is CRM PRO
	Then user enters "<username>" and "<password>"
	And user clicks on login button
	And user is in homepage
	Then close the browser
	
Examples:

	| username | password|
	|batchautomation|Test@12345|
	|tom|test@12345|