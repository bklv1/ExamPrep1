Feature: Adding a t-shirt to the cart

  Scenario: User adds a t-shirt
    Given user enters clothes website
    When user selects T-shirts
    And user selects Faded Short Sleeve T-shirts and clicks Add to Cart
    Then verify there is 1 item in your cart