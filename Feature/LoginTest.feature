Feature: I want to test login function

  Background: User open Login Page
    Given User opens "http://live.guru99.com/index.php/customer/account/login/" using "firefox"

  Scenario: Login with a valid credential
    And User stays at "Customer Login" page
    When User login with email "demoautotest@gmail.com" and password "demopassword"
    Then User is redirected to "My Account" page

  Scenario Outline: Login with icorrect username/password
    And User stays at "Customer Login" page
    When User login with email "<email>" and password "<password>"
    Then User receives error message "Invalid login or password."

    Examples: 
      | email                  | password          |
      | aninvalidemail@abc.com | aninvalidpassword |
      | demoautotest@gmail.com | aninvalidpassword |
      | aninvalidemail@abc.com | demopassword      |

  Scenario Outline: Login with an ivalid credential
    And User stays at "Customer Login" page
    When User login with email "<email>" and password "<password>"
    Then User receives error message "<message>" at "<location>"

    Examples: 
      | email                  | password     | message                                                                        | location                         |
      |                        | demopassword | This is a required field.                                                      | id=advice-required-entry-email   |
      | demoautotest@gmail.com |              | This is a required field.                                                      | id=advice-required-entry-pass    |
      | abc@abc                | demopassword | Please enter a valid email address. For example johndoe@domain.com.            | id=advice-validate-email-email   |
      | demoautotest@gmail.com | pwd          | Please enter 6 or more characters. Leading or trailing spaces will be ignored. | id=advice-validate-password-pass |
