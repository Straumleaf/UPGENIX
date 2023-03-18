
Feature: UPGENIX app login feature
  User story:
  Users can log in with valid credentials (We have 5 types of users
  but will test only 2 user: posmanager75, salesmanager75

  Background: for the scenario for this feature file, user is expected to be on the login page
    Given user is on the UPGENIX login page

  @done @UPG10-250
  Scenario Outline:  Login functionality verification
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on the Login button
    Then user is on the Inbox page

    Examples: users valid credentials to be use in this scenario
      | username                | password     |
      | salesmanager75@info.com | salesmanager |
      | salesmanager57@info.com | salesmanager |
      | posmanager75@info.com   | posmanager   |
      | posmanager57@info.com   | posmanager   |

  @done @UPG10-251
  Scenario Outline: "Wrong login/password" message should be displayed for
                    valid username and invalid password
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on the Login button
    Then user should see Wrong login or password message

    Examples:
      | username                | password     |
      | salesmanager75@info.com | Salesmanager |
      | salesmanager57@info.com | salesManager |
      | posmanager75@info.com   | Posmanager   |
      | posmanager57@info.com   | posManager   |

  @done @UPG10-252
  Scenario Outline: "Wrong login/password" message should be displayed for
                    invalid username and valid password
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on the Login button
    Then user should see Wrong login or password message

    Examples:
      | username                  | password     |
      | wrongName@info.com        | salesmanager |
      | salesmanager250@info.com  | salesmanager |
      | posmanager100500@info.com | posmanager   |
      | 1409809184@info.com       | posmanager   |

  @done @@UPG10-253
  Scenario Outline: "Please fill out this field" notification message should be displayed
                    in absence of user
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on the Login button
    Then user should get - (Please fill out this field.) warning message

    Examples:
      | username | password     |
      |          | salesmanager |
      |          | posmanager   |

  @done @UPG10-254
  Scenario Outline: "Please fill out this field" notification message should be displayed
                    in absence of password
    When user enters username "<username>"
    And user enters password "<password>"
    And user clicks on the Login button
    Then user should get - (Please fill out this field.) warning message

    Examples:
      | username                | password |
      | salesmanager75@info.com |          |
      | posmanager75@info.com   |          |

  @done @UPG10-255
  Scenario: User should see bullet signs instead of actual password characters
    When user "posmanager75@info.com" enters password "posmanager"
    Then user should see the password in bullet signs by default

  @wip @UPG10-257
  Scenario: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.
    When user "posmanager75@info.com" enters password "posmanager"
    And press (Enter) key
    Then user is on the Inbox page


