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

    #to implement android
  Scenario: Verify cart price for multiple items
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    When user adds first "3" elements to cart
    And go to cart page
    Then verify the price in the cart page


  Scenario: Verify size selector functionality
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    When user select available sizes
    Then verify all sizes are added to cart


  Scenario: Verify donate option is working in checkout
    Given user opens website
    When user search for "shirt"
    Then verify search results is not empty
    And click on the first result
    Then verify product page is displayed
    When user clicks add to cart button
    Then verify that item is added to cart
    When user select donate option
    Then verify donation amount is added to price