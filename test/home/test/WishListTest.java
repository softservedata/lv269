package home.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListTest {
	private static WebDriver driver;
	private static WishListModules module;
	private String testPage = "http://server7.pp.ua/";
	private List<Integer> items = new ArrayList<>();

	@BeforeClass
	public static void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		module = new WishListModules(driver);
	}

	@AfterClass
	public static void afterClass() {
		driver.quit();
	}

	@Before
	public void beforeTestWishList() {
		driver.get(testPage);
	}

	@After
	public void afterTestWishList() {
		if (!module.isLoggedIn()) {
			module.logIn();
		}
		if (!module.isWishListOpened()) {
			module.openWishList();
		}
		if (!module.isWishListEmpty()) {
			module.doWishListEmpty();
		}
		module.logOut();
		driver.get(testPage);
		driver.manage().deleteAllCookies();
		items.clear();
	}

	@Test
	public void testWishList0() {
		module.logIn();
		module.addItem(40);
		module.openWishList();
		module.doWishListEmpty();

		Assert.assertTrue("Wish List is not empty.", module.isWishListEmpty());
	}

	@Test
	public void testWishList1() {
		module.addItem(40);
		module.openWishList();

		// Wait until new page load
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.urlContains("/login"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Assert.assertTrue("This is not login page.", driver.getCurrentUrl().contains("/login"));
	}

	@Test
	public void testWishList2() {
		module.addItem(40);
		module.logIn();
		items.add(40);
		module.openWishList();

		Assert.assertEquals("Elements are not equal", items, module.getItemsFromWishList());
	}

	@Test
	public void testWishList3() {
		module.logIn();
		module.addItem(40);
		items.add(40);
		module.logOut();
		module.openWishList();

		Assert.assertTrue("This is not login page.", driver.getCurrentUrl().contains("/login"));
	}

	@Test
	public void testWishList4() {
		module.logIn();
		module.addItem(40);
		items.add(40);
		module.logOut();
		module.addItem(41);
		module.logIn();
		items.add(41);
		module.openWishList();

		Assert.assertEquals("Elements are not equals", items, module.getItemsFromWishList());
	}

	@Test
	public void testWishList5() {
		module.logIn();
		module.addItem(40);
		items.add(40);
		module.logOut();

		// Clear cookies
		driver.manage().deleteAllCookies();
		driver.navigate().to(testPage);

		module.logIn();
		module.openWishList();

		Assert.assertEquals("Elements are not equals", items, module.getItemsFromWishList());
	}
	
	@Test
	public void testWhishListIndicator() {
		module.logIn();
		for (int id = 43; id < 50; id++) {
			module.addItem(id);
			items.add(id);
		}

		Assert.assertEquals("Wish List header counter incorrect", items.size(), module.getWishListItemsCount());
	}
}