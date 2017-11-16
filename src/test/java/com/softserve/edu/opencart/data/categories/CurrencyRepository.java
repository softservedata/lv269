package com.softserve.edu.opencart.data.categories;

public class CurrencyRepository {

    private static volatile CurrencyRepository instance = null;

    private CurrencyRepository() {
    }

    public static CurrencyRepository get() {
        if (instance == null) {
            synchronized (CurrencyRepository.class) {
                if (instance == null) {
                    instance = new CurrencyRepository();
                }
            }
        }
        return instance;
    }

    public IDetailCategory dollar() {
        return new DetailCategory("Currency", "US Dollar");
    }

    public IDetailCategory euro() {
        return new DetailCategory("Currency", "Euro");
    }

    public IDetailCategory poundSterling() {
        return new DetailCategory("Currency", "Pound Sterling");
    }

}
