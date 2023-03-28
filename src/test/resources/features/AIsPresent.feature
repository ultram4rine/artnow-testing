Feature: Test art is present

  Scenario: Check tram way art is present
    When user goes to category Embroidered pictures
    When user goes to genre City landscape
    Then art Tram way is present
