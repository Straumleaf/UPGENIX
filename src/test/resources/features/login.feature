Feature: UPGENIX app login feature
  User story:
  Users can log in with valid credentials (We have 5 types of users
  but will test only 2 user: posmanager75, salesmanager75)

  Background: for the scenario for this feature file, user is expected to be on the login page
    Given user is on the UPGENIX login page

  Scenario Outline:  Login functionality verification
    When user enters valid username "<username>"
    And user enters valid password "<password>"
    And user clicks on the Login button
    Then user is on the Inbox page

    Examples: users valid credentials to be use in this scenario
      | username                | password     |
      | salesmanager75@info.com | salesmanager |
      | salesmanager57@info.com | salesmanager |
      | posmanager75@info.com   | posmanager   |
      | posmanager57@info.com   | posmanager   |
