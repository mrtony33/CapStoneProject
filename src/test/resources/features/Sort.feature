Feature: Sort the product

  Scenario: Verify user can sort the product price from high to low
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    And user sort the price from high to low
    Then verify the product is sorted from high to low


  Scenario: Verify user can sort the product price from low to high
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    And user sort the price from low to high
    Then verify the product is sorted from low to high