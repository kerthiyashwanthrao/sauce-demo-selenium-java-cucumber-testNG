package tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver.DriverManager;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseLoginTest;

public class HomeTest extends BaseLoginTest {
	
	HomePage home;
	Logger logger = Logger.getLogger(HomeTest.class);

    @BeforeMethod
    public void initPage() {
        home = new HomePage(DriverManager.getDriver());
        logger.info("Home page created");
    }

    @Test(priority=0)
    public void verifyHomePageLoadsSuccessfully() throws InterruptedException {
        String title = home.getTitle();
        logger.info("get title");
        Assert.assertTrue(title.contains("Swag Labs"));
        logger.info("title comparison done");
    }
    
    @Test(priority=1)
    public void verifyAllProductsAreDisplayed() {
        // Step 1: Verify product list is visible
        Assert.assertTrue(home.isProductListVisible(), "Product list is not visible");

        // Step 2: Get product count
        int count = home.getProductCount();

        // Step 3: Verify count > 0
        Assert.assertTrue(count > 0, "No products found on page");        
        Assert.assertTrue(home.getTitle().contains("Swag Labs"));

    }
    
    @Test(priority=2)
    public void verifyLogoutFunctionality() {
    	DriverManager.getDriver().get("https://www.saucedemo.com/");
    	LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    	loginPage.login("standard_user", "secret_sauce");
    	home.openMenu();
    	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("//*[@id=\\\"logout_sidebar_link\\\"]"))).click();
//    	home.clickLogout();
        Assert.assertEquals(DriverManager.getDriver().getCurrentUrl(),"https://www.saucedemo.com/");

    }
    
}