package com.calculator.steps;

import com.utils.CalculatorOperations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.utils.Calculator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Cucumber.class)
public class  SubstractionSteps {
    Calculator calculator;

    @When("^I substract (.+) and (.+)$")
    public void i_substract_and(String firstnumber, String secondnumber) throws Throwable {
        calculator = new Calculator(Double.parseDouble(firstnumber), Double.parseDouble(secondnumber), CalculatorOperations.SUBSTRACTION);

    }

    @Then("^the substraction amount should be (.+)$")
    public void the_substraction_amount_should_be(String substractionamount) throws Throwable {
        double actualResult = calculator.calculateResult();
        assertThat(actualResult, closeTo(Double.parseDouble(substractionamount), CalculatorOperations.ERROR));

    }

}