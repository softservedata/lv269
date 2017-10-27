package siteOpenCart.precondition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://server7.pp.ua");
        driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).sendKeys("wnb58892@sqoai.com");

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).sendKeys("password");

        driver.findElement(By.xpath("html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
        return driver;
    }

    public static void logOut(WebDriver driver) {
        driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("html/body/nav/div/div[2]/ul/li[2]/ul/li[5]/a")).click();
        driver.quit();
    }
}
