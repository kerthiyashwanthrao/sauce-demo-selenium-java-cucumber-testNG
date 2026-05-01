package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.apache.log4j.Logger;

import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckoutPageSteps {

    HomePage homePage;
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    Logger logger = Logger.getLogger(CheckoutPageSteps.class); 

    @When("user add product to cart")
    public void useraddproducttocart() {
    	checkoutPage = new CheckoutPage(DriverManager.getDriver());
    	homePage = new HomePage(DriverManager.getDriver());
    	homePage.addAnyProduct();
        logger.info("user add product to cart");
    }
    
    @And("enter firstname {string},lastname {string} and zipcode {string}")
    public void enterfirstnamelastnameandzipcode(String firstName, String lastName, String zipCode) {
    	checkoutPage.enterfirstNameLastNameZipcode(firstName,lastName,zipCode);
        logger.info("Logout clicked");
    }
    
    @And("click continue button")
    public void clickcontinuebutton() {
    	checkoutPage.clickContinue();
        logger.info("click Continue");
    }  
    
    @And("go to cart")
    public void gotocart() {
    	checkoutPage.goToCart();
        logger.info("go to cart clicked");
    }  
    @And("click finish")
    public void clickfinish() {
    	checkoutPage.clickFinish();
        logger.info("clicked finished btn");
    }   
    @And("click checkout")
    public void clickcheckout() {
    	checkoutPage.clickCheckout();
        logger.info("clicked checkout");
    }   
     
    @Then("thank you for your order message should be displayed")
    public void thankyouforyourordermessageshouldbedisplayed() {
        Assert.assertEquals(
            checkoutPage.getThankYouOrderMessage(),
            "Thank you for your order!"
        );

        logger.info("validate thank you message");
    }
    
    @Given("user is on checkout page")
    public void userisoncheckoutpage() {

        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(
            currentUrl.contains("checkout")
        );

        logger.info("user is on checkout page");
    }
    
    @When("user leaves fields blank")
    public void userleavesfieldsblank() {
    	checkoutPage.enterfirstNameLastNameZipcode("", "", "");
        logger.info("user leaves fields blank");
    }
     
    @Then("error message should be displayed")
    public void errormessageshouldbedisplayed() {
        Assert.assertEquals(
            checkoutPage.getErrorMessage(),
            "Error: First Name is required"
            );

        logger.info("Logout verified successfully");
    }
    
}