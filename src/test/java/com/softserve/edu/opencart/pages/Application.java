package com.softserve.edu.opencart.pages;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.data.applications.IApplicationSource;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.tools.ConnectionManager;
import com.softserve.edu.opencart.tools.ReporterWrapper;
import com.softserve.edu.opencart.tools.browsers.BrowserWrapper;
import com.softserve.edu.opencart.tools.browsers.CaptureUtils;
import com.softserve.edu.opencart.tools.search.ISearch;
import com.softserve.edu.opencart.tools.search.Search;

public class Application {

    // Use Singleton, Repository
    private static volatile Application instance;
    //
    // Fields
    //
    // TODO Change for parallel work
    private IApplicationSource applicationSource;
    private CaptureUtils captureUtils;
    private ReporterWrapper reporter;
    private BrowserWrapper browser;
    private ISearch search;
    private ConnectionManager connectionManager;
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
                    instance.initCaptureUtils();
                    instance.initReporter(applicationSource);
                    instance.initBrowser(applicationSource);
                    instance.initSearch(applicationSource);
                    // initAccessToDB();
                    instance.initConnectionManager(applicationSource);
                }
            }
        }
        return instance;
    }
    
    public static void remove() {
        if (instance != null) {
            // TODO Change for parallel work
            instance.browser().quit();
            instance.connectionManager().closeAllConnections();
            instance = null;
        }
    }

    // getters

    // TODO Change for parallel work
    // TODO remove get
    public IApplicationSource getApplicationSource() {
        return applicationSource;
    }

    public CaptureUtils captureUtils() {
        return captureUtils;
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

    public ConnectionManager connectionManager() {
        return connectionManager;
    }

    // Initialization
    
    // TODO Change for parallel work
    public void initCaptureUtils() {
        // TODO  Add parameters to applicationSource
        this.captureUtils = new CaptureUtils();
    }

    public void initReporter(IApplicationSource applicationSource) {
        this.reporter = new ReporterWrapper(applicationSource);
    }

    public void initBrowser(IApplicationSource applicationSource) {
        this.browser = new BrowserWrapper(applicationSource);
    }

    public void initSearch(IApplicationSource applicationSource) {
        this.search = new Search(applicationSource);
    }

    public void initConnectionManager(IApplicationSource applicationSource) {
        this.connectionManager = new ConnectionManager(applicationSource);
    }

    // Pages

    public HomePage loadHomePage() {
        browser().openUrl(applicationSource.getBaseUrl());
        // TODO Remove getBrowser().getDriver()
        //return new HomePage(browser().getDriver());
        return new HomePage();
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
