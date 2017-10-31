package siteOpenCart.precondition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Class include methods for tests when User login.
 */
public class PreconditionUserLogin {

    public static WebDriver precondition() {

        // Firefox for classRoom
        //System.setProperty("webdriver.gecko.driver","C:/Program Files/Java/Selenium360/geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();

        System.setProperty("webdriver.chrome.driver",
                "D:/ATQA/selen/chromedriver_win32/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://server7.pp.ua");
        driver.findElement(By.cssSelector("a[href$='account/account']")).click();
        driver.findElement(By.cssSelector("a[href$='account/login']")).click();

        Util.inputInField(driver.findElement(By.id("input-email"))).sendKeys("wnb58892@sqoai.com");
        Util.inputInField(driver.findElement(By.id("input-password"))).sendKeys("password"+ Keys.ENTER);

        driver.get("http://server7.pp.ua/index.php?route=product/product&path=57&product_id=49");
        driver.findElement(By.partialLinkText("review")).click();
        return driver;
    }

    public static void logOut(WebDriver driver) {
        driver.findElement(By.cssSelector("a[href$='account/account']")).click();
        driver.findElement(By.cssSelector("a[href$='account/logout']")).click();

        driver.quit();
    }
}
