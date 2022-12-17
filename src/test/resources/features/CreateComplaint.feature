
@tag
Feature: Address Health complaint creation
  Giddiness complaint creation

  @tag1
  Scenario: Creating Giddiness complaint
Given setBrowser 
And Enter the AH URL "https://address-health-revamp-git-dev-v2-zysktech.vercel.app/login"
And I enter Username and Password AH
    | 7019290364 | test1234 |
And Click on login button AH
#And User must successfully login to the web page AH
Then complaint page AH
#And selecting student
And selcting complaint dropdown
And selecting other complaints
And selecting outcome
And click on treatment
And selecting ct referral
And selecting advice
Then selecting permission
And entering duration
And entering notes in the notes field
Then click on save and monitor

#When selecting examination finding
#And selcting Description check list group
#And selecting the medicine