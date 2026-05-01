package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import driver.DriverManager;
import pages.HomePage;

public class ProductPageSteps {

	HomePage homePage = new HomePage(DriverManager.getDriver());
    
    @Then("all products should be displayed")
    public void all_products_should_be_displayed() {
        Assert.assertTrue(homePage.isProductListVisible());
    }

    @Then("each product should have image")
    public void each_product_should_have_image() {
        Assert.assertTrue(homePage.allProductsHaveImages());
    }

    @Then("each product should have name")
    public void each_product_should_have_name() {
        Assert.assertTrue(homePage.allProductsHaveNames());
    }

    @Then("each product should have description")
    public void each_product_should_have_description() {
        Assert.assertTrue(homePage.allProductsHaveDescriptions());
    }

    @Then("each product should have price")
    public void each_product_should_have_price() {
        Assert.assertTrue(homePage.allProductsHavePrices());
    }
    

    @When("user clicks on product name")
    public void user_clicks_on_product_name() {

        homePage.ClickOnProductName();
    }

    @Then("product detail page should open")
    public void product_detail_page_should_open() {
    	Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("https://www.saucedemo.com/inventory-item.html"));
    }

    @Then("product information should be displayed")
    public void product_information_should_be_displayed() {    	
        Assert.assertTrue(homePage.isProductNameDisplayed());
        Assert.assertTrue(homePage.isProductDescriptionDisplayed());
        Assert.assertTrue(homePage.isProductPriceDisplayed());
    }
    
}