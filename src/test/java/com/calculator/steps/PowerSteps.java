package com.calculator.steps;

import com.utils.Calculator;
import com.utils.CalculatorOperations;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(Cucumber.class)
public class PowerSteps {
    Calculator calculator;

    @Given("^I have a Calculator$")
    public void i_have_a_calculator() throws Throwable {
    }

    @When("^I Power (.+) and (.+)$")
    public void i_power_and(String firstnumber, String secondnumber) throws Throwable {
        calculator = new Calculator(Double.parseDouble(firstnumber), Double.parseDouble(secondnumber), CalculatorOperations.POWER);
    }

    @Then("^the Power amount should be (.+)$")
    public void the_power_amount_should_be(String poweramount) throws Throwable {
        double actualResult = calculator.calculateResult();
        assertThat(actualResult, closeTo(Double.parseDouble(poweramount), CalculatorOperations.ERROR));


    }

}