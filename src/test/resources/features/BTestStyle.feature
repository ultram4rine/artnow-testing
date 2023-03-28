Feature: Check art style

  Scenario: Check tram way art style is reality
    When again user goes to category Embroidered pictures
    When again user goes to genre City landscape
    When user goes to art Tram way
    Then art Tram way style is reality
