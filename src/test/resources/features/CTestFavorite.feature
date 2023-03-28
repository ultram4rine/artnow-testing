Feature: Test favorite is working

  Scenario: Check art is added to favorites
    When user goes to category Batik
    When user adds first art to favorites
    Then favorites count is one
    When user goes to favorites
    Then art is in favorites
