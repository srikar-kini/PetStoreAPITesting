Feature: PetStore API Testing

  Scenario: To display the count of available pets with name as "doggie"
    Given As a client application with wiremock option set to "false"
    When I perform a Get request to the endpoint "https://petstore.swagger.io/v2/pet/findByStatus?status=available"
    And query for the status as "available" with pet name as "doggie"
    Then the number of pets from the response should be equal to an expected value of 90