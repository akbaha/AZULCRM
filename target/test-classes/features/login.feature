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

  @invalidLogin
  Scenario Outline: Login with invalid credential
    When user login with invalid "<invalidUsername>" and valid "<password>"
    When user login with valid "<username>" and invalid "<invalidPassword>"
    Then user should see Incorrect login or password error message

    Examples:

      | username             | invalidPassword | invalidUsername   | password |
      | helpdesk1@cydeo.com  | 123456          | helpdesk@cydeocom | UserUser |
      | hr1@cydeo.com        | 012345          | mrktng@cydeo.com  | UserUser |
      | marketing1@cydeo.com | lalala          | hrcydeo.com       | UserUser |


  @loginWithEmptyFields
  Scenario: Verify that the "Please fill out this field" error message is displayed if the password or username is empty.
    When user login with empty username and password
    When user login with empty password and username
    When user login both username and password is empty
    Then user should see Please fill out this field error message


    Scenario: Verify that the "Remember me on this computer" link exists and is clickable on the login page.
      Then Remember me on this computer link exists and is clickable on the login page


      Scenario: Verify that the password is in bullet signs by default.
        When user enter password in password area
        Then user should see the password in bullet signs












