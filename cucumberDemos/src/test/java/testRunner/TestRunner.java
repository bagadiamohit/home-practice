package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Mohit\\WS\\cucumberDemos\\src\\test\\java",
glue= {"stepdefs"},plugin= {"pretty","json:target/cucumber-reports/Cucumber.json", 
"html:target/cucumber-reports/html-reports/Cucumber.html"},monochrome=true)
public class TestRunner {

}
