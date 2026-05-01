package stepdefinitions;

import io.cucumber.java.en.*;
import pages.CartPage;
import pages.LoginPage;
import org.testng.Assert;
import driver.DriverManager;

public class CartPageSteps {
	LoginPage loginPage;
	CartPage cartPage;
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
        DriverManager.getDriver().get("https://www.saucedemo.com");
        loginPage = new LoginPage(DriverManager.getDriver());
        cartPage = new CartPage(DriverManager.getDriver());
	}

	@When("user clicks on add to cart on any product")
	public void user_clicks_on_add_to_cart_on_any_product() {
//        cartPage = new CartPage(DriverManager.getDriver());

	    cartPage.addFirstProductToCart();
	}

	@Then("cart badge increases by 1")
	public void cart_badge_increases_by_1() {
		Assert.assertEquals(1, cartPage.getCartBadgeCount());
	}

	@Then("button changes to remove")
	public void button_changes_to_remove() {
		Assert.assertTrue(cartPage.removeButton().isDisplayed());
	}

	@When("user adds {int} products to cart")
	public void user_adds_n_products_to_cart(int count) {
		cartPage.addnProductsToCart(count);
	}

	@Then("cart icon shows {int} items")
	public void cart_icon_shows_3_items(int count) {
		Assert.assertEquals(cartPage.getCartBadgeCount(),count);
	}

	@When("clicks remove button")
	public void clicks_remove_button() {
		cartPage.removeButton().click();
	}

	@Then("product should be removed")
	public void product_should_be_removed() {
		Assert.assertTrue(cartPage.isAllProductsRemoved());
	}

	@Then("cart badge should be updated")
	public void cart_badge_should_be_updated() {
		Assert.assertEquals(cartPage.getCartBadgeCount(), 0);
		
	}
}