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

    private void countItemsNumber() {
        FileReader input = null;
        try {
            input = new FileReader(ApplicationSourceRepository.class
                    .getResource("productlist.txt").getPath().substring(1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        LineNumberReader count = new LineNumberReader(input);
        try {
            while (count.skip(Integer.MAX_VALUE) > 0) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       itemsNumber = count.getLineNumber() + 1;
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

    public IPagination itemsPerPageOne() {
        return new Pagination(itemsNumber, 1);
    }

    public IPagination itemsPerPageHalfItemsPlusOne () {
        return new Pagination(itemsNumber, itemsNumber/2+1);    }

    public IPagination itemsPerPageItemsNumber () {
        return new Pagination(itemsNumber, itemsNumber);
    }

    public IPagination itemsPerPageMoreThanItemsNumber () {
        return new Pagination(itemsNumber, itemsNumber + 1);
    }
}
