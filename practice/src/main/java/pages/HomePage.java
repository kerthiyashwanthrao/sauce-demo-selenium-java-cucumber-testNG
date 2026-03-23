package pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    private By searchBox = By.cssSelector(".search-keyword");
    private By searchButton = By.cssSelector(".search-button");
    private By productName = By.cssSelector(".product-name");
    private By addToCartBtn = By.xpath("//button[text()='ADD TO CART']");
    private By cartIcon = By.cssSelector("img[alt='Cart']");
    private By checkoutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
    private By menuBtn = By.xpath("//*[@id=\"react-burger-menu-btn\"]");
    private By logoutBtn = By.xpath("//*[@id=\"logout_sidebar_link\"]");
  

    public HomePage(WebDriver driver) {
    	this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(By.cssSelector(".brand.greenLogo")).isDisplayed();
    }
    
    // Locator for all products
    private By products = By.cssSelector(".inventory_item");

    // Check product list is visible
    public boolean isProductListVisible() {
        return driver.findElement(products).isDisplayed();
    }

    // Get all products count
    public int getProductCount() {
        List<WebElement> productList = driver.findElements(products);
        return productList.size();
    }
    
//    chrome methods 
    public void searchProduct(String product) {
        driver.findElement(searchBox).sendKeys(product);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

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
        driver.findElement(logoutBtn).click();
    }
      
  
}
    
    
