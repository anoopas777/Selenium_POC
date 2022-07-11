$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/ContactUS.feature");
formatter.feature({
  "line": 3,
  "name": "Contact Us Feature",
  "description": "",
  "id": "contact-us-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@ContactUSPage"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Contact Us scenario with different set of data",
  "description": "",
  "id": "contact-us-feature;contact-us-scenario-with-different-set-of-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user navigates to contact us page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user fills the form from given sheetname \"\u003cSheetName\u003e\" and rownumber \u003cRowNumber\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user clicks on send button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "it shows a successful message \"Your message has been successfully sent to our team.\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "contact-us-feature;contact-us-scenario-with-different-set-of-data;",
  "rows": [
    {
      "cells": [
        "SheetName",
        "RowNumber"
      ],
      "line": 12,
      "id": "contact-us-feature;contact-us-scenario-with-different-set-of-data;;1"
    },
    {
      "cells": [
        "Contactus",
        "0"
      ],
      "line": 13,
      "id": "contact-us-feature;contact-us-scenario-with-different-set-of-data;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Contact Us scenario with different set of data",
  "description": "",
  "id": "contact-us-feature;contact-us-scenario-with-different-set-of-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@ContactUSPage"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user navigates to contact us page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user fills the form from given sheetname \"Contactus\" and rownumber 0",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "user clicks on send button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "it shows a successful message \"Your message has been successfully sent to our team.\"",
  "keyword": "Then "
});
formatter.match({
  "location": "ContactUs.user_navigates_to_contact_us_page()"
});
formatter.result({
  "duration": 8701277300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Contactus",
      "offset": 42
    },
    {
      "val": "0",
      "offset": 67
    }
  ],
  "location": "ContactUs.user_fills_the_form_from_given_sheetname_and_rownumber(String,Integer)"
});
formatter.result({
  "duration": 2004056100,
  "status": "passed"
});
formatter.match({
  "location": "ContactUs.user_clicks_on_send_button()"
});
formatter.result({
  "duration": 4649231100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Your message has been successfully sent to our team.",
      "offset": 31
    }
  ],
  "location": "ContactUs.it_shows_a_successful_message(String)"
});
formatter.result({
  "duration": 38002500,
  "status": "passed"
});
});