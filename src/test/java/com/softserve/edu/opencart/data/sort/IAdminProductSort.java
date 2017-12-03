package com.softserve.edu.opencart.data.sort;

import com.softserve.edu.opencart.data.ProductShort;

import java.util.List;
import java.util.Map;

public interface IAdminProductSort {
    String getColumnName();
    Map<String, String> getOptionsReplaceValues();
    String getSortOrder();
    List<ProductShort> getCurrentProductShortList();
}
