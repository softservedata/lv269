package com.softserve.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.tools.EnvironmentVariables;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    private boolean isTestComplete;

    @Test
    public void testApp1() throws Exception {
        System.out.println("surefire.reports.directory = "
                + System.getProperty("surefire.reports.directory"));
        System.out.println("selenium-version = "
                + System.getProperty("selenium-version"));
        //
        //String databaseConnection = System.getProperty("database-connection");
        String databaseConnection = System.getenv("DATABASE_CONNECTION");
        //String databaseConnection = System.getenv("JAVA_HOME");
        String databaseLogin = System.getProperty("database-login");
        String databasePassword = System.getProperty("database-password");
        System.out.println("databaseConnection: " + databaseConnection);
        System.out.println("databaseLogin: " + databaseLogin);
        System.out.println("databasePassword: " + databasePassword);
        //
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        EnvironmentVariables environmentVariables = new EnvironmentVariables();
        String URL = environmentVariables.getDatabaseConnection();
        String username = environmentVariables.getDatabaseLogin();
        String password = environmentVariables.getDatabasePassword();
        Connection con = DriverManager.getConnection(URL, username, password);
        if (con != null) {
            System.out.println("Connection Successful! \n");
        }
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from oc_customer_login;");
        int columnCount = rs.getMetaData().getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }
        System.out.println();
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }
        System.out.println();
        if (rs != null) {
            rs.close(); }
        if (st != null) {
            st.close(); }
        if (con != null) {
            con.close(); }
        System.out.println("DONE");
        //
        Assert.assertTrue(true);
    }

    //@BeforeMethod
    public void setUp() throws Exception {
        System.out.println("CalcTest @Before setUp()");
        isTestComplete = false;
    }

    //@AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        Reporter.setCurrentTestResult(result);
        System.out.println("CalcTest @After tearDown()");
        Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>@AfterMethod Non Conditional.</FONT><BR>",true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 3</FONT><BR>",3,true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 5</FONT><BR>",5);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>@AfterMethod Level 7</FONT><BR>",7,true);
        if (!isTestComplete) {
            Reporter.log("<BR><BR><FONT SIZE='4' COLOR='BLUE'>ALARM TEST FAIL</FONT><BR>",true);    
        }
    }

    //@Test
    public void testApp2() {
        Reporter.log("<BR><FONT SIZE='4' COLOR='RED'>Non Conditional.</FONT><BR>",true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 3</FONT><BR>",3,true);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 5</FONT><BR>",5);
        Reporter.log("<BR><FONT SIZE='4' COLOR='BLUE'>Level 7</FONT><BR>",7,true);
        System.out.println("Running . . .");
//      ReporterWrapper.get().debug("DEBUG - messages");
//      ReporterWrapper.get().info("INFO - messages");
//      ReporterWrapper.get().warning("WARNING - messages");
//      ReporterWrapper.get().error("ERROR - messages");
        //Assert.assertTrue(false);
        Assert.assertTrue(true);
        isTestComplete = true;
    }
    
    //@Test
    public void testApp3() {
        logger.info("\t+++testApp3() DONE");
        Reporter.log("\t+++testApp3() must be", true);
        Reporter.log("\t+++testApp3() 3", 3, true);
        Reporter.log("\t+++testApp3() 5", 5, true);
        Reporter.log("\t+++testApp3() 7", 7, true);
        Reporter.log("\t+++testApp3() 9", 9, true);
        System.out.println("\t+++testApp3() DONE");
        //WebDriver driver = new HtmlUnitDriver();
        isTestComplete = true;
    }

}
