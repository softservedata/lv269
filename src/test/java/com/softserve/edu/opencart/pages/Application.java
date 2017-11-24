package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tools.BrowserWrapper;
import com.softserve.edu.opencart.tools.Search;

public class Application {

    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    private BrowserWrapper browser;
    //private ISearch search;
    // etc.

    private Application(IApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
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
                    instance.initSearch(applicationSource);
                    // initAccessToDB();
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
    public IApplicationSource getApplicationSource() {
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

    public void initSearch(IApplicationSource applicationSource) {
        //this.search = new Search(applicationSource);
        Search.initSearch(applicationSource);
    }

    public HomePage loadHomePage() {
        getBrowser().openUrl(applicationSource.getBaseUrl());
        // TODO Remove getBrowser().getDriver()
        return new HomePage(getBrowser().getDriver());
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
