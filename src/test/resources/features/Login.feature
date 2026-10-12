Feature: ValidLogin

@Login
Scenario: Verify Login with Valid Credential

  Given Data Set for the Scenario "ValidLogin"
  And User launches the webapplication
  When User enters the username
  And User enters the password
  And User clicks on the login button
  Then User should navigate to the Home Page
  
@Login
Scenario: Verify Login with InValid Password

  Given Data Set for the Scenario "InvalidPassword"
  And User launches the webapplication
  When User enters the username
  And User enters the password
  And User clicks on the login button
  Then User should see invalid password error
  

