package com.calculator.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.utils.Calculator;

@RunWith(Cucumber.class)
public class  SubstractionSteps {
    Calculator calculator;

    @Given("^I have a Calculator$")
    public void i_have_a_calculator() throws Throwable {
        calculator = new Calculator();
        throw new PendingException();
    }

    @When("^I substract (.+) and (.+)$")
    public void i_substract_and(String firstnumber, String secondnumber) throws Throwable {
        throw new PendingException();
    }

    @Then("^the substraction amount should be (.+)$")
    public void the_substraction_amount_should_be(String substractionamount) throws Throwable {
        throw new PendingException();
    }

}