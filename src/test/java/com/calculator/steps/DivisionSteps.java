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
public class DivisionSteps {

    Calculator calculator;

    @Given("^I have a Calculator$")
    public void i_have_a_calculator() throws Throwable {
    }

    @When("^I Divide (.+) and (.+)$")
    public void i_divide_and(String firstnumber, String secondnumber) throws Throwable {
        calculator = new Calculator(Double.parseDouble(firstnumber), Double.parseDouble(secondnumber), CalculatorOperations.DIVISION);
    }

    @Then("^the Division  amount should be (.+)$")
    public void the_division_amount_should_be(String divisionamount) throws Throwable {
        double actualResult = calculator.calculateResult();
        assertThat(actualResult, closeTo(Double.parseDouble(divisionamount), CalculatorOperations.ERROR));

    }

}