$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featurefolder/demotours.feature");
formatter.feature({
  "line": 2,
  "name": "Demotours Login Functionality",
  "description": "",
  "id": "demotours-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "line": 5,
  "name": "Login with valid credentials",
  "description": "",
  "id": "demotours-login-functionality;login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "Open the browser and pass the URL",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "Navigate to the Login Page",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "Enter the valid userid and password",
  "keyword": "When "
});
formatter.step({
  "line": 9,
  "name": "Signout button should be available",
  "keyword": "Then "
});
formatter.match({
  "location": "DemoLoginStepDef1.open_the_browser_and_pass_the_URL()"
});
formatter.result({
  "duration": 20924287555,
  "status": "passed"
});
formatter.match({
  "location": "DemoLoginStepDef1.navigate_to_the_Login_Page()"
});
formatter.result({
  "duration": 1343496015,
  "status": "passed"
});
formatter.match({
  "location": "DemoLoginStepDef1.enter_the_valid_userid_and_password()"
});
formatter.result({
  "duration": 199921147,
  "status": "passed"
});
formatter.match({
  "location": "DemoLoginStepDef1.signout_button_should_be_available()"
});
formatter.result({
  "duration": 170296380,
  "status": "passed"
});
});