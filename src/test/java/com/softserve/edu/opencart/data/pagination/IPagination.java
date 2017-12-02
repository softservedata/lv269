package com.softserve.edu.opencart.data.pagination;

import com.softserve.edu.opencart.data.ProductShort;

import java.util.List;
import java.util.Map;

public interface IPagination {

    int getItemsNumber ();
    int getItemsPerPageNumber();
    Map<String, String> getOptionsReplaceValues();
}
