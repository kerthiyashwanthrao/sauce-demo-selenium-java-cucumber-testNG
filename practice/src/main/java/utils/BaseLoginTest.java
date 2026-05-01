package utils;

import org.testng.annotations.BeforeMethod;

import driver.DriverManager;

public class BaseLoginTest {

    @BeforeMethod
    public void login() {

        LoginToApp.login(DriverManager.getDriver());

    }
}