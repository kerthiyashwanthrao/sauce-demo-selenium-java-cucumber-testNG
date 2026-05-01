package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.apache.log4j.Logger;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {

	HomePage homePage = new HomePage(DriverManager.getDriver());
	LoginPage loginPage = new LoginPage(DriverManager.getDriver());

	Logger logger = Logger.getLogger(HomeSteps.class);

	@Given("user is logged into the application")
	public void user_is_logged_into_the_application() {
		DriverManager.getDriver().get("https://www.saucedemo.com/");
		loginPage.login("standard_user", "secret_sauce");
		logger.info("User logged in successfully");
	}

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {

		DriverManager.getDriver().get("https://www.saucedemo.com/");

		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.login("standard_user", "secret_sauce");

		homePage = new HomePage(DriverManager.getDriver());

		Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("inventory"),
				"User is not on home/inventory page");
	}

	@Then("home page title should contain {string}")
	public void home_page_title_should_contain(String expectedTitle) {

		String title = homePage.getTitle();

		Assert.assertTrue(title.contains(expectedTitle),
				"Expected title to contain: " + expectedTitle + " but actual title is: " + title);

		logger.info("Title verification completed");
	}

	@Then("product list should be visible")
	public void product_list_should_be_visible() {

		Assert.assertTrue(homePage.isProductListVisible(), "Product list is not visible");

		logger.info("Product list visibility verified");
	}

	@Then("product count should be greater than 0")
	public void product_count_should_be_greater_than_0() {

		int count = homePage.getProductCount();

		Assert.assertTrue(count > 0, "No products found on page");

		logger.info("Product count verified: " + count);
	}

	@Then("user should be redirected to login page")
	public void user_should_be_redirected_to_login_page() {

		String currentUrl = DriverManager.getDriver().getCurrentUrl();

		Assert.assertEquals(currentUrl, "https://www.saucedemo.com/", "User is not redirected to login page");

		logger.info("Logout verified successfully");
	}

	@When("user select sorting dropdown")
	public void userselectsortingdropdown() {
		homePage.clickSortButton();
		logger.info("user select sorting dropdown");
	}

	@And("choose {string}")
	public void chooseAnyOption(String option) {
		homePage.selectSortBy(option);
		logger.info("choose" + option);
	}

	@Then("products should be sorted alphabetically.")
	public void productsshouldbesortedalphabetically() {
		homePage.isSortedAlphabeticallyAtoZ();
		logger.info("is sorted alphabetically");
	}

	@Then("products should be sorted by highest price first")
	public void productsshouldbesortedbyhighestpricefirst() {
		homePage.isSortedPriceHighToLow();
		logger.info("products should be sorted high to low .");
	}

}