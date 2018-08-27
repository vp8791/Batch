package com.mykyong;

import cucumber.api.CucumberOptions;

@CucumberOptions(
        format = { "pretty", "html:target/cucumber-html" , "json:target/cucumber-report-json.json"},
        glue = "com.mykyong.bdd"
)
public class BaseCucumber {

}
