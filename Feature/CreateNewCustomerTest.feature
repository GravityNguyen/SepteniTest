
Feature: I want to test register new account function

  Background: User goes to the Create New Customer page
    Given User opens "http://live.guru99.com/index.php/customer/account/login/" using "firefox"
    And User clicks on Create An Account button
    And User stays at "Create New Customer Account" page

  Scenario Outline: Create a valid account
    When User fills the "<firstname>" and "<lastname>" name fields
    And User fills the register email
    And User fills the "<password>" and "<confirmation>" password fields
    And Uset sets the subcriber to "<issubcriber>" value
    And User clicks on Register button
    Then User is redirected to "My Account" page
    And User see welcome message
    And User see the message that "<message>"
    Examples: 
      | firstname  | lastname  | password      | confirmation  |issubcriber | message |
      | Account    | AT Test   |  | validpassword | true       | You are currently subscribed to 'General Subscription'.  |
      | Account    | AT Test   | validpassword | validpassword | false      | You are currently not subscribed to any newsletter.      |  
  Scenario Outline: Create an invalid account
    When User fills the "<firstname>" and "<lastname>" name fields
    And User fills the "<email>" into the email field
    And User fills the "<password>" and "<confirmation>" password fields
    And User clicks on Register button
    Then User receives error message "<message>" at "<location>"
       Examples: 
      | firstname | lastname  | email                   |password      | confirmation  |message | location  |
      | Existing  | Email     | existingemail@email.com |validpassword | validpassword | There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account. |xpath=//*[@class='error-msg']/ul/li/span |
      | ELastname |           | avalidemail@email.com   |validpassword | validpassword | This is a required field. | id=advice-required-entry-lastname  |
      |           | EFirstname| avalidemail@email.com   |validpassword | validpassword | This is a required field. | id=advice-required-entry-firstname |
      | Empty     | Email     |                         |validpassword | validpassword | This is a required field. | id=advice-required-entry-email_address |
      | Empty     | Password  | avalidemail@email.com   |              | validpassword | This is a required field. | id=advice-required-entry-password |
      | Empty     | ConfirmPwd| avalidemail@email.com   |validpassword |               | This is a required field. | id=advice-required-entry-confirmation|
      | Invalid   | Email     | invalidemail@email      |validpassword | validpassword | Please enter a valid email address. For example johndoe@domain.com. | id=advice-validate-email-email_address |
      | Invalid   | Password  | avalidemail@email.com   |pwd           | validpassword | Please enter 6 or more characters. Leading or trailing spaces will be ignored. | id=advice-validate-password-password |
      | NotMatch  | ConfirmPwd| avalidemail@email.com   |validpassword | pwd           | Please make sure your passwords match. | id=advice-validate-cpassword-confirmation |