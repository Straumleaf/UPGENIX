Feature: UPGENIX app logout feature
  User story:
  Users should be able to log out

  Background: for the scenario for this feature file, user is expected to be on the user home page (Inbox)
    Given user is on the UPGENIX Inbox page

  @UPG10-318 @logout @smoke
  Scenario: User can log out and ends up in login page
    Then user clicks on username and choose Log out option
    Then user is on the Login page and see "Sign in" option in top right conner

  @UPG10-319 @logout @smoke
  Scenario: Verifying user can not go to the home page again by clicking the step back button
    When user clicks on username and choose Log out option
    And user is on the Login page and see "Sign in" option in top right conner
    And user clicks the browser step back button
    Then user should see the message "Your Odoo session expired. Please refresh the current web page."

  @UPG10-320 @logout
  Scenario: The user must be logged out if the user closes the opened tab
    When user is on the Inbox page
    And user closes the active web tab
    And user open home page again
    And user is on the Login page and see "Sign in" option in top right conner


