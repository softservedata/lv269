package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.data.users.IUser;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.LoginPage;
import com.softserve.edu.opencart.pages.user.LogoutPage;
import com.softserve.edu.opencart.tools.BrowserWrapper;
import com.softserve.edu.opencart.tools.DataBaseWraper;

import java.sql.SQLException;

public class Application {

    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    private BrowserWrapper browser;
    private DataBaseWraper dataBase;
    // etc.

    private Application(IApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
        initBrowser(applicationSource);
        initDataBase(applicationSource);

        // initSearchStrategy();
        // initAccessToDB();
    }

    public static Application get() {
        return get(null);
    }

    public static Application get(IApplicationSource applicationSource) {
        if (instance == null) {
            synchronized (Application.class) {
                if (instance == null) {
                    if (applicationSource == null) {
                        applicationSource = ApplicationSourceRepository.get().base();
                    }
                    instance = new Application(applicationSource);
                }
            }
        }
        return instance;
    }

    public static void remove() {
        if (instance != null) {
            // TODO Change for parallel work
            instance.getBrowser().quit();
            instance = null;
        }
    }

    public static void closeConnection() throws SQLException {
        if (instance != null) {
            instance.getDataBase().close();
        }
    }

    // TODO Change for parallel work
    public IApplicationSource getApplicationSources() {
        return applicationSource;
    }

    // TODO Change for parallel work
    public BrowserWrapper getBrowser() {
        return browser;
    }

    // TODO Change for parallel work
    public void initBrowser(IApplicationSource applicationSource) {
        this.browser = new BrowserWrapper(applicationSource);
    }

    public HomePage loadHomePage() {
        getBrowser().openUrl(applicationSource.getBaseUrl());
        // TODO Remove getBrowser().getDriver()
        return new HomePage(getBrowser().getDriver());
    }
    
    public void deleteAllCookies() {
    	getBrowser().deleteAllCookies();
    }

    public LoginPage login() {
        getBrowser().openUrl(applicationSource.getUserLoginUrl());
        return new LoginPage(getBrowser().getDriver());
    }

    public LogoutPage logout() {
        getBrowser().openUrl(applicationSource.getUserLogoutUrl());
        return new LogoutPage(getBrowser().getDriver());
    }

    public void initDataBase(IApplicationSource applicationSource) {
        this.dataBase = new DataBaseWraper();
    }


    public DataBaseWraper getDataBase() {
        return dataBase;
    }

    public void executeQuery(String query) throws SQLException {
        getDataBase().executeQuery(query);
    }

    public void unlockUserByQuery(IUser user, String query) throws SQLException {
        System.out.println(String.format(query, user.getEmail()));
        getDataBase().executeQuery(String.format(query, user.getEmail()));

    }

}
