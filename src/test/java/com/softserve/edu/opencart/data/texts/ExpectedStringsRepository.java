package com.softserve.edu.opencart.data.texts;

public class ExpectedStringsRepository {


    private static volatile ExpectedStringsRepository instance = null;

    private ExpectedStringsRepository() {

    }

    public static ExpectedStringsRepository get() {
        if (instance == null) {
            synchronized (ExpectedStringsRepository.class) {
                if (instance == null) {
                    instance = new ExpectedStringsRepository();
                }
            }
        }
        return instance;
    }

    public IExpectedStrings dashboardAdminPageName() {
        return new ExpectedStrings("DashBoard");
    }
    public IExpectedStrings wrongLoginMessage() {
        return new ExpectedStrings("No match for Username and/or Password.");
    }
    public IExpectedStrings productsPageName() {
        return new ExpectedStrings("Products");
    }

}
