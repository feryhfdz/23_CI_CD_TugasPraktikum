Feature: Get data post by ID
  As a admin
  I want to retrieve post data by its ID
  So that I can view specific details of a post

  Scenario: Retrieve a single post by ID from the API
    Given I set API endpoint for get data with ID
    When I send a GET request to the endpoint with a valid ID
    Then I should receive the post data by ID

  Scenario: As an admin, I get an error response for an invalid post ID
    Given I set API endpoint for get data with ID
    When I send a GET request to the endpoint with an invalid ID
    Then I receive status code 404
    And I should receive a empty post data