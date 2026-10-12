package utilities;

import org.openqa.selenium.WebElement;

public class UIActions {

//    public static void createFeature(String featureName) {
//    	System.out.println("Create Feature name --> " + featureName);
//        GlobalVariable.feature =GlobalVariable.extent.createTest(featureName);
//    }
	
	public static String currentFeatureName = "";

	public static void createFeature(String featureName) {

	    if (!featureName.equals(currentFeatureName)) { 
	    	System.out.println("Creating Feature -> "+ featureName);
	        GlobalVariable.feature = GlobalVariable.extent.createTest(featureName);
	        currentFeatureName = featureName;
	    }
	}

    public static void scenario(String scenarioName) {
    	System.out.println("Create Scenario name --> " + scenarioName);
        GlobalVariable.scenario =GlobalVariable.feature.createNode(scenarioName);
    }
    public static void enterText(
            WebElement element,
            String value,
            String elementName)
    {
    	try {
        element.clear();
        element.sendKeys(value);

        System.out.println(
                "Entered value in " + elementName);
    	}
    	catch (Exception e) {
    		GlobalVariable.stepMessage = "Failed to enter text in element "+ elementName+ ":"+ e.getClass().getSimpleName();
    		throw e;
//    		throw new RuntimeException("Failed to enter text in element : "+ elementName,e);
    	}
    }
    public static void click(
            WebElement element,
            String elementName)
    {
    	try {
        element.click();

        System.out.println(
                elementName + " clicked");
        }
    	catch (Exception e) {
    		GlobalVariable.stepMessage = "Failed to click element "+ elementName+ ":"+ e.getClass().getSimpleName();
    		throw e;
//    		throw new RuntimeException("Failed to click element : "+ elementName,e);
    	}
    }
    public static String getText(
            WebElement element,
            String elementName)
    {
    	try {
        String text = element.getText();

        System.out.println(
                elementName + " : " + text);

        return text;
        }
    	catch (Exception e) {
    		GlobalVariable.stepMessage = "Failed to get text from "+ elementName+ ":"+ e.getClass().getSimpleName();
    		throw e;
    	}
    	
    }
}