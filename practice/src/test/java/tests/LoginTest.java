package tests;

import org.testng.Assert;
//import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driver.DriverManager;
import hooks.Hooks;
import pages.LoginPage;

public class LoginTest extends Hooks {

	LoginPage loginpage;
//	WebDriver driver;

    @BeforeMethod
    public void initPage() {
        DriverManager.getDriver().get("https://www.saucedemo.com");

        loginpage = new LoginPage(DriverManager.getDriver());
    }
    
    @Test
    public void validLoginTest() {

    	loginpage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
            DriverManager.getDriver().getCurrentUrl().contains("inventory")
        );
    }
    
    @Test
    public void invalidPasswordTest() {

    	loginpage.login("standard_user", "wrongpassword");

        Assert.assertTrue(loginpage.getErrorMessage()
        .contains("Username and password do not match"));
    }
    
    @Test
    public void emptyUsernamePasswordTest() {

    	loginpage.login("", "");

        Assert.assertTrue(loginpage.getErrorMessage()
        .contains("Username is required"));
    }   
    
    @Test
    public void lockedOutUserTest() {

    	loginpage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginpage.getErrorMessage()
        .contains("Sorry, this user has been locked out."));
    }   
    
        
}
