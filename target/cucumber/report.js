$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/GetQuoteCreated.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Anoop A S"
    }
  ],
  "line": 4,
  "name": "Create an insurance quote",
  "description": "",
  "id": "create-an-insurance-quote",
  "keyword": "Feature",
  "tags": [
    {
      "line": 3,
      "name": "@chrome"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Login to BharatiAxa website and create a quote",
  "description": "",
  "id": "create-an-insurance-quote;login-to-bharatiaxa-website-and-create-a-quote",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User is on the BharatiAxa HomePage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "User clicks on Get a Quote link",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "User switch to new tab and fill FirstName, LastName and Mobile Number",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "User Click on Next Button",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User Fills Email Address, DOB and Pin Code",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User Click on Next Button",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "User Select Buying For Option",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "User Click on Next Button",
  "keyword": "Then "
});
formatter.step({
  "line": 16,
  "name": "User Click on How to Receive Benefit Option",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "User Click on Next Button",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "User Click on Next Button",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "User Click on Next Button",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "User Gets QuoteNumber Displayed on the screen",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "User Closes Current Window",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateQuoteSteps.user_is_on_the_BharatiAxa_HomePage()"
});
formatter.result({
  "duration": 7757853900,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_clicks_on_Get_a_Quote_link()"
});
formatter.result({
  "duration": 116318300,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_switch_to_new_tab_and_fill_FirstName_LastName_and_Mobile_Number()"
});
formatter.result({
  "duration": 2472265000,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_Next_Button()"
});
formatter.result({
  "duration": 3133904700,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Fills_Email_Address_DOB_and_Pin_Code()"
});
formatter.result({
  "duration": 2710730300,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_Next_Button()"
});
formatter.result({
  "duration": 3127818000,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Select_Buying_For_Option()"
});
formatter.result({
  "duration": 822995900,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_Next_Button()"
});
formatter.result({
  "duration": 3132623600,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_How_to_Receive_Benefit_Option()"
});
formatter.result({
  "duration": 3183491000,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_Next_Button()"
});
formatter.result({
  "duration": 3111839400,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_Next_Button()"
});
formatter.result({
  "duration": 3136846900,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Click_on_Next_Button()"
});
formatter.result({
  "duration": 3129953500,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Gets_QuoteNumber_Displayed_on_the_screen()"
});
formatter.result({
  "duration": 1353510700,
  "status": "passed"
});
formatter.match({
  "location": "CreateQuoteSteps.user_Closes_Current_Window()"
});
formatter.result({
  "duration": 498538000,
  "status": "passed"
});
});