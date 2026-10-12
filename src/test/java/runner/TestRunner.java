package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Login.feature",
        glue = "stepdefinitions", //Glue is used to connect Feature File steps with Step Definition classes and Hook classes
        plugin = {
                "pretty",                                		 
                "html:target/cucumber-reports.html"
        }
        
)
public class TestRunner extends AbstractTestNGCucumberTests {  
	//The TestRunner acts as a bridge between Cucumber and TestNG.
        
	

}
