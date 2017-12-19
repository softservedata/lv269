package com.softserve.edu.opencart.pages.user;

public class StartBlg {

    private StartOpr startOpr;

    public StartBlg() {
        this.startOpr = new StartOpr();
    }

    public StartOpr getStartOpr() {
        return startOpr;
    }

    // Business Logic

    public StartBlg searchBytext(String text) {
        getStartOpr().clickSearchProductField();
        getStartOpr().clearSearchProductField();
        getStartOpr().setSearchProductField(text);
        getStartOpr().clickSearchProductButton();
        return this;
    }
    
    public RegAccBlg gotoRegAccBlg() {
        getStartOpr().clickRegister();
        return new RegAccBlg();
    }
}