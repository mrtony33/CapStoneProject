Feature: Do filtering and verify functionality of radio,checkbox and dropdown


  Scenario Outline: Verify user can filter by gender
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user wants to filter by "<filters>"
    Then verify gender filter is applied
    Examples:
      | filters |
      | women   |
      | men     |

  Scenario Outline: Verify user can filter by discount
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user wants to filter by "<filters>"
    Then verify discount filter is applied
    Examples:
      | filters |
      | 10      |
      | 50      |


  Scenario: Verify user can remove filters
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user wants to filter by "10"
    Then verify discount filter is applied
    When user removes filter
    Then verify filter is removed