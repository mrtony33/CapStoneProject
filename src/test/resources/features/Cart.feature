Feature: Cart Features
  Scenario: Verify user can use add to cart functionality
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    When user clicks add to cart button
    Then verify that item is added to cart


