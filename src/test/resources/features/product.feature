@source
Feature: Product Filtering and Cart Functionality

  Scenario: Sort products by Price Low to High
    Given I am on the Login page
    When  I login with standard user
    Then I am on the Swag Labs homepage
    When I select the "Price (low to high)" filter
    Then I should see the products sorted by price in ascending order

  Scenario: Sort products by Price High to Low
    Given I am on the Login page
    When  I login with standard user
    Then I am on the Swag Labs homepage
    When I select the "Price (high to low)" filter
    Then I should see the products sorted by price in descending order

  Scenario: Sort products by Name A to Z
    Given I am on the Login page
    When  I login with performanceUser user
    Then I am on the Swag Labs homepage
    When I select the "Name (A to Z)" filter
    Then I should see the products sorted by name in ascending order

  Scenario: Sort products by Name Z to A
    Given I am on the Login page
    When  I login with standard user
    Then I am on the Swag Labs homepage
    When I select the "Name (Z to A)" filter
    Then I should see the products sorted by name in descending order