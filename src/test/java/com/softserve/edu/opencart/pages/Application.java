package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.LogoutPage;
import com.softserve.edu.opencart.tools.BrowserWrapper;
import com.softserve.edu.opencart.tools.DataBaseWraper;
import com.softserve.edu.opencart.tools.ISearch;
import com.softserve.edu.opencart.tools.ReporterWrapper;
import com.softserve.edu.opencart.tools.Search;

import java.sql.SQLException;

public class Application {
    private final String DELETE_UNBLOCK_USER = "DELETE FROM oc_customer_login WHERE email  = '%s';";
    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    private ReporterWrapper reporter;
    private BrowserWrapper browser;
    private DataBaseWraper dataBase;
    private ISearch search;
    // etc.

    private Application(IApplicationSource applicationSource)   {
        this.applicationSource = applicationSource;
    }

    public static Application get()   {
        return get(null);
    }

    public static Application get(IApplicationSource applicationSource)  {
        if (instance == null) {
            synchronized (Application.class) {
                if (instance == null) {
                    if (applicationSource == null) {
                        applicationSource = ApplicationSourceRepository.get().base();
                    }
                    instance = new Application(applicationSource);
                    instance.initReporter(applicationSource);
                    instance.initBrowser(applicationSource);
                    instance.initSearch(applicationSource);
                    instance.initDataBase(applicationSource);
                    // initAccessToDB();
                }
            }
        }
        return instance;
    }

    public static void remove() {
        if (instance != null) {
            // TODO Change for parallel work
            instance.browser().quit();
            instance = null;
        }
    }

    public static void closeDB()  {
        if (instance != null) {
            instance.getDataBase().close();
        }
    }

    // TODO Change for parallel work
    public IApplicationSource getApplicationSource() {
        return applicationSource;
    }

    public ReporterWrapper reporter() {
        return reporter;
    }

    public BrowserWrapper browser() {
        return browser;
    }
    
    public ISearch search() {
        return search;
    }

    // TODO Change for parallel work
    public void initReporter(IApplicationSource applicationSource) {
        this.reporter = new ReporterWrapper(applicationSource);
    }

    public void initBrowser(IApplicationSource applicationSource) {
        this.browser = new BrowserWrapper(applicationSource);
    }
    
    public void initSearch(IApplicationSource applicationSource) {
        this.search = new Search(applicationSource);
    }

    public HomePage loadHomePage() {
        browser().openUrl(applicationSource.getBaseUrl());
        // TODO Remove getBrowser().getDriver()
        //return new HomePage(browser().getDriver());
        return new HomePage();
    }

    public LoginPage login() {
    	browser().openUrl(applicationSource.getUserLoginUrl());
        //return new LoginPage(getBrowser().getDriver());
        return new LoginPage();
    }

    public LogoutPage logout() {
    	browser().openUrl(applicationSource.getUserLogoutUrl());
        //return new LogoutPage(getBrowser().getDriver());
        return new LogoutPage();
    }

    public void initDataBase(IApplicationSource applicationSource)   {
        this.dataBase = new DataBaseWraper();
    }


    public DataBaseWraper getDataBase() {
        return dataBase;
    }

    public void executeQuery(String query)   {
        getDataBase().executeQuery(query);
    }

    public void unlockUserByQuery(IUser user)   {
        getDataBase().executeQuery(String.format(DELETE_UNBLOCK_USER, user.getEmail()));
    }

}
