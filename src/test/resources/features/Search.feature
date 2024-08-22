Feature: Search a product

  Scenario: Verify user can search a product
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed

  Scenario: Verify next and previous button working
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user clicks on next button
    Then verify next page is displayed
    When user clicks previous button
    Then verify previous page is displayed


