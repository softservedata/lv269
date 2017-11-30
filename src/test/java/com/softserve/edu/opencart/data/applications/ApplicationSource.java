package com.softserve.edu.opencart.data.applications;

public class ApplicationSource implements IApplicationSource {

    // Browser Data
    private String browserName;
    private String driverPath;

    // private String browserPath;
    // private String defaulProfile;
    //
    // Implicit and Explicit Waits
    private long implicitWaitTimeOut;
    private long implicitLoadTimeOut;
    private long implicitScriptTimeOut;
    private long explicitTimeOut;
    //
    // Localization Strategy
    // private String language;
    //
    // search Strategy
     private String searchStrategy;
    //
    // Logger Strategy
    // private String loggerStrategy;
    //
    // URLs
    private String baseUrl;
    private String userLoginUrl;
    private String userLogoutUrl;
    //
    private String adminLoginUrl;
    private String adminLogoutUrl;
    
    // TODO Develop Builder

    public ApplicationSource(String browserName, String driverPath,
            long implicitWaitTimeOut, long implicitLoadTimeOut,
            long implicitScriptTimeOut, long explicitTimeOut, String searchStrategy,
            String baseUrl, String userLoginUrl, String userLogoutUrl,
            String adminLoginUrl, String adminLogoutUrl) {
        this.browserName = browserName;
        this.driverPath = driverPath;
        this.implicitWaitTimeOut = implicitWaitTimeOut;
        this.implicitLoadTimeOut = implicitLoadTimeOut;
        this.implicitScriptTimeOut = implicitScriptTimeOut;
        this.explicitTimeOut = explicitTimeOut;
        this.searchStrategy = searchStrategy;
        this.baseUrl = baseUrl;
        this.userLoginUrl = userLoginUrl;
        this.userLogoutUrl = userLogoutUrl;
        this.adminLoginUrl = adminLoginUrl;
        this.adminLogoutUrl = adminLogoutUrl;
    }

    // setters
    
    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public void setImplicitWaitTimeOut(long implicitWaitTimeOut) {
        this.implicitWaitTimeOut = implicitWaitTimeOut;
    }

    public void setImplicitLoadTimeOut(long implicitLoadTimeOut) {
        this.implicitLoadTimeOut = implicitLoadTimeOut;
    }

    public void setImplicitScriptTimeOut(long implicitScriptTimeOut) {
        this.implicitScriptTimeOut = implicitScriptTimeOut;
    }

    public void setExplicitTimeOut(long explicitTimeOut) {
        this.explicitTimeOut = explicitTimeOut;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setUserLoginUrl(String userLoginUrl) {
        this.userLoginUrl = userLoginUrl;
    }

    public void setUserLogoutUrl(String userLogoutUrl) {
        this.userLogoutUrl = userLogoutUrl;
    }

    public void setAdminLoginUrl(String adminLoginUrl) {
        this.adminLoginUrl = adminLoginUrl;
    }

    public void setAdminLogoutUrl(String adminLogoutUrl) {
        this.adminLogoutUrl = adminLogoutUrl;
    }

    public void setSearchStrategy(String searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    // getters
    
    public String getBrowserName() {
        return browserName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public long getImplicitWaitTimeOut() {
        return implicitWaitTimeOut;
    }

    public long getImplicitLoadTimeOut() {
        return implicitLoadTimeOut;
    }

    public long getImplicitScriptTimeOut() {
        return implicitScriptTimeOut;
    }

    public long getExplicitTimeOut() {
        return explicitTimeOut;
    }

    public String getSearchStrategy() {
        return searchStrategy;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getUserLoginUrl() {
        return userLoginUrl;
    }

    public String getUserLogoutUrl() {
        return userLogoutUrl;
    }

    public String getAdminLoginUrl() {
        return adminLoginUrl;
    }

    public String getAdminLogoutUrl() {
        return adminLogoutUrl;
    }

}
