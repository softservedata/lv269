package com.softserve.edu.opencart.db.dao;

import com.softserve.edu.opencart.db.entity.ReviewDB.ReviewDBQueries;
import com.softserve.edu.opencart.db.entity.ReviewDB;

public class ReviewDao extends ADaoCRUD<ReviewDB> {

    // TODO Create abstract method in ADao
    protected void init() {
        System.out.println("***ReviewDao init()");
        for (ReviewDBQueries reviewDBQueries : ReviewDBQueries.values()) {
            sqlQueries.put(reviewDBQueries.getQueryName(), reviewDBQueries);
        }
        System.out.println("***ReviewDao sqlQueries: " + sqlQueries);
    }

    public ReviewDB createInstance(String[] args) {
        return new ReviewDB(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                Long.parseLong(args[1] == null ? new String() : args[1]),
                Long.parseLong(args[2] == null ? new String() : args[2]),
                args[3] == null ? new String() : args[3],
                args[4] == null ? new String() : args[4],
                Integer.parseInt(args[5] == null ? "0" : args[5]),
                Integer.parseInt(args[6] == null ? new String() : args[6]),
                args[7] == null ? new String() : args[7],
                args[8] == null ? new String() : args[8]);
    }

    public String[] getFields(ReviewDB entity) {
        String[] fields = new String[ReviewDB.class.getDeclaredFields().length];
        fields[0] = entity.getReviewId().toString();
        fields[1] = entity.getProductId().toString();
        fields[2] = entity.getCustomerId().toString();
        fields[3] = entity.getAuthor();
        fields[4] = entity.getText();
        fields[5] = entity.getRating().toString();
        fields[6] = entity.getStatus().toString();
        fields[7] = entity.getDateAdded();
        fields[8] = entity.getDateModified();
        return fields;
    }

}
