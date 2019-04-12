Feature:  Adding numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to add numbers using a Calculator
  
  Scenario Outline:  Add two positive numbers
    Given I have a Calculator
    When I add <firstNumber> and <secondNumber>
    Then the sum should be <sum>

  Examples:
    | firstNumber | secondNumber         | sum   | 
    |  12   	  |	    5  		 |  17   |
    |  17   	  |	    5  		 |  22   |
    |  18   	  |	   2  		 |  20   |
    |  11   	  |	    5  		 |  16   |
    |  18   	  |	    3  		 |  21   |	
    |  19   	  |	    9 		 |  28   |
    |  144   	  |	   56  		 |  200  |
    |  130   	  |	    20		 |  150  |
    |  200   	  |	   100  	 |  300  |
    |  100  	  |	    20		 |  120  |
    |  580   	  |	   30   	 |  610  |