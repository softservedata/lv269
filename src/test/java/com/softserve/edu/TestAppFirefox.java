//package com.softserve.edu;
//
//import java.util.concurrent.TimeUnit;
//import org.junit.Assert;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
///**
// * @author Yura Ivanytsky
// *
// * @version 1.0
// */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class TestAppFirefox {
//
//	private static WebDriver driver;
//	/**
//	 * Equivalent rate of Euro to Dollar
//	 */
//	private final double EURO = 0.860126267;
//	/**
//	 * Equivalent rate of Pound Sterling to Dollar
//	 */
//	private final double POUND = 0.758035173;
//	/**
//	 * Equivalent rate of Euro to Pound Sterling
//	 */
//	private final double EUROPOUND = 0.881306853;
//
//	/**
//	 * This method create a web driver for FireFox browser and go over to the link
//	 * of application
//	 */
//	@BeforeClass
//	public static void before() {
//		System.setProperty("webdriver.gecko.driver", "C://selenium/geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://server7.pp.ua/");
//	}
//
//	/**
//	 * This method quit the driver
//	 */
//	@AfterClass
//	public static void after() {
//		driver.quit();
//	}
//
//	/**
//	 * This method chooses a currency in Dollars
//	 */
//	@Before
//	public void beforeMethod() {
//		driver.findElement(By.xpath(".//*[@id='form-currency']//button")).click();
//		driver.findElement(By.name("USD")).click();
//	}
//
//	/**
//	 * This method chooses a currency in Dollars
//	 */
//	@After
//	public void afterMethod() {
//		driver.findElement(By.xpath(".//*[@id='form-currency']//button")).click();
//		driver.findElement(By.name("USD")).click();
//	}
//
//	/**
//	 * Checks whether there is a button 'Currency'
//	 */
//	@Test
//	public void testASmoke() {
//		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='form-currency']//button")).isEnabled());
//	}
//
//	/**
//	 * This method checks whether the currency has changed from Dollar to Euro
//	 */
//	@Test
//	public void testBDollarToEuro() {
//		String expected = driver.findElement(By.xpath(".//*[@id='content']//p[2]")).getText();
//		expected = expected.substring(1, expected.indexOf("E"));
//		double expectValue = Double.parseDouble(expected) * EURO;
//		expected = String.format("%.2f", expectValue);
//		driver.findElement(By.xpath(".//*[@id='form-currency']//button")).click();
//		driver.findElement(By.name("EUR")).click();
//		String actual = driver.findElement(By.xpath(".//*[@id='content']//p[2]")).getText();
//		String euroSymbol = actual.substring(actual.length() - 1, actual.length());
//		Assert.assertTrue("Actual symbol doesn`t equal to the expected symbol", euroSymbol.equalsIgnoreCase("€"));
//		String euroValue = actual.substring(0, actual.indexOf("€"));
//		double actualValue = Double.parseDouble(euroValue);
//		actual = String.format("%.2f", actualValue);
//		Assert.assertTrue("Actual value doesn`t equal to the expected value", actual.equals(expected));
//	}
//
//	/**
//	 * This method checks whether the currency has changed from Dollar 
//	 * to Pound Sterling
//	 */
//	@Test
//	public void testCDollarToPound() {
//		String expected = driver.findElement(By.xpath(".//*[@id='content']//p[2]")).getText();
//		expected = expected.substring(1, expected.indexOf("E"));
//		double expectValue = Double.parseDouble(expected) * POUND;
//		expected = String.format("%.2f", expectValue);
//		driver.findElement(By.xpath(".//*[@id='form-currency']//button")).click();
//		driver.findElement(By.name("GBP")).click();
//		String actual = driver.findElement(By.xpath(".//*[@id='content']//p[2]")).getText();
//		String poundSymbol = actual.substring(0, 1);
//		Assert.assertTrue("Actual symbol doesn`t equal to the expected symbol", poundSymbol.equalsIgnoreCase("£"));
//		String poundValue = actual.substring(1, actual.indexOf("E"));
//		double actualValue = Double.parseDouble(poundValue);
//		actual = String.format("%.2f", actualValue);
//		Assert.assertTrue("Actual value doesn`t equal to the expected value", actual.equals(expected));
//	}
//
//	/**
//	 * This method checks whether the currency has changed from Euro 
//	 * to Pound Sterling
//	 */
//	@Test
//	public void testDEuroToPound() {
//		driver.findElement(By.xpath(".//*[@id='form-currency']//button")).click();
//		driver.findElement(By.name("EUR")).click();
//		String expected = driver.findElement(By.xpath(".//*[@id='content']//p[2]")).getText();
//		expected = expected.substring(0, expected.indexOf("€"));
//		double expectValue = Double.parseDouble(expected) * EUROPOUND;
//		expected = String.format("%.2f", expectValue);
//		driver.findElement(By.xpath(".//*[@id='form-currency']//button")).click();
//		driver.findElement(By.name("GBP")).click();
//		String actual = driver.findElement(By.xpath(".//*[@id='content']//p[2]")).getText();
//		String poundSymbol = actual.substring(0, 1);
//		Assert.assertTrue("Actual symbol doesn`t equal to the expected symbol", poundSymbol.equalsIgnoreCase("£"));
//		String poundValue = actual.substring(1, actual.indexOf("E"));
//		double actualValue = Double.parseDouble(poundValue);
//		actual = String.format("%.2f", actualValue);
//		Assert.assertTrue("Actual value doesn`t equal to the expected value", actual.equals(expected));
//	}
//
//}
