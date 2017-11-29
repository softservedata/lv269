package com.softserve.edu;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Browsers {
	private final String TIME_TEMPLATE = "yyyy-MM-dd_HH-mm-ss";
	public static ChromeDriverService service;

	private void takeScreenShot(WebDriver driver) throws IOException {
		String currentTime = new SimpleDateFormat(TIME_TEMPLATE).format(new Date());
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./" + currentTime + "_screenshot.png"));
	}
	
	// Use Selenium 2.x.x
	//@Test
	public void testFirefox1() throws Exception {
		WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		//driver.get("http://regres.herokuapp.com/login");
		//driver.get("http://server7.pp.ua");
		//driver.get("https://auto.ria.com/");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	// Use Selenium 3.x.x
	    //@Test
	    public void testFirefox1_3xx() throws Exception {
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		//element.submit();
		//
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(By.id("navcnt"))).perform();
		Thread.sleep(2000);
		takeScreenShot(driver);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("navcnt")));
		//driver.quit();
	}

	// Using default profile of firefox
	//@Test
	public void testFirefox2() throws Exception {
		ProfilesIni profileIni = new ProfilesIni();
		FirefoxProfile profile = profileIni.getProfile("default");
		//
		profile.setAcceptUntrustedCertificates(true);
		//profile.setAssumeUntrustedCertificateIssuer(false);
		profile.setPreference("app.update.enabled", false);
		//`
		System.setProperty("webdriver.gecko.driver",
				"./lib/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver(profile); // Error for Selenium 3.6
		//
		//File file = new File(path_to_your_firefox_profile); // For 3.6.x
		//FirefoxProfile profile = new FirefoxProfile(file);
        //DesiredCapabilities dc = DesiredCapabilities.firefox();
        //dc.setCapability(FirefoxDriver.PROFILE, profile);
		//WebDriver driver = new FirefoxDriver(dc); // Deprecated
		//
		FirefoxOptions options = new FirefoxOptions()
		        .setProfile(profile);
		        //.setBinary("c:/Program Files/Nightly/firefox.exe")
		        //.addArguments("-console")
		        //.addPreference("browser.cache.disk.enable", false)
		        //.addCapabilities(new DesiredCapabilities(ImmutableMap.of("pageLoadStrategy", "eager")));
		WebDriver driver = new FirefoxDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
//		(new WebDriverWait(driver, 5)).until(ExpectedConditions
//				.visibilityOfElementLocated(By.linkText("2")));
		takeScreenShot(driver);
		driver.quit();
	}

	// Use UntrustedCertificates
    //@Test
    public void testFirefox3() throws Exception {
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        //System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        //WebDriver driver = new FirefoxDriver(capabilities);
        //
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(options);
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://192.168.195.249/Index#/Home");
        Thread.sleep(2000);
        takeScreenShot(driver);
        driver.quit();
    }

	//@Test
	public void testFirefox4() throws Exception {
		FirefoxProfile profile = new FirefoxProfile();
		//File file = new File("lib/firepath-0.9.7.1-fx.xpi");
		File file = new File("./lib/firebug-2.0.19-fx.xpi");
		profile.addExtension(file);
		//
		profile.setAcceptUntrustedCertificates(true);
		profile.setPreference("extensions.firebug.currentVersion",
		        "2.0.19");
		//
        System.setProperty("webdriver.gecko.driver",
                "./lib/geckodriver.exe");     // not working with firefox 53.0.3
		//WebDriver driver = new FirefoxDriver(profile);
		//WebDriver driver = new FirefoxDriver();
        FirefoxOptions options = new FirefoxOptions()
                .setProfile(profile);
        WebDriver driver = new FirefoxDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		// driver.quit();
	}

	// @Test
	public void testFirefox5() throws Exception {
	}

	//@Test
	public void testInternetExplorer1() throws Exception {
		System.setProperty("webdriver.ie.driver",
				"./lib/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test
	public void testInternetExplorer2() throws Exception {
		System.setProperty("webdriver.ie.driver",
				"./lib/IEDriverServer.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//WebDriver driver = new InternetExplorerDriver(capabilities);
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		options.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		WebDriver driver = new InternetExplorerDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test
	public void testChrome1() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
	    Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("navcnt"))).perform();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test
	public void testChrome2() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--start-fullscreen");
		// options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		//
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	//@Test
	public void testChrome2_1Certificate() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");  // Work by default!!!
		// options.addArguments("--disable-extensions");
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://192.168.195.249/Index#/Home");
        //driver.get("https://ita.edu.softserveinc.com/");
		//driver.get("http://www.google.com");
		//WebElement element = driver.findElement(By.name("q"));
		//element.sendKeys("Cheese!");
		//element.submit();
		//
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	// Don't use by Windows
	//@Test
	public void testChrome3UserProfile() throws Exception {
		System.out.println("HOME_PATH getenv = "
				+ System.getenv("HOMEPATH"));
		// System.out.println("HOME_PATH Property = " +
		// System.getProperty("HOMEPATH"));
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		// String userProfile =
		// "C:\\Users\\yharasym\\AppData\\Local\\Google\\Chrome\\User
		// Data\\Default\\";
		String userProfile = System.getenv("HOMEPATH")
                + "\\AppData\\Local\\Google\\Chrome\\User Data";
				//+ "\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";
		System.out.println("PATH: " + userProfile);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		// options.addArguments("--disable-extensions");
		//options.addArguments("\""+"user-data-dir=" + userProfile+"\""); // Work in Linux, MacOS, etc. Do not working on Windows.
		options.addArguments("--user-data-dir=" + userProfile); // Working in Windows.
		//options.addArguments("--user-data-dir=" + userProfile); // Work in Linux, MacOS, etc. Do not working on Windows.
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		//driver.quit();
	}

	//@Test
	public void testChrome4() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"./lib/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		// options.addArguments("--no-sandbox");
		// options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		// options.addArguments("--disable-extensions");
		//
		// WebDriver driver = new ChromeDriver(options);  // Comment
		//
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		//options.setBinary("C:\\Windows\\system32\\calc.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		//WebDriver driver = new ChromeDriver(capabilities);
		WebDriver driver = new ChromeDriver(options);
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(2000);
		takeScreenShot(driver);
		driver.quit();
	}

	// Chrome Without UI
	//@Test
    public void testChrome5() throws Exception {
        // Firefox https://developer.mozilla.org/en-US/Firefox/Headless_mode
        // Chrome https://peter.sh/experiments/chromium-command-line-switches/
        System.setProperty("webdriver.chrome.driver",
                "./lib/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
        System.out.println("\tdriver.get http://www.google.com DONE");
        System.out.println("\tCurrent title is: " + driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        Thread.sleep(1000);
        System.out.println("\telement.sendKeys Cheese! DONE");
        System.out.println("\tPage title is: " + driver.getTitle());
        Thread.sleep(2000);
        takeScreenShot(driver);
        driver.quit();
    }

	// Use Selenium 2.52; Must be fixed for 3.x.x
	//@Test
	public void testHtmlUnit() throws Exception {
		//WebDriver driver = new FirefoxDriver();
		WebDriver driver = new HtmlUnitDriver(true);
		((HtmlUnitDriver) driver).setJavascriptEnabled(true); // Enable CSS
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.titleContains("Cheese"));
		// (new WebDriverWait(driver, 5)).until(
		// ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());
		//
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
        System.out.println("\tPage title is: " + driver.getTitle());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		// Thread.sleep(2000);
		//takeScreenShot(driver); // Do not use!!!
		// driver.quit();
		driver.quit();
	}

	// Download from http://phantomjs.org/download.html
	// Use Selenium 3.0.1, 3.x.x; Do not use Selenium 2.5.x
	//@Test
	public void testPhantomjs() throws Exception {
		System.setProperty("phantomjs.binary.path",
				"./lib/phantomjs.exe");
		WebDriver driver = new PhantomJSDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		System.out.println("\tdriver.get http://www.google.com DONE");
		System.out.println("\tCurrent title is: " + driver.getTitle());
		Thread.sleep(1000);
		//
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		System.out.println("\telement.sendKeys Cheese! DONE");
		System.out.println("\tPage title is: " + driver.getTitle());
		element.submit();
		Thread.sleep(1000);
		// WebDriverWait wait = new WebDriverWait(driver, 5);
		// wait.until(ExpectedConditions.titleContains("Cheese"));
		// (new WebDriverWait(driver, 5)).until(
		// ExpectedConditions.titleContains("Cheese"));
		System.out.println("\tPage title is: " + driver.getTitle());
		//
		System.out.println("\tTaking First Screenshot ...");
		Thread.sleep(2000);
		takeScreenShot(driver);
		//
		driver.findElement(By.partialLinkText("Cheese - Wikipedia")).click();
		System.out.println("\tELEMENT IS " + driver.findElement(By.id("firstHeading")).getText());
		Assert.assertEquals(driver.findElement(By.id("firstHeading")).getText(), "Cheese");
		//
		System.out.println("\tTaking Second Screenshot ...");
		//File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(scrFile, new File("./screenshot1.png"));
		Thread.sleep(2000);
		takeScreenShot(driver);
		System.out.println("\tDone Screenshot");
		//
		// driver.quit();
		driver.quit();
	}

	@BeforeClass
	public void createService() throws Exception {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("./lib/chromedriver.exe"))
				// .usingAnyFreePort()
				.usingPort(8888).build();
		service.start();
		System.out.println("\t+++Service Start");
	}

	@Test
	public void testRemout() throws Exception {
		//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--no-proxy-server");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-web-security");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-extensions");
		// WebDriver driver = new ChromeDriver(options);
		//
		options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		//
		// WebDriver driver = new RemoteWebDriver(new URL("127.0.0.1:8888"),
		// capabilities);
		WebDriver driver = new RemoteWebDriver(service.getUrl(), capabilities);
		System.out.println("\t+++RemoteWebDriver Start, service.getUrl()=" + service.getUrl());
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		Thread.sleep(4000);
		takeScreenShot(driver);
		driver.quit();
		System.out.println("\t+++driver.quit()");
	}

	@AfterClass
	public void StopService() {
		if (service != null) {
			service.stop();
			System.out.println("\t+++RemoteWebDriver Stop");
		}
	}

}
