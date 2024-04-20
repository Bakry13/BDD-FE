@APIRegression @Regression
Feature: Users API
  As a user I want to verify success of login api and its error responses
#==============================Success 200=================================
  @TC1
  Scenario: Check get success response for users api
    Given I request users api
    When I extract users response
    Then I assert on success status code
    And I should find users response has the correct length

  @TC2
  Scenario Outline: Check get success response for getting a specific users api
    Given I request users api
    When I extract users response
    Then I assert on success status code
    And I should find the correct "<title>" for 4th id
    Examples:
      | title  |
      | title4 |
#===============================post 201=============================
  @TC3
  Scenario Outline: Check get success response for users api
    Given I request post user api
    When I extract created users response
    Then I assert on post success status code
    And I should find the correct "<id>" for the created user
    Examples:
      | id  |
      | id1 |