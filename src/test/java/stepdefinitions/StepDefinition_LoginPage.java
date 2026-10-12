package stepdefinitions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPage;
import utilities.GlobalVariable;

public class StepDefinition_LoginPage {
	private LoginPage loginPage;

    public StepDefinition_LoginPage() {

        // Driver is already created in @Before Hook
    	System.out.println("Driver In Constructor = "+ GlobalVariable.driver);
        loginPage = new LoginPage(GlobalVariable.driver);
        System.out.println("StepDefinition_LoginPage CONSTRUCTOR TO SEND DRIVER TO LOGINPAGE");
    }
    

    @Before
	public void b(){
    	System.out.println("BEFORE ANNOTATION IN STEP DEFINITION LOGIN PAGE");
    }

    @Given("User launches the webapplication")
    public void user_launches_the_webapplication() throws Exception {
    	System.out.println("Application launched");
//    	GlobalVariable.scenario.pass("Application launched using BEFORE");
    	GlobalVariable.stepMessage = "Application launched using BEFORE";
    }

    @When("User enters the username")
    public void user_enters_the_username()throws Exception {
        String username =GlobalVariable.objRS.getField("Username");
        System.out.println("Username entered --> "+ username);
        loginPage.enterUsername(username);
//        GlobalVariable.scenario.pass("Username fetched from Excel and entered: "+ username);
        GlobalVariable.stepMessage = "Username fetched from Excel and entered: "+ username;
    }

    @When("User enters the password")
    public void user_enters_the_password() throws Exception {
        String password =GlobalVariable.objRS.getField("Password");
        System.out.println("Password entered --> " + password);
        loginPage.enterPassword(password);
//        GlobalVariable.scenario.pass("Password fetched from Excel and entered");
        GlobalVariable.stepMessage = "Password fetched from Excel and entered "+ password;
    }


    @When("User clicks on the login button")
    public void user_clicks_on_the_login_button()throws Exception {
        loginPage.clickLogin();
        System.out.println("Login Button clicked");
//        GlobalVariable.scenario.pass("Login Button Clicked Successfully");
        GlobalVariable.stepMessage = "Login Button Clicked Successfully";
    }

    @Then("User should navigate to the Home Page")
    public void user_should_navigate_to_the_home_page()throws Exception {
        String heading =loginPage.getHomePageHeading();
        System.out.println("Home page heading : " + heading);
//        GlobalVariable.scenario.pass("Home page displayed Successfully");
        GlobalVariable.stepMessage = "Home page displayed Successfully";
    }
    
    @Then("User should see invalid password error")
    public void user_should_see_invalid_password_error()throws Exception {
        String actualError =loginPage.getErrorMessage();
        String expectedError ="Your password is invalid!";

        try {
        Assert.assertEquals(
                actualError,
                expectedError);}
        catch (AssertionError e) {
        	GlobalVariable.stepMessage ="Assertion Failed : " + e.getMessage();
        	throw e;
        }

//        GlobalVariable.scenario.pass("Invalid password error verified");
        GlobalVariable.stepMessage = "Invalid password error verified";
    }
    
    @Then("User should see invalid user error")
    public void user_should_see_invalid_user_error()throws Exception {
        String actualError =loginPage.getErrorMessage();
        String expectedError ="Your username is invalid!";
        try {
        Assert.assertEquals(
                actualError,
                expectedError);}
        catch (AssertionError e) {
        	GlobalVariable.stepMessage ="Assertion Failed : " + e.getMessage();
        	throw e;
        }
//        GlobalVariable.scenario.pass("Invalid username error verified");
        GlobalVariable.stepMessage = "Invalid username error verified";
    }
    
    @Then("User should not navigate to the Home Page")
    public void user_should_not_navigate_to_the_home_page()throws Exception {
        String heading =loginPage.getHomePageHeading();
        GlobalVariable.stepMessage = "Home page displayed Successfully but forceful fail";
        try {
        Assert.assertEquals(
                heading,
                "Logged In Successfullyyy");
        }
        catch (AssertionError e) {
        	GlobalVariable.stepMessage ="Assertion Failed : " + e.getMessage();
        	throw e;
        }
//        GlobalVariable.scenario.pass("Home page displayed Successfully");
        
//        try {
//            Assert.assertEquals(
//                    heading,
//                    "Logged In Successfullyyy");
//            GlobalVariable.scenario.pass("Home page displayed Successfully");
//        }
//        catch (AssertionError e) {
            
         // Capture Base64 Screenshot
//            String base64Screenshot =((TakesScreenshot) GlobalVariable.driver)
//                            .getScreenshotAs(OutputType.BASE64);

            // Attach Screenshot
//            GlobalVariable.scenario.fail(MediaEntityBuilder
//                            .createScreenCaptureFromBase64String(
//                                    base64Screenshot,
//                                    e.getMessage())
//                            .build());
//
//            throw e;
//        }
    }    
    
}