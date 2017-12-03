package com.softserve.edu.opencart.data.pagination;

import java.util.Map;

public interface IPagination {

    int getItemsNumber();
    int getItemsPerPageNumber();
    Map<String, String> getOptionsReplaceValues();
}
