Feature: Navigation link features

  Scenario Outline: Verify the working of navigation bar
    Given user opens website
    Then verify home page is displayed
    When user clicks on a "<navigation>" link
    Then verify page is navigated to respective "<navigation>" link
    Examples:
      | navigation  |
      |   men       |
      |   women     |
      |   kids      |
      |   studio    |