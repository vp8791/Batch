Feature:  Adding numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to add numbers using a Calculator
  
  Scenario Outline:  Add two positive numbers
    Given I have a Calculator
    When I add <firstNumber> and <secondNumber>
    Then the sum should be <sum>

  Examples:
    | firstNumber | secondNumber | sum  |
    |  12   	  |	    5  		 |  17   |
	
	