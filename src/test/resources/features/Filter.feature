Feature: Do filtering and verify functionality of radio,checkbox and dropdown


  Scenario Outline: Verify user can filter by gender
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user wants to filter by "<filters>"
    Then verify filter is applied
    Examples:
      | filters |
#      | 10      |
      | men     |


  Scenario: Verify user can remove filters
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user wants to filter by "men"
    Then verify filter is applied
#    When user removes filter
#    Then verify filter is removed