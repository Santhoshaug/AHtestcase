Feature: Home page details
I want to fetch the home page details

Background:
    Given I am on the AH website
    When AHEnter the URL "https://address-health-revamp-git-dev-v2-zysktech.vercel.app/login"
    And AHI enter Username and Password
      | 7019290364 | test1234 |
    And AHClick on login button
    And AHUser must successfully login to the web page

    #Automated Case ID: TC_ID - Customer#1
    @Test1 
      Scenario: AHHome page
      Given AHNurse name
      Then  AHSelect Mysore infirmary
      When AHcomplaint count
      And AHMinimum stocks
      Then AHcomplaint created 
      And AHComplaint completed
      And AHCT referrals
      
      #Automated Case ID: TC_ID - Customer#2
     @Test2
     Scenario: AH Complaint details
     Then AHIn_progress complaints
     And AHCT_referrals complaints
     And AHExpiring stocks
     And AHExpired stocks
     And AHMinimum supply stock
     Then AHImportant contacts1
     Then AHImportant contacts2
     Then AHtear down browser
     
      #Automated Case ID: TC_ID - Customer#2
      @Test3
      Scenario: Complaint page Completed complaint details
      And navigate to complaint page
      Then click on completed complaint
      And fetch all complaint
      