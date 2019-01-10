#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Add Customer

  @tag1
  Scenario: Giving Customer Details
    Given the user is in guru demo page
    And he clicks Add customer to redirect to Add customer page
    
    When the user fills the details 
    |first Name|siva|
    |last Name|subramani|
    |email|ssubramani11@gmail.com|
    |address|chennai|
    |phone|9791054371|
    
    And clicks the submit button
    
    Then a custome Id should be generated
    
    

    

