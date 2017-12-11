package com.softserve.edu.opencart.data.filter;

import com.softserve.edu.opencart.data.ProductShort;

import java.util.List;

public interface IAdminProductFilterLists {

    ProductShort getFilterTemplate();

    List<ProductShort> getCurrentProductShortList();

}
