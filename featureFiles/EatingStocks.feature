Feature: Eating Stock Checker
  Scenario Outline: Eating fruits vegetables
    Given There are <start> cucumbers
     When I eat <eat> cucumbers
     Then I should have <left> cucumbers
  
    Examples: 
      | start | eat | left | 
      | 12    | 5   | 7    | 
      | 20    | 5   | 15   | 
      | 16    | 3   | 13   | 
      | 18    | 4   | 14   | 
      | 19    | 3   | 16   | 
      | 23    | 3   | 20   | 
      | 25    | 5   | 20   | 
      | 30    | 5   | 25   | 
      | 12    | 5   | 7    |