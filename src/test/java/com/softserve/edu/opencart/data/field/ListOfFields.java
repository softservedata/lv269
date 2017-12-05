package com.softserve.edu.opencart.data.field;

import java.util.List;

public class ListOfFields implements IListOfFields{

    private List<Object[]> data;

    public ListOfFields (List<Object[]> data){
        this.data = data;
    }

    public List<Object[]> getData() {
        return data;
    }


}
