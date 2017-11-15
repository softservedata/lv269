package com.softserve.edu.opencart.data;

public class DetailCategory {

    private String categoryName;
    private String optionName;
    
    public DetailCategory(String categoryName, String optionName) {
        this.categoryName = categoryName;
        this.optionName = optionName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

}
