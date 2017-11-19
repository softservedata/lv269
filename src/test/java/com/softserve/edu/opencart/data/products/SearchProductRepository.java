package com.softserve.edu.opencart.data.products;

import com.softserve.edu.opencart.data.categories.DetailCategory;

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
        expectedProducts.add(new Product("iMac", "Just when you thought iMac had everything, " +
                "now there´s even more. More powerful Intel Core 2 Duo processors. And more memory standard. Com" +
                "bine this with Mac OS X Leopard and iLife ´08, and it´s more all-in-one than ever. iMac packs ama" +
                "zing performance into a stunningly slim space.").getName());
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

    public ISearchProduct searchByDescription(){
        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add("Canon EOS 5D");
        expectedProducts.add("iPhone");
        expectedProducts.add("Sony VAIO");
        Product product = new Product("","Search in description");
        return new SearchProduct(product.getName(), product.getDescription(), expectedProducts);
    }

    public ISearchProduct searchMacBookAirInCategory(){
        return new SearchProduct(new Product("MacBook Air").getName(),
                new DetailCategory("Laptops & Notebooks", "Macs").getOptionName());
    }

    public ISearchProduct searchNikonInCategory(){
        return new SearchProduct(new Product("Nikon").getName(),
                new DetailCategory("Cameras", "Cameras").getOptionName());
    }

    public ISearchProduct searchIMacInCategory(){
        return new SearchProduct(new Product("iMac").getName(),
                new DetailCategory("Desktops", "Mac").getOptionName());
    }
}
