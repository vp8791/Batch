Feature:  Multiplying numbers with a Calculator
  In order to not learn math
  As someone who is bad at math
  I want to be able to Multiply numbers using a Calculator
  
  Scenario Outline:  Multiply two positive numbers
    Given I have a Calculator
    When I Multiply <firstNumber> and <secondNumber>
    Then the Multiplication  amount should be <multiplicationAmount>

  Examples:
    | firstNumber | secondNumber | multiplicationAmount  |
    | 2           | 3            | 6                     |
    |5            | 6            | 30                    |
    | 10          | 10           | 100                   |