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
	  | 12    | 3   | 9    |
	  | 17    | 5   | 12   |
	  | 28    | 5   | 23   |
	  | 100   | 10  | 90   |
	  | 100   | 20  | 80   |
	  | 100   | 30  | 70   |
	  | 100   | 40  | 60   |
	  | 100   | 50  | 50   |
	  | 100   | 60  | 40   |
	  | 100   | 30  | 70   |
	  | 100   | 90  | 10   |
	  | 100   | 90  | 10   |
	  | 100   | 60  | 40   |
	  | 100   | 80  | 20   |