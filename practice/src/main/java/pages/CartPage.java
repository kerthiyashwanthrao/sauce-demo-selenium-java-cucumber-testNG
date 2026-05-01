package pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By cartIcon = By.className("shopping_cart_link");
    By removeButton = By.xpath("//button[text()='Remove']");

    By checkoutButton = By.id("checkout");

    By continueShoppingButton = By.id("continue-shopping");

    By cartBadge = By.xpath("//*[@id=\"shopping_cart_container\"]/a/span");


    // Actions

    // Click cart icon
    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

    // Get number of products in cart
//    public int getCartItemsCount() {
//        List<WebElement> items = driver.findElements(cartItems);
//        return items.size();
//    }

    // Remove product
    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    // Click checkout
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
    public WebElement removeButton() {
    	return driver.findElement(removeButton);
    }

    // Click continue shopping
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    // Get cart badge count
    public int getCartBadgeCount() {
    	try {
    	    return Integer.parseInt(driver.findElement(cartBadge).getText());
    	} catch (NoSuchElementException e) {
    	    return 0;
    	}
    }

    // Check if cart badge is displayed
    public boolean isCartBadgeDisplayed() {
        return driver.findElement(cartBadge).isDisplayed();
    }
    
 // InventoryPage.java
    By addToCartButtons = By.xpath("//button[contains(text(),\"Add to cart\")]");

    public void addFirstProductToCart() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> buttons = wait.until(
            ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCartButtons)
        );

        if (buttons.isEmpty()) {
            throw new RuntimeException("No 'Add to cart' buttons found");
        }

        buttons.get(0).click();
    }
    
    public void addnProductsToCart(int count) {
		List<WebElement> addButtons = driver.findElements(By.xpath("//button[text()='Add to cart']"));

	    if (count > addButtons.size()) {
	        throw new RuntimeException("Not enough products available");
	    }
	    
		for (int i = 0; i < count; i++) {
			addButtons.get(i).click();
		}
		
		
    }
    public Boolean isAllProductsRemoved() {
		List<WebElement> removeButtons = driver.findElements(By.xpath("//button[text()='Remove']"));
		return removeButtons.size()==0;
		
    }
}