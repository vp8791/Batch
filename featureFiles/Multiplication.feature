Feature:  Multiplying numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to Multiply numbers using a Calculator
  
  Scenario:  Multiply two positive numbers
    Given I have a Calculator
    When I Multiply <firstNumber> and <secondNumber>
    Then the Multiplication  amount should be <multiplicationAmount>

  Examples:
    | firstNumber | secondNumber | multiplicationAmount  |
    |  12   	  |	    5  		 |  		60   	     |
	