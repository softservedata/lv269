package com.softserve.edu.opencart.data.applications;

public interface IApplicationSource {

    String getBrowserName();

    String getDriverPath();

    long getImplicitWaitTimeOut();

    long getImplicitLoadTimeOut();

    long getImplicitScriptTimeOut();

    long getExplicitTimeOut();

    String getSearchStrategy();

    String getDatabaseUrl();

    String getDatabaseLogin();

    String getDatabasePassword();

    boolean getConsoleOutput();

    String getBaseUrl();

    String getUserLoginUrl();

    String getUserLogoutUrl();

    String getAdminLoginUrl();

    String getAdminLogoutUrl();

}
