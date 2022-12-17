Feature: AH -Login Feature

  Scenario: Address health Log-in with valid username and password
  Given Open the browser
  When Enter the URL "https://address-health-revamp-git-dev-v2-zysktech.vercel.app/login"
  And I enter Username and Password
  | 7019290365 | test1234 |
  And Click on login button
  Then User must successfully login to the web page

  