Feature: Employee

  Scenario: Login
    Given the user enter to the page with userName and password
    Then the employee page is displayed
    And the session is closed

  Scenario Outline: Login
    Given the user enter to the page with <userName> and <password>
    Then the employee page is displayed
    And the session is closed
    Examples:
    |userName |  password |
    |boris    |  pasasdf  |
    |Juan     |  pasasdd  |
    |Diego    |  pasasdf  |

  Scenario Outline: Add employee
    Given the user enter to the page with <userName> and <password>
    When the user adds a new employee with <name>, <email>, <address>, <phone>
    Then the notification is displayed
    And the session is closed

    Examples:
    |name   |  email           |  address |   phone    |   userName   |   password |
    |name1  |  email@gmail.com |  address1|   75938911 |   Diego      |   password1|
    |name2  |  email@gmail.com |  address2|   70308964 |   Juan       |   password2|


