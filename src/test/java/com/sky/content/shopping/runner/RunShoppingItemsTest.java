package com.sky.content.shopping.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber-html" , "json:target/cucumber-report-json.json"},
        glue = "com.sky.content.shopping.shoppingitems"
)
public class RunShoppingItemsTest {
}
