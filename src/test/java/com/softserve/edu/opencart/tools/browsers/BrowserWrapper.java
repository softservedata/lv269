package com.softserve.edu.opencart.tools.browsers;

import com.softserve.edu.opencart.data.applications.IApplicationSource;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BrowserWrapper {

    private interface IBrowser {
        WebDriver getBrowser(IApplicationSource applicationSource);
    }

    private static class Firefox5xTemporary implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("webdriver.gecko.driver",
                    applicationSource.getDriverPath());
            return new FirefoxDriver();
        }
    }

    private static class FirefoxWithoutUI implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("webdriver.gecko.driver",
                    applicationSource.getDriverPath());
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            return new FirefoxDriver(options);
        }
    }

    private static class ChromeTemporary implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("webdriver.chrome.driver",
                    applicationSource.getDriverPath());
            return new ChromeDriver();
        }
    }

    private static class ChromeWithoutUI implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("webdriver.chrome.driver",
                    applicationSource.getDriverPath());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            System.out.println("\t\t\t*** ChromeWithoutUI: new ChromeDriver(options)");
            return driver;
        }
    }

    private static class PhantomJS implements IBrowser {
        public WebDriver getBrowser(IApplicationSource applicationSource) {
            System.setProperty("phantomjs.binary.path",
                    applicationSource.getDriverPath());
            //System.out.println("\t\t\t*** PhantomJS: new PhantomJSDriver()");
            WebDriver driver = new PhantomJSDriver();
            driver.manage().window().maximize();
            return driver;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static enum Browsers {
        DEFAULT_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
        FIREFOX5X_TEMPORARY("FireFox5xTemporary", new Firefox5xTemporary()),
        FIREFOX5X_WITHOUTUI("FireFox5xWithoutUI", new FirefoxWithoutUI()),
        CHROME_TEMPORARY("ChromeTemporary", new ChromeTemporary()),
        CHROME_WITHOUTUI("ChromeWithoutUI", new ChromeWithoutUI()),
        PHANTOM_JS("PhantomJS", new PhantomJS());
        //
        private String browserName;
        private IBrowser browser;

        private Browsers(String browserName, IBrowser browser) {
            this.browserName = browserName;
            this.browser = browser;
        }

        public WebDriver runBrowser(IApplicationSource applicationSource) {
            return browser.getBrowser(applicationSource);
        }

        @Override
        public String toString() {
            return browserName;
        }

    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private WebDriver driver;
    
    public BrowserWrapper(IApplicationSource applicationSource) {
        initWebDriver(applicationSource);
    }
    
    private void initWebDriver(IApplicationSource applicationSource) {
        Browsers currentBrowser = Browsers.DEFAULT_TEMPORARY;
        for (Browsers browser : Browsers.values()) {
            if (browser.toString().toLowerCase()
                    .contains(applicationSource.getBrowserName().toLowerCase())) {
                currentBrowser = browser;
                break;
            }
        }
        driver = currentBrowser.runBrowser(applicationSource);
        // TODO Move to Search Class
        driver.manage().timeouts().implicitlyWait(applicationSource.getImplicitWaitTimeOut(),
                TimeUnit.SECONDS);
    }
    
    // TODO Change to default package 
    public WebDriver getDriver() {
        return driver;
    }

    public JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor)getDriver();
    }

    // TODO Zoom page before take screen or move to element. Yandex Ashot
    //https://github.com/assertthat/selenium-shutterbug
    //document.body.scrollHeight
    //document.body.style.zoom = 0.5
    public File getScreenshot() {
        return ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
    }
    
    public String getSourceCode() {
        return getDriver().getPageSource();   
    }

    public void openUrl(String url) {
        getDriver().get(url);
    }


    public String getUrlPage () {
        return getDriver().getCurrentUrl();
    }

    public void navigateForward() {
        getDriver().navigate().forward();
    }

    public void navigateBack() {
        getDriver().navigate().back();
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void deleteAllCookies() {
    	getDriver().manage().deleteAllCookies();
    }

    public void quit() {
        if (getDriver() != null) {
            getDriver().quit();
            driver = null;
        }
    }

}
