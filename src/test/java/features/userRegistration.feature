Feature: User Registration
I want to check that user can register to our website successfully
Scenario Outline:: User Registeration
Given User is on HomePage
When User clicks on register Link
And User enters these data "<firstName>","<lastName>","<email>","<password>" 
Then Registration page is displayed successfully

Examples:
|firstName|lastName|email|password|
|Amira|Amin|amiraamin@yahoo.com|1223456|
|Adel|Amin|adelamin@yahoo.com|1223456|

