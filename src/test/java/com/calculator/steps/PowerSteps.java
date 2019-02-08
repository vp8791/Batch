package com.calculator.steps;

import com.utils.Calculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class PowerSteps {
    Calculator calculator;

    @Given("^I have a Calculator$")
    public void i_have_a_calculator() throws Throwable {
        throw new PendingException();
    }

    @When("^I Power (.+) and (.+)$")
    public void i_power_and(String firstnumber, String secondnumber) throws Throwable {
        throw new PendingException();
    }

    @Then("^the Power amount should be (.+)$")
    public void the_power_amount_should_be(String poweramount) throws Throwable {
        throw new PendingException();
    }

}