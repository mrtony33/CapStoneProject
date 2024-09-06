Feature: Sort the product

  Scenario: Verify user can sort the product price from high to low
    Given user opens website
    Then verify home page is displayed
    When user search for "shirt"
    And user sort the price from high to low
    Then verify the product is sorted from high to low

  Scenario: Verify user can sort the product price from low to high
    Given user opens website
    Then verify home page is displayed
    When user search for "shirt"
    And user sort the price from low to high
    Then verify the product is sorted from low to high

  Scenario: Verify user can sort the product based on customer rating
    Given user opens website
    Then verify home page is displayed
    When user search for "shirt"
    And user sort the product based on customer rating
    Then verify the product is sorted based on customer rating

  Scenario: Verify user can sort the product based on better discount
    Given user opens website
    Then verify home page is displayed
    When user search for "shirt"
    And user sort the product based on better discount
    Then verify the product is sorted based on better discount