Feature: Test bucket is working

  Scenario: Add first N arts from jewerly and check the art is in the bucket
    When user goes to the jewerly
    When user adds first <number> arts to the bucket
    When user goes to the bucket
    Then arts presented in the bucket

    Examples: 
      | number |
      |      3 |
