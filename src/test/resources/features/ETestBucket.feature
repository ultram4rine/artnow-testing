Feature: Test bucket is working

  Scenario: Add first art from jewerly and check the art is in the bucket
    When user goes to the jewerly
    When user goes to the first art
    When user adds first art to the bucket
    When user goes to the bucket
    Then art presented in the bucket
