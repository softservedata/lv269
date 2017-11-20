package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.pages.admin.LoginAdminPage;
import com.softserve.edu.opencart.pages.admin.LogoutAdminPage;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tools.BrowserWrapper;
import com.softserve.edu.opencart.tools.FileManager;
import com.softserve.edu.opencart.tools.SearchManager;

public class Application {

    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    private BrowserWrapper browser;
    private SearchManager searchManager;
    private FileManager fileManager;
    // etc.

    private Application(IApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
        initBrowser(applicationSource);
        initSearchStrategy();
        // initAccessToDB();
    }

    private void initSearchStrategy() {
        searchManager = new SearchManager(browser.getDriver());
        fileManager = new FileManager();
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

    // TODO Change for parallel work
    public IApplicationSource getApplicationSources() {
        return applicationSource;
    }

    // TODO Change for parallel work
    public BrowserWrapper getBrowser() {
        return browser;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    // TODO Change for parallel work
    public void initBrowser(IApplicationSource applicationSource) {
        this.browser = new BrowserWrapper(applicationSource);
    }

    //TODO Change it after demo
    public void initSearchManager () {
        searchManager = new SearchManager(getBrowser().getDriver());
    }

    public HomePage loadHomePage() {
        getBrowser().openUrl(applicationSource.getBaseUrl());
        // TODO Remove getBrowser().getDriver()
        return new HomePage(getBrowser().getDriver());
    }

        public LoginAdminPage loginAdmin() {
        getBrowser().openUrl(applicationSource.getAdminLoginUrl());
        //TODO Remove SearchManager
        return new LoginAdminPage(searchManager);
    }

    public LogoutAdminPage logout() {
        getBrowser().openUrl(applicationSource.getUserLogoutUrl());
        return new LogoutAdminPage(searchManager);
    }


//    public LoginPage login() {
//        getBrowser().openUrl(applicationSource.getUserLoginUrl());
//        return new LoginPage();
//    }

//    public LogoutPage logout() {
//        getBrowser().openUrl(applicationSource.getUserLogoutUrl());
//        return new LogoutPage();
//    }

}
