package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import org.testng.Assert;

import driver.DriverManager;

public class LogoutSteps {

	HomePage homePage = new HomePage(DriverManager.getDriver());
    
    @When("user clicks menu button")
    public void user_clicks_menu_button() {
    	homePage.openMenu();
    }
    
    @And("clicks logout button")
    public void clicks_logout_button() {
    	homePage.clickLogout();
    }
    
    @Then("user should be directed to login page")
    public void user_should_be_directed_to_login_page() {
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://www.saucedemo.com/");        
    }
}