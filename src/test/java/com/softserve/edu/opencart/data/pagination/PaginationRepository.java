package com.softserve.edu.opencart.data.pagination;

public class PaginationRepository {


    private static volatile PaginationRepository instance = null;

    private int itemsNumber;

    private PaginationRepository() {
    }

    public static PaginationRepository get() {
        if (instance == null) {
            synchronized (PaginationRepository.class) {
                if (instance == null) {
                    instance = new PaginationRepository();
                }
            }
        }
        return instance;
    }

    //TODO Without filename here
    public IPagination itemsPerPageOne() {
        Pagination result = new Pagination().readItemsNumberFromFile("productlist.txt");
        result.setItemsPerPageNumber(1);
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getItemsPerPageNumber()));
        return result;
    }

    public IPagination itemsPerPageHalfItemsPlusOne() {
        Pagination result = new Pagination().readItemsNumberFromFile("productlist.txt");
        result.setItemsPerPageNumber(result.getItemsNumber() / 2 + 1);
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getItemsPerPageNumber()));
        return result;
    }

    public IPagination itemsPerPageItemsPerPage() {
        Pagination result = new Pagination().readItemsNumberFromFile("productlist.txt");
        result.setItemsPerPageNumber(result.getItemsNumber());
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getItemsPerPageNumber()));
        return result;
    }

    public IPagination itemsPerPageMoreThanItemsPerPage() {
        Pagination result = new Pagination().readItemsNumberFromFile("productlist.txt");
        result.setItemsPerPageNumber(result.getItemsNumber() + 1);
        result.addOptionReplaceValue("Default Items Per Page (Admin)",
                String.valueOf(result.getItemsPerPageNumber()));
        return result;
    }
}
