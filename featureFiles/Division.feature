Feature:  Dividing numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to Divide numbers using a Calculator
  
  Scenario Outline:  Divide two positive numbers
    Given I have a Calculator
    When I Divide <firstNumber> and <secondNumber>
    Then the Division  amount should be <divisionAmount>

  Examples:
    | firstNumber | secondNumber | divisionAmount  |
    |  12   	  |	    3  	 |  		4  |
    |  15 	  |	    5  	 |  		3  |
    |  18   	  |	   9 	 |  		2 |
    |  20	  |	   10 	 |  		2  |

	