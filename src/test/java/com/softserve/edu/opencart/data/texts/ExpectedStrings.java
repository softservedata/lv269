package com.softserve.edu.opencart.data.texts;

public class ExpectedStrings implements IExpectedStrings {

    //TODO make protection from wrong input

    private String pageName;

    public ExpectedStrings(String pageName) {
        this.pageName = pageName;
    }

    public String getExpectedString() {
        return pageName;
    }
}
