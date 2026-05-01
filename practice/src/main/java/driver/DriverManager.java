package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {

		try {
			if (driver.get() != null) {
				driver.get().quit();
				driver.remove();
			}
		} catch (Exception e) {
			System.out.println("Driver already closed");
		}

	}
}