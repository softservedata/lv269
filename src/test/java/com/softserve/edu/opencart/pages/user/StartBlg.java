package com.softserve.edu.opencart.pages.user;

public class StartBlg {

    private StartOpr startOpr;

    public StartBlg() {
        this.startOpr = new StartOpr();
    }

    // TODO delete
    //public StartBlg(StartOpr startOpr) {
    //    this.startOpr = startOpr;
    //}

    public StartOpr getStartOpr() {
        //System.out.println("\t***getStartOpr() DONE");
        return startOpr;
    }

    // Business Logic

    public StartBlg searchBytext(String text) {
        getStartOpr().clickSearchProductField();
        getStartOpr().clearSearchProductField();
        getStartOpr().setSearchProductField(text);
        getStartOpr().clickSearchProductButton();
        //System.out.println("searchBytext(String text) DONE");
        return this;
    }
    
    public RegAccBlg gotoRegAccBlg() {
        getStartOpr().clickRegister();
        return new RegAccBlg();
    }

    public int getResult() {
        // TODO
        System.out.println("getResult() DONE");
        return 1;
    }

}
