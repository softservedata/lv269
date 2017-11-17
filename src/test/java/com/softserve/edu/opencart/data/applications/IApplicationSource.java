package com.softserve.edu.opencart.data.applications;

public interface IApplicationSource {

    String getBrowserName();

    String getDriverPath();

    long getImplicitWaitTimeOut();

    long getImplicitLoadTimeOut();

    long getImplicitScriptTimeOut();

    long getExplicitTimeOut();

    String getBaseUrl();

    String getUserLoginUrl();

    String getUserLogoutUrl();

    String getAdminLoginUrl();

    String getAdminLogoutUrl();

}