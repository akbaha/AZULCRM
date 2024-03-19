@wip
Feature: Users should be able to login
  User Story:
  As a user, I should be able to login.
  Users: HR user, Marketing user, Helpdesk user

  Background: User is already in the log in page
    Given the user is on the login page

@login
  Scenario Outline: Verify login with different user types
    Given the user logged in as "<user type>"
   # Given the user logged in with username as "<username>" and password as "<password>"
    Then user land on base page

    Examples:
      | user type      |
      | Helpdesk user  |
      | Marketing user |
      | HR user        |













