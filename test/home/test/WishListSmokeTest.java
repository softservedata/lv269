package home.test;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WishListSmokeTest {
	private static WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");

		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	
	@Before
	public void before() {
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=40");
	}

	@Test
	public void smokeTest() {
		Assert.assertTrue("Wish List button is missing",
				driver.findElement(By.xpath(".//button[@class='btn btn-default']/i[@class='fa fa-heart']")) != null);
	}
}