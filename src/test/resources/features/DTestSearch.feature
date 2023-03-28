Feature: Test search is working

  Scenario: Search for giraffe and check the results
    When user searches for giraffe
    When user goes to the first result
    Then art name contains giraffe
