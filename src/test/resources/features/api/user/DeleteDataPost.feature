Feature: Delete post data
  As a admin
  I can delete post data
  So that the post data is removed from the system

  Scenario: As an admin, I can successfully delete a post
    Given I set API endpoint for delete data with ID
    When I send a DELETE request to the endpoint with a valid ID
    Then I receive a successful response status code 200
    And the post data is no longer retrievable using a GET request with the same ID