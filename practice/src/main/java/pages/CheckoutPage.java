package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By thankYouMessage = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
	By checkout = By.xpath("//*[@id=\"checkout\"]");
	By firstname = By.xpath("//*[@id=\"first-name\"]");
	By lastname = By.xpath("//*[@id=\"last-name\"]");
	By postalcode = By.xpath("//*[@id=\"postal-code\"]");
	By continueBtn = By.xpath("//*[@id=\"continue\"]");
	By finish = By.xpath("//*[@id=\"finish\"]");
	By backtoproducts = By.xpath("//*[@id=\"back-to-products\"]");
	 By cartIcon = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By errorMessage = By.xpath("//h3[contains(text(),\"Error: First Name is required\")]");

	public void goToCart() {
		driver.findElement(cartIcon).click();
	}

//   And click checkout
	public void clickCheckout() {
		driver.findElement(checkout).click();
	}

//   And enter firstname,lastname and zipcode 
	public void enterfirstNameLastNameZipcode(String firstName, String lastName, String zipCode) {
		driver.findElement(firstname).sendKeys(firstName);
		driver.findElement(lastname).sendKeys(lastName);
		driver.findElement(postalcode).sendKeys(zipCode);
	}

//   And click continue button
	public void clickContinue() {
		driver.findElement(continueBtn).click();
	}

//   And click finish 
	public void clickFinish() {
		driver.findElement(finish).click();
	}

//   Then thank you for your order message should be displayed
	public String getThankYouOrderMessage() {
		return driver.findElement(thankYouMessage).getText();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

}
