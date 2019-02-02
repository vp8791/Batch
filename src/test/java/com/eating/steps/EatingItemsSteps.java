package com.eating.steps;

import com.eating.Eating;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertTrue;


@RunWith(Cucumber.class)
public class  EatingItemsSteps {

    private Eating eating;

    @Given("^There are (.+) cucumbers$")
    public void there_are_cucumbers(String start) throws Throwable {
        eating = new Eating(Integer.parseInt(start));
    }

    @When("^I eat (.+) cucumbers$")
    public void i_eat_cucumbers(String eat) throws Throwable {
        eating.setEatenItems(Integer.parseInt(eat));
    }

    @Then("^I should have (.+) cucumbers$")
    public void i_should_have_cucumbers(String left) throws Throwable {
      int expectedLeftOvers  =  Integer.parseInt(left);
      int actualLeftOvers = eating.getLeftOver();
      assertTrue("Actual Left Overs vs Expected Left Overs", (expectedLeftOvers == actualLeftOvers));
    }
}