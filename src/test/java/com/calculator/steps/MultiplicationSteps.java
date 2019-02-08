package com.calculator.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.utils.Calculator;

@RunWith(Cucumber.class)
public class MultiplicationSteps {

    Calculator calculator;

    @Given("^I have a Calculator$")
    public void i_have_a_calculator() throws Throwable {
        throw new PendingException();
    }

    @When("^I Multiply (.+) and (.+)$")
    public void i_multiply_and(String firstnumber, String secondnumber) throws Throwable {
        throw new PendingException();
    }

    @Then("^the Multiplication  amount should be (.+)$")
    public void the_multiplication_amount_should_be(String multiplicationamount) throws Throwable {
        throw new PendingException();
    }

}