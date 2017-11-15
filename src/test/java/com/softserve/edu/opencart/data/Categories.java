package com.softserve.edu.opencart.data;

import java.util.List;

public class Categories {

    private class Category {
        
        private String name;
        private List<String>  subCategories;
        
    }
    
    private List<Category> listCategories;
    private Category currency;
    
}
