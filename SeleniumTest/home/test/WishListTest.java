package home.test;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListTest {
	private static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:/Users/Olex/Documents/Selenium/geckodriver.exe");		
	}
	
	@AfterClass
	public static void afterClass() {
	}
	
	@Before
	public void beforeTestWishList() {
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Precondition
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=40");
	}
	
	@After
	public void afterTestWishList() {
		driver.quit();
	}
	/*		Test case #1
	+	Add item to WishList
	+	Open up WishList
	+	Expected result - we should get page which asks us about log in with username/password
	 */	
	@Test
	public void testWishList1() {
		// Add item to WishList
		driver.findElement(By.xpath(".//button[@class='btn btn-default'][1]")).click();
		
		// Open up WishList
		driver.findElement(By.id("wishlist-total")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains("/login"));
		
		// Expected result - we should get page which asks us about log in with username/password
		Assert.assertTrue("This is not login page.", driver.getCurrentUrl().contains("/login"));
		
		// Bug - if click on WishList faster, than message with text about need to log in appears
		// we will get unknown error
	}
	
	/*		Test case #2
	+	Add item to WishList
	+	Log in with username/password
	+	Open WishList
	+	Expected result - WishList should contain element with id=40
	+	Delete item
	+	Expected result - WishList should be empty
	 */	
	@Test
	public void testWishList2() {
		// Add item to WishList
		driver.findElement(By.xpath(".//button[@class='btn btn-default'][1]")).click();
		
		// Log in
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("p4422663331114@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();
		
		// Open up WishList
		driver.findElement(By.id("wishlist-total")).click();
		
		// Expected result - WishList should contain element with id=40
		Assert.assertTrue("Element id=40 is not present in the Wish List", driver.findElements(
				By.xpath(".//a[@href='http://server7.pp.ua/index.php?route=product/product&product_id=40']")).size() > 0);
		
		// Delete item
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		
		// Check whether wish list is empty
		Assert.assertTrue("WishList is not empty.", driver.getPageSource().contains("Your wish list is empty."));
	}
	/*		Test case #3
	+	Add item to WishList
	+	Log in with username/password
	+	Log out
	+	Open WishList
	+	Expected result - we should get page which asks us about log in with username/password
	 */
	@Test
	public void testWishList3() {
		// Add item to WishList
		driver.findElement(By.xpath(".//button[@class='btn btn-default'][1]")).click();
		
		// Log in
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("p4422663331114@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();

		// Log out
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(
				By.xpath(".//a[@class='list-group-item'][@href='http://server7.pp.ua/index.php?route=account/logout']"))
				.click();
		
		// Open up WishList
		driver.findElement(By.id("wishlist-total")).click();
		
		// Expected result - check whether we on login page
		Assert.assertTrue("This is not login page.", driver.getCurrentUrl().contains("/login"));
	}
	/* 		Test case #4
	+	Log in with username/password
	+	Add item to WishList
	+	Log out
	+	Add second item to WishList
	+	Log in with username/password
	+	Open up WishList
	+	Expected result - WishList should contain 2 items
	+	Delete 2 items
	+	Expected result - WishList should be empty
	 */	
	@Test
	public void testWishList4() {
		// Log in
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("p4422663331114@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();

		// Add first item
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=40");
		driver.findElement(By.xpath(".//button[@class='btn btn-default'][1]")).click();
		
		// Log out
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		driver.findElement(By.xpath(
				".//ul[@class='dropdown-menu dropdown-menu-right']/li/a[@href='http://server7.pp.ua/index.php?route=account/account']"))
				.click();
		driver.findElement(
				By.xpath(".//a[@class='list-group-item'][@href='http://server7.pp.ua/index.php?route=account/logout']"))
				.click();
		
		// Add second item
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=42");
		driver.findElement(By.xpath(".//button[@class='btn btn-default'][1]")).click();
		
		// Log in
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("p4422663331114@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();
		
		// Open up WishList and delete items
		driver.findElement(By.id("wishlist-total")).click();
		
		// Expected result - WishList should contain 2 items
		// id=40 & id=42
		Assert.assertTrue("Element id=40 is not present in the Wish List", driver.findElements(
				By.xpath(".//a[@href='http://server7.pp.ua/index.php?route=product/product&product_id=40']")).size() > 0);
		Assert.assertTrue("Element id=42 is not present in the Wish List", driver.findElements(
				By.xpath(".//a[@href='http://server7.pp.ua/index.php?route=product/product&product_id=42']")).size() > 0);
		
		// Cleaning after Test-case
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();
		// Check whether WishList is empty
		Assert.assertTrue("Wish List is not empty.", driver.getPageSource().contains("Your wish list is empty."));		
	}
	/*
	+	Log in with username/password
	+	Add item to WishList
	+	Log out
	+	Close browser
	+	Open up browser
	+	Log in with username/password
	+	Open WishList
	+   Expected result - WishList should contain item ID=40
	+	Delete item from WishList
	+	Expected result - WishList should be empty
	 */
	@Test
	public void testWishList5() {
		// Login part
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("p4422663331114@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();
		
		// Add item to WishList
		driver.get("http://server7.pp.ua/index.php?route=product/product&product_id=40");
		driver.findElement(By.xpath(".//button[@class='btn btn-default'][1]")).click();
		
		// Log out
		driver.findElement(By.cssSelector(".fa.fa-user")).click();
		driver.findElement(By.xpath(
				".//ul[@class='dropdown-menu dropdown-menu-right']/li/a[@href='http://server7.pp.ua/index.php?route=account/account']"))
				.click();
		driver.findElement(
				By.xpath(".//a[@class='list-group-item'][@href='http://server7.pp.ua/index.php?route=account/logout']"))
				.click();
		
		// Close and open up browser
		driver.quit();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://server7.pp.ua");
		
		// Login part
		driver.findElement(By.cssSelector(".caret")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("p4422663331114@gmail.com");
		driver.findElement(By.id("input-password")).clear();
		driver.findElement(By.id("input-password")).sendKeys("qwerty123456");
		driver.findElement(By.cssSelector(".btn.btn-primary:not(a)")).click();
		
		// Open up WishList
		driver.findElement(By.id("wishlist-total")).click();
		
		// Expected result - WishList should contain element with id=40
		Assert.assertTrue("Element id=40 is not present in the Wish List",
				driver.findElements(
						By.xpath(".//a[@href='http://server7.pp.ua/index.php?route=product/product&product_id=40']"))
						.size() > 0);
		
		// Cleaning after Test-case
		driver.findElement(By.cssSelector(".btn.btn-danger")).click();		
		// check whether wish list is empty
		Assert.assertTrue("Wish List is not empty.", driver.getPageSource().contains("Your wish list is empty."));
	}
}