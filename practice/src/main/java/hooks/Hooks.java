package hooks;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        DriverManager.setDriver(driver);
        
//        DriverManager.getDriver().get("https://www.saucedemo.com");
        

    }

    @After
    public void tearDown() {

        DriverManager.quitDriver();
    }
}