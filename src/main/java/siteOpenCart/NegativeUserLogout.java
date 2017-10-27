package siteOpenCart;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Negative tests for site http://server7.pp.ua when User is logout.
 */
public class NegativeUserLogout {
    private static WebDriver driver;

    @BeforeClass
    public static void precondition() {
        System.setProperty("webdriver.chrome.driver",
                "D:/ATQA/selen/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Firefox for classRoom
        //System.setProperty("webdriver.gecko.driver","C:/Program Files/Java/Selenium360/geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://server7.pp.ua/index.php?route=product/product&path=57&product_id=49");
        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[1]/ul[2]/li[2]/a")).click();
    }

    @AfterClass
    public static void end() {
        driver.quit();
    }

    @Test
    public void validFields() throws InterruptedException {
        driver.findElement(By.id("input-name")).clear();
        driver.findElement(By.id("input-name")).click();
        driver.findElement(By.id("input-name")).sendKeys("Name");

        driver.findElement(By.id("input-review")).clear();
        driver.findElement(By.id("input-review")).click();
        driver.findElement(By.id("input-review")).sendKeys("Input valid review there.");

        driver.findElement(By.name("rating")).click();

        driver.findElement(By.id("button-review")).sendKeys(Keys.ENTER);

        Assert.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }
}
