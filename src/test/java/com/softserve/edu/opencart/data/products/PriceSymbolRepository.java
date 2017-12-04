package com.softserve.edu.opencart.data.products;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

/**
 * @author Yurii Ivanytskyi
 */
public class PriceSymbolRepository {

private static volatile PriceSymbolRepository instance = null;
    
    private PriceSymbolRepository() {
    }

	public static PriceSymbolRepository get() {
        if (instance == null) {
            synchronized (PriceSymbolRepository.class) {
                if (instance == null) {
                    instance = new PriceSymbolRepository();
                }
            }
        }
        return instance;
    }

    public IPriceSymbolProduct macBook() {
        Map<String, String> macBookSymbols = new HashedMap<>();
        macBookSymbols.put("Euro", "€");
        macBookSymbols.put("Pound Sterling", "£");
        macBookSymbols.put("US Dollar", "$");
        return new PriceSymbolProduct("MacBook",
                "Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..",
                macBookSymbols);
    }
}
