package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.apache.log4j.Logger;

import pages.HomePage;
import pages.LoginPage;

public class HomeSteps{

    HomePage home;
    LoginPage loginPage;

    Logger logger = Logger.getLogger(HomeSteps.class);

    @Given("user is logged into the application")
    public void user_is_logged_into_the_application() {

        DriverManager.getDriver().get("https://www.saucedemo.com/");

        loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.login("standard_user", "secret_sauce");

        home = new HomePage(DriverManager.getDriver());

        logger.info("User logged in successfully");
    }

    @Then("home page title should contain {string}")
    public void home_page_title_should_contain(String expectedTitle) {

        String title = home.getTitle();
        logger.info("Fetched page title");

        Assert.assertTrue(title.contains(expectedTitle));

        logger.info("Title verification completed");
    }

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {

        home = new HomePage(DriverManager.getDriver());
        logger.info("Home page initialized");
    }

    @Then("product list should be visible")
    public void product_list_should_be_visible() {

        Assert.assertTrue(home.isProductListVisible(),
                "Product list is not visible");

        logger.info("Product list visibility verified");
    }

    @Then("product count should be greater than 0")
    public void product_count_should_be_greater_than_0() {

        int count = home.getProductCount();

        Assert.assertTrue(count > 0,
                "No products found on page");

        logger.info("Product count verified: " + count);
    }

    @When("user clicks logout")
    public void user_clicks_logout() {

        home.openMenu();
        home.clickLogout();

        logger.info("Logout clicked");
    }

    @Then("user should be redirected to login page")
    public void user_should_be_redirected_to_login_page() {

        String currentUrl = DriverManager.getDriver().getCurrentUrl();

        Assert.assertEquals(currentUrl,
                "https://www.saucedemo.com/");

        logger.info("Logout verified successfully");
    }
}