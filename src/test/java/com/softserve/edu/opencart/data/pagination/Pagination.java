package com.softserve.edu.opencart.data.pagination;

import java.util.ArrayList;
import java.util.List;

public class Pagination implements IPagination {

    //TODO make protection from wrong input

    private int itemsNumber;
    private int itemsPerPageNumber;

    public Pagination(int itemsNumber, int itemsPerPageNumber) {
        this.itemsNumber = itemsNumber;
        this.itemsPerPageNumber = itemsPerPageNumber;
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public int getItemsPerPageNumber() {
        return itemsPerPageNumber;
    }
}
