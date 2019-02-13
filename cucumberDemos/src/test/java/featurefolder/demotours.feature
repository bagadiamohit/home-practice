@tag
Feature: Demotours Login Functionality

  @tag1
  Scenario: Login with valid credentials
    Given Open the browser and pass the URL
    And Navigate to the Login Page
    When Enter the valid userid and password
    Then Signout button should be available