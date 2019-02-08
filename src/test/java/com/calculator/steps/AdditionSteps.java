package com.calculator.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import com.utils.Calculator;

@RunWith(Cucumber.class)
public class AdditionSteps  {
    Calculator calculator;

    @Given("^I have a Calculator$")
    public void i_have_a_calculator() throws Throwable {
    }

    @When("^I add (.+) and (.+)$")
    public void i_add_and(String firstnumber, String secondnumber) throws Throwable {
        throw new PendingException();
    }

    @Then("^the sum should be (.+)$")
    public void the_sum_should_be(String sum) throws Throwable {
        throw new PendingException();
    }

}