package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features = "src/main/java/Features/SearchOnGoogle.feature",glue ={"StepDefinations"}, 
	plugin= {"pretty","html:target/htmlreport.html"})




public class Runner{
	

}