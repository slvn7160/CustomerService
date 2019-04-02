Feature: the day of the week can be retrieved

  Scenario: client makes call to GET /dayOfTheWeek
    Given the month as 6
    And the day as 6
    And the year as 2018
    When the client calls /dayOfTheWeek
    Then the client receives a valid response
    And the response has the status code 200
    And the response contains day of the week as WEDNESDAY

