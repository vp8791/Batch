Feature:  Substracting numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to Substract numbers using a Calculator
  
  Scenario:  Substract two positive numbers
    Given I have a Calculator
    When I substract <firstNumber> and <secondNumber>
    Then the substraction amount should be <substractionAmount>

  Examples:
    | firstNumber | secondNumber | substractionAmount  |
    |  12   	  |	    5  		 |  		7   	   |
	
	