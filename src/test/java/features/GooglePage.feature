@StoryId @FERegression @FESanity @Regression @Sanity
Feature: Verify Google page
  As a user, I want to verify elements in google page.

  @TC1
  Scenario Outline: Verify that Google Setting word has the correct text
    Given I open google website
    When I set "<language>"
    Then I should see Google Setting word has the correct text
    Examples:
      | language |
      | English  |
      | العربية  |

  @TC2
  Scenario: Verify that Google website has the correct title
    Given I open google website
    When I set "<language>"
    Then I should see Google title has the correct text