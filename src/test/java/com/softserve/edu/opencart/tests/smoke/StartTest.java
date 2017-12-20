package com.softserve.edu.opencart.tests.smoke;

import java.lang.reflect.Field;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.data.users.UserRepository;
import com.softserve.edu.opencart.pages.Application;
import com.softserve.edu.opencart.pages.user.RegAccBlg;
import com.softserve.edu.opencart.pages.user.StartBlg;
import com.softserve.edu.opencart.pages.user.StartElm;
import com.softserve.edu.opencart.tests.TestRunner;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest({ StartTest.class })
public class StartTest extends TestRunner {
    
    @DataProvider//(parallel = true)
    public Object[][] searchData() {
        return new Object[][] { 
            { "MacBook"},
            { "iPhone"},
            //{ "Canon EOS 5D"},
            };
    }

    //@Test(dataProvider = "searchData")
    public void checkSearchProduct(String text) throws Exception {
        //
        // Precondition
        //
        //System.setProperty("webdriver.chrome.driver",
        //        "C:/Program Files/Java/Selenium360/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        //driver.get("http://server7.pp.ua");
        //Thread.sleep(1000);
        //
        Application.get().loadHomePage();
        StartBlg startBlg = new StartBlg();
        Thread.sleep(1000);
        //
        // Steps
        //
        startBlg = startBlg.searchBytext(text);
        Thread.sleep(1000);
        //
        // Check
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        Assert.assertEquals(startBlg.getStartOpr().getSearchProductFieldText(), text);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        //driver.quit();
    }

    @DataProvider//(parallel = true)
    public Object[][] registerUser() {
        return new Object[][] { 
            { UserRepository.get().newUser() },
            };
    }

    //@Test(dataProvider = "registerUser")
    public void checkRegisterUser(IUser newUser) throws Exception {
        //
        // Precondition
        //
        //System.setProperty("webdriver.chrome.driver",
        //        "C:/Program Files/Java/Selenium360/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        //driver.get("http://server7.pp.ua");
        //Thread.sleep(1000);
        //
        Application.get().loadHomePage();
        StartBlg startBlg = new StartBlg();
        Thread.sleep(1000);
        //
        // Steps
        //
        RegAccBlg regAccBlg = startBlg.gotoRegAccBlg();
        Thread.sleep(1000);
        startBlg = regAccBlg.registerUser(newUser);
        Thread.sleep(1000);
        //
        // Check
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        //Assert.assertEquals(startBlg.getStartOpr().getSearchProductFieldText(), text);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        //driver.quit();
    }

    @Test(dataProvider = "registerUser")
    public void checkRegisterUserMock(IUser newUser) throws Exception {
        //
        // Precondition
        //
        //System.setProperty("webdriver.chrome.driver",
        //        "C:/Program Files/Java/Selenium360/chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //
        //driver.get("http://server7.pp.ua");
        //Thread.sleep(1000);
        //
        Application.get().loadHomePage();
        // Ok
        //StartBlg startBlg = new StartBlg();
        //StartBlg startBlg = Mockito.mock(StartBlg.class);
        //RegAccBlg regAccBlgmock = Mockito.mock(RegAccBlg.class);
        //Mockito.when(startBlg.gotoRegAccBlg()).thenReturn(regAccBlgmock);
        //Mockito.doCallRealMethod().when(startBlg).searchBytext("Mac");
        //
        // Ok
        //StartBlg startBlg = Mockito.spy(new StartBlg());
        //Mockito.when(startBlg.getResult()).thenReturn(2);
        //System.out.println("+++++ res= " + startBlg.getResult());
        //
        // Ok
        //StartBlg startBlg = Mockito.spy(new StartBlg());
        //StartOpr startOprMock = Mockito.mock(StartOpr.class);
        //Mockito.when(startBlg.getStartOpr()).thenReturn(startOprMock);
        //
        // Ok
        //StartOpr startOprMock = PowerMockito.mock(StartOpr.class);
        //StartBlg startBlg = new StartBlg(startOprMock);
        //
        // Not Ok
        //StartBlg startBlg = Mockito.spy(new StartBlg());
        //StartElm startElmMock = Mockito.mock(StartElm.class);
        //Mockito.when(startBlg.getStartOpr().getStartElm()).thenReturn(startElmMock);
        //
        // Not Ok
        //StartBlg startBlg = new StartBlg();
        //StartOpr startOpr = startBlg.getStartOpr();
        //StartElm startElmMock = Mockito.mock(StartElm.class);
        //Mockito.when(Mockito.spy(startOpr).getStartElm()).thenReturn(startElmMock);
        //
        // Not Ok
        //StartBlg startBlg = Mockito.spy(new StartBlg());
        //StartElm startElm = Mockito.mock(StartElm.class);
        //Mockito.doCallRealMethod().when(startElm).getSearch();
        //Mockito.doCallRealMethod().when(startElm).getSearchProductField();
        //StartOpr startOpr = Mockito.spy(startBlg.getStartOpr());
        //Mockito.when(startOpr.getStartElm()).thenReturn(startElm); // ERROR. Do not working!
        //
        // Not Ok
        //StartOpr startOpr = PowerMockito.mock(StartOpr.class);
        //PowerMockito.whenNew(StartOpr.class).withNoArguments().thenReturn(startOpr);
        //PowerMockito.whenNew(StartOpr.class).withNoArguments().thenReturn(PowerMockito.mock(StartOpr.class));
        //StartBlg startBlg = new StartBlg();
        //
        // Not Ok
        //StartBlg startBlg = PowerMockito.spy(new StartBlg());
        //StartElm startElm = PowerMockito.mock(StartElm.class);
        //Mockito.doCallRealMethod().when(startElm).getSearch();
        //Mockito.doCallRealMethod().when(startElm).getSearchProductField();
        //StartOpr startOpr = PowerMockito.spy(startBlg.getStartOpr());
        //PowerMockito.when(startOpr.getStartElm()).thenReturn(startElm); // ERROR. Do not working!
        //
        // Ok +/-
        StartBlg startBlg = new StartBlg();
        StartElm startElm = Mockito.mock(StartElm.class);
        Mockito.doCallRealMethod().when(startElm).getSearch();
        Mockito.doCallRealMethod().when(startElm).getSearchProductField();
        Mockito.doCallRealMethod().when(startElm).getSearchProductButton();
        Field field = startBlg.getStartOpr().getClass().getDeclaredField("startElm");
        field.setAccessible(true);
        field.set(startBlg.getStartOpr(), startElm);
        //System.out.println("startElm = " + startElm);
        //System.out.println("startElm2 = " + startBlg.getStartOpr().getStartElm());
        //
        Thread.sleep(1000);
        //
        // Steps
        //
        //startBlg = startBlg.searchBytext("Mac");
        startBlg.searchBytext("Mac");
        Thread.sleep(3000);
        //
        RegAccBlg regAccBlg = startBlg.gotoRegAccBlg();
        Thread.sleep(1000);
        //startBlg = regAccBlg.registerUser(newUser);
        //Thread.sleep(1000);
        //
        // Check
        //
        //Mockito.verify(startBlg).searchBytext("Mac");
        //Mockito.verify(startBlg).gotoRegAccBlg();
        //
        //Mockito.verify(startElm).getSearchProductField();
        //
        //Assert.assertEquals(actualPrice, expectedPrice, 0.001);
        // TODO getPrices(detailCurency)
        //Assert.assertEquals(startBlg.getStartOpr().getSearchProductFieldText(), text);
        Thread.sleep(1000);
        //
        // Return to previous state
        //
        //Thread.sleep(2000);
        //driver.quit();
    }
}
