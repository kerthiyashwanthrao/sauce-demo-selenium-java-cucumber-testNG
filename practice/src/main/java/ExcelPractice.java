import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelUtil;

public class ExcelPractice {

	@DataProvider(name = "searchData")
	public Object[][] getSearchData() {
		return ExcelUtil.getData("\\TestData\\searchData.xlsx", "Sheet1");
	}

	@Test(dataProvider = "searchData")
	public void searchTest(String A) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"twotabsearchtextbox\"]")))
				.sendKeys(A);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"nav-search-submit-button\"]"))).click();

//		Thread.sleep(3);
		driver.quit();

	}

}
