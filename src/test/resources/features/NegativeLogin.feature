Feature: NegativeLogin

@NegativeLogin
Scenario: Verify Negative Scenarios Of Login

  Given Data Set for the Scenario "ValidLogin"
  And User launches the webapplication
  When User enters the username
  And User enters the password
  And User clicks on the login button
  Then User should not navigate to the Home Page

  Scenario: Verify Negative Scenarios Of Login Two

  Given Data Set for the Scenario "ValidLogin"
  And User launches the webapplication
  When User enters the username
  And User enters the password
  And User clicks on the login button
  Then User should not navigate to the Home Page
  