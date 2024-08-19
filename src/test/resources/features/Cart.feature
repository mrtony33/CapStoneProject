Feature: Cart Features

  Scenario: Verify user can use add to cart functionality
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    When user clicks add to cart button
    Then verify that item is added to cart

  Scenario: Verify user can remove the product from the cart
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    When user clicks add to cart button
    Then verify that item is added to cart
    When user removes the item from the cart
    Then verify that item is removed from the cart

  Scenario: Verify cart price
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    And take the price on pdp page
    Then verify that item is added to cart
    And verify the price in the cart page






