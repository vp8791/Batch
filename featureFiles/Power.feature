Feature:  Power of  numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to find Power numbers using a Calculator
  
  Scenario:  Power two positive numbers
    Given I have a Calculator
    When I Power <firstNumber> and <secondNumber>
    Then the Power amount should be <powerAmount>

  Examples:
    | firstNumber | secondNumber | powerAmount  |
    |  3   	  |	    2  		 |  		9   	   |
	
	