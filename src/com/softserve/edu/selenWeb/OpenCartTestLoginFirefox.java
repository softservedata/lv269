import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Connection;
import java.util.concurrent.TimeUnit;

public class OpenCartTestLoginFirefox {
    private static final String EMAIL = "lv_269_test@ukr.net";
    private static final String PASSWORD = "269lv269lv";

    private static WebDriver driver;

    private static final String FIRSTNAME = "TEST_WRONG_FIRSTNAME";
    private static final String LASTNAME = "TEST__WRONG_LASTNAME";
    private static final String TELEPHONE = "380511223344";
    private static final String ADDRESS = "TEST_ADDRESS";
    private static final String CITY = "LVIV";
    private static final String POSTCODE = "79000";
    private static final String CONFIRM = "269lv269lv";
    private static Connection connection = null;

    @BeforeClass
    public static void runBrowser() {
        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void closeWebDriver() {

        driver.quit();
    }


    @Test
    public void testOpenCartLogInBySubmitMozilla() throws InterruptedException {

        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.partialLinkText("Login")).click();

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.name("password")).submit();

        driver.findElement(By.linkText("Edit Account")).click();
        Assert.assertEquals(EMAIL, driver.findElement(By.name("email")).getAttribute("value"));

        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();

    }


    @Test
    public void testOpenCartLogInByButtonMozilla() throws InterruptedException {


        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.xpath("//*[@type='submit'] [@value='Login'] [@class='btn btn-primary']")).click();


        driver.findElement(By.linkText("Edit Account")).click();
        Assert.assertEquals(EMAIL, driver.findElement(By.name("email")).getAttribute("value"));

        driver.findElement(By.partialLinkText("My Account")).click();
        driver.findElement(By.linkText("Logout")).click();


    }


}
