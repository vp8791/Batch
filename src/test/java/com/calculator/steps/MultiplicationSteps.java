package com.calculator.steps;

import com.utils.CalculatorOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.utils.Calculator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@RunWith(Cucumber.class)
public class MultiplicationSteps {

    Calculator calculator;

    @When("^I Multiply (.+) and (.+)$")
    public void i_multiply_and(String firstnumber, String secondnumber) throws Throwable {
        calculator = new Calculator(Double.parseDouble(firstnumber), Double.parseDouble(secondnumber), CalculatorOperations.MULTIPLICATION);
    }

    @Then("^the Multiplication  amount should be (.+)$")
    public void the_multiplication_amount_should_be(String multiplicationamount) throws Throwable {
        double actualResult = calculator.calculateResult();
        assertThat(actualResult, closeTo(Double.parseDouble(multiplicationamount), CalculatorOperations.ERROR));

    }

}