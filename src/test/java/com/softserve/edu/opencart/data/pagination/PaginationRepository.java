package com.softserve.edu.opencart.data.pagination;

import com.softserve.edu.opencart.data.ProductShort;
import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;
import org.seleniumhq.jetty9.server.handler.IPAccessHandler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

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
        Pagination result = new Pagination()
                .readItemsNumberFromFile("productlist.txt")
                .setOptionName("Default Items Per Page (Admin)");
        result.setItemsPerPageNumber(1);
        return result;
    }

    public IPagination itemsPerPageHalfItemsPlusOne() {
        Pagination result = new Pagination()
                .readItemsNumberFromFile("productlist.txt")
                .setOptionName("Default Items Per Page (Admin)");
        result.setItemsPerPageNumber(result.getItemsNumber()/2+1);
        return result;
    }

    public IPagination itemsPerPageItemsPerPage() {
        Pagination result = new Pagination()
                .readItemsNumberFromFile("productlist.txt")
                .setOptionName("Default Items Per Page (Admin)");
        result.setItemsPerPageNumber(result.getItemsNumber());
        return result;
    }

    public IPagination itemsPerPageMoreThanItemsPerPage() {
        Pagination result = new Pagination()
                .readItemsNumberFromFile("productlist.txt")
                .setOptionName("Default Items Per Page (Admin)");
        result.setItemsPerPageNumber(result.getItemsNumber()+1);
        return result;
    }
}
