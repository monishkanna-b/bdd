package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.codoid.products.fillo.Recordset;

public class GlobalVariable {

    public static String featureName = "";
    public static String scenarioName = "";
    public static String testScenarioName = "";
    public static Recordset objRS;
    public static PropertiesReader appReader;
    
    public static ExtentReports extent;
    public static ExtentTest feature;
    public static ExtentTest scenario;
    public static String stepMessage;
    
    public static WebDriver driver;
    
    public static int implicitWait;
    public static int explicitWait;
    public static int pageLoadTimeout;
    
    public static WebDriverWait wait;
   

    public static final String AUT_TESTDATASHEET =System.getProperty("user.dir")+ "/TestData/FrameworkData.xlsx";
}