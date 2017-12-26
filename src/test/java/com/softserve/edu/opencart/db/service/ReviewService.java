package com.softserve.edu.opencart.db.service;

import com.softserve.edu.opencart.db.dao.ReviewDao;
import com.softserve.edu.opencart.db.entity.ReviewDB;

import java.util.ArrayList;
import java.util.List;

public class ReviewService {
    private ReviewDao reviewDao;

    public ReviewService() {
        reviewDao = new ReviewDao();
    }

    public boolean deleteByDay(String date) {
        return reviewDao.deleteByFieldName(ReviewDB.ReviewDBFields.DATE_ADDED.toString(), date);
    }

    public List<String[]> getAllVisibleByProductId(Long productId) {
        List<String[]> result = new ArrayList<>();
        for (ReviewDB reviewDB : reviewDao.getByFieldName(ReviewDB.ReviewDBFields.STATUS.toString(), "1")) {
            if (reviewDB.getProductId().equals(productId)){
            result.add(reviewDao.getFields(reviewDB));}
        }
        return result;
    }

    public List<String[]> getAllByProductId(Long productId) {
        List<String[]> result = new ArrayList<>();
        for (ReviewDB reviewDB : reviewDao.getByFieldName(ReviewDB.ReviewDBFields.PRODUCT_ID.toString(), productId.toString())) {
                result.add(reviewDao.getFields(reviewDB));
        }
        return result;
    }

    // TODO
    /*public void makeVisibleByProductIdAndDate (Long productId, String date) {
        List<String[]> revievsByProductId = getAllByProductId(productId);
        reviewDao.updateByFieldName(ReviewDB.ReviewDBFields.STATUS.toString(), "1", )

//   "update oc_review set status = 1, date_modified = now() where productId = %s and date_added like '%s%';");
    }*/


}
