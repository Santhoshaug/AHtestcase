Feature: Mysore Infirmary Deatils

@test1
Scenario: Navigate to Mysore Infirmary
Given set browser
Given I enter the Username and Password
 | 7019290364 | test1234 |
And Nurse name
Then  Select Mysore infirmary
When complaint count
And Minimum stocks
Then complaint created 
And Complaint completed
And CT referrals
Then In_progress complaints
And CT_referrals complaints
And Expiring stocks
And Expired stocks
And Minimum supply stock
Then Important contacts1
Then Important contacts2
Then tear down browser

#Scenario: Create Giddiness complaint
#Given Navigate to complaint page
#And capture date and time
#When select Giddiness complaint from complaint dropdown
#And write notes
#And Select outcome checkbox
#And Select treatment
#When select examination findings
#And click on advice
#And get permission
#And select medicines
#When click on Description
#Then select student from searchable dropdown
#And click on create

