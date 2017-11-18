package com.softserve.edu.opencart.data.products;

import java.util.ArrayList;
import java.util.List;

public class SearchProductRepository {

    private static volatile SearchProductRepository instance = null;

    private SearchProductRepository() {
    }

    public static SearchProductRepository get() {
        if (instance == null) {
            synchronized (SearchProductRepository.class) {
                if (instance == null) {
                    instance = new SearchProductRepository();
                }
            }
        }
        return instance;
    }

    public ISearchProduct mac(){
        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("iMac").getName());
        expectedProducts.add(new Product("MacBook").getName());
        expectedProducts.add(new Product("MacBook Air").getName());
        expectedProducts.add(new Product("MacBook Pro").getName());
        return new SearchProduct("Mac", expectedProducts);
    }

    public ISearchProduct macBook(){
        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("MacBook").getName());
        expectedProducts.add(new Product("MacBook Air").getName());
        expectedProducts.add(new Product("MacBook Pro").getName());
        return new SearchProduct("MacBook", expectedProducts);
    }

    public ISearchProduct iPod(){
        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("iPod Classic").getName());
        expectedProducts.add(new Product("iPod Nano").getName());
        expectedProducts.add(new Product("iPod Shuffle").getName());
        expectedProducts.add(new Product("iPod Touch").getName());
        return new SearchProduct("iPod", expectedProducts);
    }

    public ISearchProduct palm(){
        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add(new Product("Palm Treo Pro").getName());
        return new SearchProduct("Palm", expectedProducts);
    }
    public ISearchProduct samsungTablet(){
        List<String> inputTextToSearch = new ArrayList<>();
        inputTextToSearch.add("Samsung Galaxy Tab 10.1");
        inputTextToSearch.add("SAMSUNG GALAXY TAB 10.1");
        inputTextToSearch.add("samsung galaxy tab 10.1");
        inputTextToSearch.add("Samsung");
        inputTextToSearch.add("ung");
        inputTextToSearch.add("10.1");
        inputTextToSearch.add("Tab 10.1");

        return new SearchProduct(
                new Product("Samsung Galaxy Tab 10.1").getName(),
                inputTextToSearch);
    }
}
