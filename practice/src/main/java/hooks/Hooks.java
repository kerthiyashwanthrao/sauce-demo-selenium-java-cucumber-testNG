package hooks;

import driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setup() {
//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver = new ChromeDriver();
    	
		ChromeOptions options = new ChromeOptions(); 		

		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("profile.credentials_enable_service", false);
		options.setExperimentalOption("prefs", prefs);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);

        DriverManager.setDriver(driver);
        
        driver.manage().window().maximize();

        
//        DriverManager.getDriver().get("https://www.saucedemo.com");
        

    }

    @After
    public void tearDown() {

        DriverManager.quitDriver();
    }
}