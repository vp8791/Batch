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
public class AdditionSteps  {
    Calculator calculator;


    @When("^I add (.+) and (.+)$")
    public void i_add_and(String firstnumber, String secondnumber) throws Throwable {
        calculator = new Calculator(Double.parseDouble(firstnumber), Double.parseDouble(secondnumber), CalculatorOperations.ADDITION);
    }

    @Then("^the sum should be (.+)$")
    public void the_sum_should_be(String sum) throws Throwable {
        double actualResult = calculator.calculateResult();
        assertThat(actualResult, closeTo(Double.parseDouble(sum), CalculatorOperations.ERROR));
    }

}