#Author: Anoop A S

@chrome
Feature: Create an insurance quote
  
  
Scenario: Login to BharatiAxa website and create a quote
					Given User is on the BharatiAxa HomePage
					When User clicks on Get a Quote link
					Then User switch to new tab and fill FirstName, LastName and Mobile Number
					Then User Click on Next Button
					Then User Fills Email Address, DOB and Pin Code
					Then User Click on Next Button
					Then User Select Buying For Option
					Then User Click on Next Button
					Then User Click on How to Receive Benefit Option
					Then User Click on Next Button
					Then User Click on Next Button
					Then User Click on Next Button
					Then User Gets QuoteNumber Displayed on the screen
					Then User Closes Current Window
				

