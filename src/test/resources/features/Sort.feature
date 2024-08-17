Feature: Sort thr product

  Scenario: Verify user can sort the product price from high to low
    Given user opens website
    Then verify home page is displayed
    When user search for a product
    And user sort the price from high to low
    Then verify the product is sorted successfully


  Scenario: Verify user can sort the product price from low to high
    Given user opens website
    Then verify home page is displayed
    When user search for a product
    And user sort the price from low to high
    Then verify the product is sorted successfully