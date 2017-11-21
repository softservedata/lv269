package com.softserve.edu.opencart.data.pagination;

import com.softserve.edu.opencart.data.applications.ApplicationSourceRepository;
import com.softserve.edu.opencart.pages.Application;


public class Pagination implements IPagination {

    //TODO make protection from wrong input

    private String optionName;
    private int itemsNumber;
    private int itemsPerPageNumber;

    public Pagination() {
    }

    public int getItemsNumber() {
        return itemsNumber;
    }

    public int getItemsPerPageNumber() {
        return itemsPerPageNumber;
    }

    public String getOptionName() {
        return optionName;
    }

    public Pagination readItemsNumberFromFile(String fileName) {
        itemsNumber = Application.get().getFileManager().readFromFile(ApplicationSourceRepository.class
                .getResource("/" + fileName).getPath().substring(1)).size();
        return this;
    }

    public void setItemsPerPageNumber(int itemsPerPageNumber) {
        this.itemsPerPageNumber = itemsPerPageNumber;
    }

    public Pagination setOptionName(String optionName) {
        this.optionName = optionName;
        return this;
    }
}
