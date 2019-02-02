Feature: Credit Card Number Validator
As a User
I want to  validate credit card number as per specifications  i.e all characters must be from 0-9 and16 Characters long
So that I don't need to validate by laoding file in landing zone and validate it

  Scenario Outline: Validate credit card number <creditCardNumber> and validation outcome is <ValidOrInvalid>
    Given I have  a credit card which is valid or invalid
     When I validate credit card number <creditCardNumber>
     Then the validation result should be should be <ValidOrInvalid>
  
    Examples: 
      | creditCardNumber | ValidOrInvalid | 
      | 3096400528639553 | true           | 
      | b                | false          | 
	  | 3096AAA528639553 | false          | 