Feature: Free CRM create contacts

@Regression  @E2E
Scenario Outline: Create 5 contacts
Given The User is on login page
	When the title of login page is CRM PRO
	Then user enters details "<username>" and "<password>"
	And the user clicks on login button
	And user is already in homepage
	Then user enter click on add contact
	Then user enters contact details "<firstname>" and "<lastname>"
	Then user close the browser
	Examples:
	|username|password|firstname|lastname|
	|batchautomation|Test@12345|batch|automation|
	|tom|test@12345|tom|jack|
	
@Regression	@E2E
	#without examples keyword-regular expression
Scenario: Verify the login test functionality 
	Given User is on login
	When title of login page is CRM PRO
	Then user enters "batchautomation" and "Test@12345"
	And user clicks on login button
	And user is in homepage
	Then close the browser