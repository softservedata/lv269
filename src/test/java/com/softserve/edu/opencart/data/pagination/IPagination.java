package com.softserve.edu.opencart.data.pagination;

import com.softserve.edu.opencart.data.ProductShort;

import java.util.List;

public interface IPagination {

    int getItemsNumber ();
    int getItemsPerPageNumber();
    String getOptionName ();
}
