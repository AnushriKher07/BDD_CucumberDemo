Feature: Verify google search functionality
  I want to use this template for my feature file

  @tag1
  Scenario: Search bdd in google search box
    Given User launch browser
    When User enter Bdd in search box
    Then User click on Search button
    Then User close the browser
    