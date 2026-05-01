package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	By addToCartBtn = By.xpath("//button[text()='Add to cart']");
	By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By products = By.xpath("//*[@id=\"inventory_container\"]");

	By checkoutBtn = By.xpath("//*[@id=\"checkout\"]");
	By menuBtn = By.xpath("//*[@id=\"react-burger-menu-btn\"]");

	By logoutBtn = By.xpath("//*[@id=\"logout_sidebar_link\"]");
//    By productItems = By.className("inventory_item");
	By productImage = By.xpath("//img[contains(@class, 'inventory_item_img')]");
	By productName = By.xpath("//div[contains(@class, 'inventory_item_name ')]");
	By productDescription = By.xpath("//div[@class='inventory_item_desc']");
	By productPrice = By.xpath("//*[@class=\"inventory_item_price\"]");

	By productDetailName = By.xpath("//div[contains(@class, 'inventory_details_name')]");
	By productDetailDescription = By.xpath("//div[@class='inventory_details_desc large_size']");
	By productDetailPrice = By.xpath("//*[@class=\"inventory_details_price\"]");
	By sortButton = By.xpath("//*[@class=\"product_sort_container\"]");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.getTitle();
	}

//    public boolean isLogoDisplayed() {
//        return driver.findElement(By.cssSelector(".brand.greenLogo")).isDisplayed();
//    }

	// Locator for all products

	// Check product list is visible
//    public boolean isProductListVisible() {
//        return driver.findElement(products).isDisplayed();
//    }
	
	public void clickSortButton() {
		 driver.findElement(sortButton).click();
	}
	
	public void selectSortBy(String sortBy) {
		Select select = new Select(driver.findElement(sortButton));
		select.selectByContainsVisibleText(sortBy);
	}

	public boolean isProductListVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(products));
		return items.size() > 0;
	}

	// Get all products count
	public int getProductCount() {
		List<WebElement> productList = driver.findElements(products);
		return productList.size();
	}
	
	public Boolean isSortedAlphabeticallyAtoZ() {
		List<String> list = driver.findElements(productName).stream().map(e->e.getText()).toList();
		List<String> newlist = new ArrayList<>();
		for(String e:list ) {
			newlist.add(e);
		}
		
		Collections.sort(newlist);
		
		if(newlist.equals(list)) {
			return true;
		}
		else {
			return false;
		}
	}
	public Boolean isSortedPriceHighToLow() {
		List<Double> list = driver.findElements(productPrice).stream().map(e->e.getText().replace("$", "")).map(Double::parseDouble).toList();
		List<Double> newlist = new ArrayList<>();
		for(Double e:list ) {
			newlist.add(e);
		}
	    
		newlist.sort(Collections.reverseOrder());
		
		if(newlist.equals(list)) {
			return true;
		}
		else {
			return false;
		}
	}
	

//    chrome methods 
//    public void searchProduct(String product) {
//        driver.findElement(searchBox).sendKeys(product);
//    }
//
//    public void clickSearch() {
//        driver.findElement(searchButton).click();
//    }
//
//    public String getProductName() {
//        return driver.findElement(productName).getText();
//    }

	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}

	public void openCart() {
		driver.findElement(cartIcon).click();
	}

	public void proceedToCheckout() {
		driver.findElement(checkoutBtn).click();
	}

	public void openMenu() {
		driver.findElement(menuBtn).click();
	}

	public void clickLogout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).click();
	}

	public boolean allProductsHaveImages() {
		List<WebElement> images = driver.findElements(productImage);

		for (WebElement image : images) {
			if (!image.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean allProductsHaveNames() {
		List<WebElement> names = driver.findElements(productName);
		for (WebElement name : names) {
			if (!name.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean allProductsHaveDescriptions() {
		List<WebElement> descs = driver.findElements(productDescription);
		for (WebElement desc : descs) {
			if (!desc.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean allProductsHavePrices() {
		List<WebElement> prices = driver.findElements(productPrice);
		for (WebElement price : prices) {
			if (!price.isDisplayed()) {
				return false;
			}
		}
		return true;
	}

	public boolean isInventoryPageDisplayed() {
		return driver.getCurrentUrl().contains("inventory");
	}

	public void addAnyProduct() {
		driver.findElements(addToCartBtn).get(0).click();
	}

	public void ClickOnProductName() {
		driver.findElement(productName).click();
	}

////    public boolean isProductDetailPageOpened() {
////        return driver.getCurrentUrl().contains("inventory-item");
////    }
//
	public boolean isProductNameDisplayed() {
		return driver.findElement(productDetailName).isDisplayed();
	}

	public boolean isProductDescriptionDisplayed() {
		return driver.findElement(productDetailDescription).isDisplayed();
	}

	public boolean isProductPriceDisplayed() {
		return driver.findElement(productDetailPrice).isDisplayed();
	}
}
