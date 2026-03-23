package utils;

import org.openqa.selenium.WebDriver;

//import driver.DriverManager;
import pages.LoginPage;

public class LoginToApp {

    public static void login(WebDriver driver) {

        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

    }
}