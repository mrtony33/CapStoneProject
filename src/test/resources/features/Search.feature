Feature: Search a product

  Scenario: Verify user can search a product
    Given user opens the website
    Then verify home page is displayed
    When user search for ""
    Then verify the searched product is displayed