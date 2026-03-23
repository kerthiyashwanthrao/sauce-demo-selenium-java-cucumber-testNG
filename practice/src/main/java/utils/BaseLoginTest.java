package utils;

import org.testng.annotations.BeforeMethod;

import driver.DriverManager;
import hooks.Hooks;

public class BaseLoginTest extends Hooks {

    @BeforeMethod
    public void login() {

        LoginToApp.login(DriverManager.getDriver());

    }
}