package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    WebDriver driver;

	 private By username = By.xpath("//*[@id=\"user-name\"]");
	 private By password = By.xpath("//input[@id='password']");
	 private By loginBtn = By.xpath("//*[@id=\"login-button\"]");
	 private By errorMsg = By.cssSelector("h3[data-test='error']");

	 
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	public void enterUserName(String user) {
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public void login(String user,String pass) {
		enterUserName(user);
		enterPassword(pass);
		clickLogin();
	}
	
    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
	
}
