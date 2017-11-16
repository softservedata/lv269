package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;

public class Application {

    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    //private BrowserWrapper browser;
    // etc.

    private Application(IApplicationSource applicationSource) {
        this.applicationSource = applicationSource;
        //this.browser = new BrowserWrapper(applicationSources);
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
                    //instance.init();
                }
            }
        }
        return instance;
    }
    
/*
    public static void remove() {
        if (instance != null) {
            instance.getBrowser().quit();
        }
        instance = null;
    }

    public void init() {
        // initWebDriver(); // Use Constructor
        // initWaits();
        //
        // Init Strategy from ApplicationSources
        Search.initSearch(getApplicationSources());
        // TODO
        // Init DB access, etc.
    }

    public LoginPage load() {
        logout();
        getBrowser().get(applicationSources.getLoginUrl());
        return new LoginPage();
    }

    public LoginPage login() {
        logout();
        getBrowser().get(applicationSources.getLoginUrl());
        return new LoginPage();
    }

    public LoginPage logout() {
        getBrowser().get(applicationSources.getLogoutUrl());
        return new LoginPage();
    }

    // TODO Change for parallel work
    public WebDriver getBrowser() {
        // TODO For parallel work
        return browser.getDriver();
    }

    // TODO Change for parallel work
    public ApplicationSources getApplicationSources() {
		return applicationSources;
	}
*/

}
