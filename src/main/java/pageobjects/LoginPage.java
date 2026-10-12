package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.GlobalVariable;
import utilities.UIActions;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    

    @FindBy(id = "username")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "submit")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@id ='error']")
    private WebElement lblError;

    @FindBy(tagName = "h1")
    private WebElement lblSuccessHeading;

    public void enterUsername(String username)
    {
        UIActions.enterText(
                txtUsername,
                username,
                "Username");
    }

    public void enterPassword(String password)
    {
        UIActions.enterText(
                txtPassword,
                password,
                "Password");
    }

    public void clickLogin()
    {
        UIActions.click(
                btnLogin,
                "Login Button");
    }

    public String getErrorMessage() throws InterruptedException
    {
//    	Thread.sleep(2000);
    	try {
    	GlobalVariable.wait.until(ExpectedConditions.visibilityOf(lblError));
        return UIActions.getText(
                lblError,
                "Error Message");
    	}
    	catch (Exception e) {
    		GlobalVariable.stepMessage = "Failed to get text from : "+ e.getClass().getSimpleName();
    		throw e;
    	}
    }

    public String getHomePageHeading()
    {
        return UIActions.getText(
                lblSuccessHeading,
                "Home Page Heading");
    }
}