package com.softserve.edu.opencart.db.dao;

import com.softserve.edu.opencart.db.entity.ReviewDB.ReviewDBQueries;
import com.softserve.edu.opencart.db.entity.ReviewDB;

public class ReviewDao extends ADaoCRUD<ReviewDB> {

    // TODO Create abstract method in ADao
    protected void init() {
        System.out.println("***CustomerDao init()");
        for (ReviewDBQueries reviewDBQueries : ReviewDBQueries.values()) {
            sqlQueries.put(reviewDBQueries.getQueryName(), reviewDBQueries);
        }
        System.out.println("***CustomerDao sqlQueries: " + sqlQueries);
    }

    public ReviewDB createInstance(String[] args) {
       /* return new ReviewDB(Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2],
                args[3] == null ? new String() : args[3],
                args[4] == null ? new String() : args[4],
                Long.parseLong(args[5] == null ? "0" : args[5]));*/
       return null;
    }

    public String[] getFields(ReviewDB entity) {
        // String[] fields = new String[UserDB.class.getDeclaredFields().length];
        String[] fields = new String[6];
       /* fields[0] = entity.getCustomerId().toString();
        fields[1] = entity.getFirstname();
        fields[2] = entity.getLastname();
        fields[3] = entity.getEmail();
        fields[4] = entity.getTelephone();
        fields[5] = entity.getAddressId().toString();*/
        return fields;
    }

}
