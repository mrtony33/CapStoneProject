Feature: Product page features

  Scenario: Verify the product rating
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user clicks on the first product
    Then verify the product rating on product description page

  Scenario: Verify the average product rating
    Given user opens website
    Then verify home page is displayed
    When user search for "shoe"
    Then verify the searched product is displayed
    When user clicks on the first product
    And get the average rating based on the user review
    Then verify the average product rating is displayed correctly

   Scenario Outline: Verify customer review filtering
     Given user opens website
     Then verify home page is displayed
     When user search for "shoe"
     Then verify the searched product is displayed
     When user clicks on the first product
     And clicks on view all reviews
     And filter the reviews based on "<star>" rating
     Then verify that rating review is applied
     Examples:
        |star|
        |3   |
