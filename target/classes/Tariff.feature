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
@tag
Feature: Add Tariff plan
  

  @tag1
  Scenario: Enter the rental charges
    Given the user is in  guru demo page
    And he clicks Add Tariff button 
    When the user enters required details
    |mRental|300|
    |freeLoc|100|
    |freeInt|50|
    |freeSms|100|
    |locChg|1|
    |intChg|10|
    |smsChg|10|
    And clicks the submit button
    
    Then a congratulation message is displayed
    

  