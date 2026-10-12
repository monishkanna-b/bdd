package stepdefinitions;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.codoid.products.fillo.Recordset;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import utilities.ExcelUtility;
import utilities.ExtentManager;
import utilities.GlobalVariable;
import utilities.PropertiesReader;
import utilities.UIActions;

public class StepDefinition_Hooks {
	
	Recordset objRS;  //Recordset stores records fetched from a database.
	public StepDefinition_Hooks() {
		System.out.println("HOOKS CLASS CONSTRUCTOR");
	}
 
	@Before
	public void initScenario(Scenario scenario) throws Exception {

	    // Feature & Scenario Details
	    String featureFileName =
	            Paths.get(scenario.getUri())
	                    .getFileName()
	                    .toString();

	    String actualFeature =featureFileName.replace(".feature", "");
	    String scenarioName =scenario.getName();

//	    System.out.println("Feature --> " + actualFeature);
//	    System.out.println("Scenario --> " + scenarioName);

	    GlobalVariable.featureName = actualFeature;
	    GlobalVariable.scenarioName = scenarioName;

	    // Extent Report Initialization
	    if (GlobalVariable.extent == null) {
	    	System.out.println("REPORT CREATION");

	        GlobalVariable.extent =
	                ExtentManager.getReport();
	    }

	    // Feature & Scenario Logs
	    UIActions.createFeature(actualFeature);
	    UIActions.scenario(scenarioName);

	    // Properties File
	    GlobalVariable.appReader =new PropertiesReader("Config.properties");
	    String browser =GlobalVariable.appReader.getProperty("browser");
	    String url =GlobalVariable.appReader.getProperty("url");

	    // Wait Values
	    GlobalVariable.implicitWait =
	            Integer.parseInt(
	                    GlobalVariable.appReader.getProperty("implicitWait"));

	    GlobalVariable.explicitWait =
	            Integer.parseInt(
	                    GlobalVariable.appReader.getProperty("explicitWait"));

	    GlobalVariable.pageLoadTimeout =
	            Integer.parseInt(
	                    GlobalVariable.appReader.getProperty("pageLoadTimeout"));

	    // Driver Initialization
	    if(browser.equalsIgnoreCase("chrome")) {
	    	ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        options.addArguments("--start-maximized");
			options.addArguments("--headless");
	        GlobalVariable.driver =
	                new ChromeDriver(options);

	    } else if(browser.equalsIgnoreCase("edge")) {

	        GlobalVariable.driver =
	                new EdgeDriver();
	    }

	 

	    // Waits
	    GlobalVariable.driver.manage()
	            .timeouts()
	            .implicitlyWait(
	                    Duration.ofSeconds(
	                            GlobalVariable.implicitWait));

	    GlobalVariable.driver.manage()
	            .timeouts()
	            .pageLoadTimeout(
	                    Duration.ofSeconds(
	                            GlobalVariable.pageLoadTimeout));

	    GlobalVariable.wait =
	            new WebDriverWait(
	                    GlobalVariable.driver,
	                    Duration.ofSeconds(
	                            GlobalVariable.explicitWait));

	    // Launch Application
	    GlobalVariable.driver.get(url);
	    System.out.println("BEFORE END - Application Launched Successfully");
	}
	
    @Given("^Data Set for the Scenario \"([^\"]*)\"$")
    public void data_set_for_the_scenario(String scenarioName) throws Throwable {

        GlobalVariable.testScenarioName = scenarioName;
        objRS = ExcelUtility.readDataFromExcel(GlobalVariable.featureName,scenarioName);
        GlobalVariable.objRS = objRS;
        System.out.println("Test data loaded for scenario: "+ scenarioName);
        GlobalVariable.stepMessage = "Test data fetched";
    }
    
    @After
    public void endScenario() throws Exception {

        if(GlobalVariable.driver != null)
        {
        	System.out.println("DRIVER CLOSE");
            GlobalVariable.driver.quit();
        }

        if(GlobalVariable.extent != null)
        {
        	System.out.println("EXTENT FLUSH");
            GlobalVariable.extent.flush();
        }

        System.out.println("Scenario execution completed");
    }
    
    @AfterStep
    public void captureStep(Scenario scenario) {

        String base64Screenshot =
                ((TakesScreenshot) GlobalVariable.driver)
                        .getScreenshotAs(OutputType.BASE64);

        if (scenario.isFailed()) {

            GlobalVariable.scenario.fail(
                    GlobalVariable.stepMessage,
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64Screenshot)
                            .build());

        } else {

            GlobalVariable.scenario.pass(
                    GlobalVariable.stepMessage,
                    MediaEntityBuilder
                            .createScreenCaptureFromBase64String(
                                    base64Screenshot)
                            .build());
        }
    }    
}








//Extend Report
/*  if (!GlobalVariable.featureName.equals(actualFeature)) {

      GlobalVariable.featureName = actualFeature;
       UIActions.createFeature(GlobalVariable.featureName);

  }*/
  
