package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.pages.admin.LogoutAdminPage;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tools.*;

import java.util.List;

public class Application {

    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    private BrowserWrapper browser;

    private Search search;
    private FileManager fileManager;
    private String token;
    // etc.

    private Application(IApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
        // initAccessToDB();
    }

    private void initSearchStrategy(IApplicationSource applicationSource) {
        this.search = new Search(applicationSource);
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
                    instance.initBrowser(applicationSource);
                    instance.initSearchStrategy(applicationSource);
                    instance.initFileManager(applicationSource);
                }
            }
        }
        return instance;
    }

    private void initFileManager(IApplicationSource applicationSource) {
        fileManager = new FileManager();
    }

    public static void remove() {
        if (instance != null) {
            // TODO Change for parallel work
            instance.getBrowser().quit();
            instance = null;
        }
    }

    // TODO Change for parallel work
    public IApplicationSource getApplicationSource() {
        return applicationSource;
    }

    // TODO Change for parallel work
    //TODO Delete 3 methods below
    public BrowserWrapper getBrowser() {
        return browser;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public Search search() {
        return search;
    }

    //TODO Remake it by rules without magic numbers and symbols, with saving in the proper place
    public void setToken () {
        token = "&" + TextUtils.splittoList(getBrowser().getUrlPage(), "&").get(1);
    }

    private String getToken () {
        return token;
    }

    // TODO Change for parallel work
    public void initBrowser(IApplicationSource applicationSource) {
        this.browser = new BrowserWrapper(applicationSource);
    }

    //TODO Change it after demo
    public void initSearchManager(IApplicationSource applicationSource) {
        this.search = new Search(applicationSource);
    }

    public HomePage loadHomePage() {
        getBrowser().openUrl(applicationSource.getBaseUrl());
        // TODO Remove getBrowser().getDriver()
        return new HomePage(getBrowser().getDriver());
    }

    public LoginAdminPage loginAdmin() {
        getBrowser().openUrl(applicationSource.getAdminLoginUrl());
        //TODO Remove SearchManager
        return new LoginAdminPage();
    }

    public LogoutAdminPage logoutAdmin() {
        getBrowser().openUrl(applicationSource.getAdminLogoutUrl() + getToken());
        return new LogoutAdminPage();
    }


//    public LoginPage login() {
//        getBrowser().openUrl(applicationSource.getUserLoginUrl());
//        return new LoginPage();
//    }

//    public LogoutPage logoutAdmin() {
//        getBrowser().openUrl(applicationSource.getUserLogoutUrl());
//        return new LogoutPage();
//    }

}
