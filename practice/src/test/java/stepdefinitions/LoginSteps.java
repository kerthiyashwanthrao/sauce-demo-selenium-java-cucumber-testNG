package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.testng.Assert;

import pages.LoginPage;

public class LoginSteps{

    LoginPage loginPage;

    @Given("user opens the login page")
    public void user_opens_the_login_page() {

        DriverManager.getDriver().get("https://www.saucedemo.com");

    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login(username, password);
    }

    @Then("user should be redirected to inventory page")
    public void user_should_be_redirected_to_inventory_page() {

        Assert.assertTrue(
                DriverManager.getDriver().getCurrentUrl().contains("inventory")
        );
    }

    @Then("error message should contain {string}")
    public void error_message_should_contain(String expectedMessage) {

        Assert.assertTrue(
                loginPage.getErrorMessage().contains(expectedMessage)
        );
    }
}