import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class OpenCartTestRegisterFirefox {
    private static Connection connection = null;
    private static final String FIRSTNAME = "TEST_FIRSTNAME";
    private static final String LASTNAME = "TEST_LASTNAME";
    private static final String EMAIL = "test_test@mail.com";
    private static final String TELEPHONE = "380511223344";
    private static final String ADDRESS = "TEST_ADDRESS";
    private static final String CITY = "LVIV";
    private static final String POSTCODE = "79000";
    private static final String PASSWORD = "269lv269lv";
    private static final String CONFIRM = "269lv269lv";
    private static WebDriver driver;

    public void connectToDB() throws SQLException {
        String jdbcUrl = "jdbc:mysql://77.120.103.50:3310/pekelis_db";
        String user = "pekelis_usr";
        String password = "B6y0N7i5";
        connection = DriverManager.getConnection(jdbcUrl, user, password);
    }

    @BeforeClass
    public static void runBrowser() {

        System.setProperty("webdriver.gecko.driver",
                "D:/Eclipse/geckodriver-v0.19.0-win64/geckodriver.exe");

        driver=new FirefoxDriver();

    }

    @AfterClass
    public static void closeWebDriver() {
        driver.quit();
    }


    @After
    public void deleteFromDatabase() {


        try {
            connectToDB();
            String query1 = "DELETE oc,oe FROM oc_customer oc INNER JOIN oc_address oe ON oc.customer_id = oe.customer_id  WHERE email = ?;";
            PreparedStatement pst1 = connection.prepareStatement(query1);
            pst1.setString(1, EMAIL);
            pst1.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void testOpenCartLogInBySubmitMozilla() {

        driver.get("http://server7.pp.ua/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.partialLinkText("Register")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);

        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("telephone")).click();
        driver.findElement(By.name("telephone")).sendKeys(TELEPHONE);

        driver.findElement(By.name("address_1")).clear();
        driver.findElement(By.name("address_1")).click();
        driver.findElement(By.name("address_1")).sendKeys(ADDRESS);

        driver.findElement(By.name("city")).clear();
        driver.findElement(By.name("city")).click();
        driver.findElement(By.name("city")).sendKeys(CITY);

        driver.findElement(By.name("postcode")).clear();
        driver.findElement(By.name("postcode")).click();
        driver.findElement(By.name("postcode")).sendKeys(POSTCODE);

        driver.findElement(By.name("country_id")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Ukraine']")));

        driver.findElement(By.xpath("//option[text()='Ukraine']")).click();


        driver.findElement(By.name("zone_id")).click();


        wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//option[contains(text(),'Oblast')]")));

        driver.findElement(By.xpath("//option[text()=\"L'vivs'ka Oblast'\"]")).click();


        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(PASSWORD);

        driver.findElement(By.name("confirm")).clear();
        driver.findElement(By.name("confirm")).click();
        driver.findElement(By.name("confirm")).sendKeys(CONFIRM);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("agree")).click();

        driver.findElement(By.xpath("//*[@type='submit'][@value='Continue']")).click();


        Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//h1")).getText());
        driver.findElement(By.partialLinkText("My Account")).click();

        driver.findElement(By.linkText("Logout")).click();
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


}
