package com.softserve.edu.opencart.db.entity;

public class ReviewDB implements IEntity {

    public static enum ReviewDBFields {
        REVIEW_ID("review_id"),
        PRODUCT_ID("productId"),
        CUSTOMER_ID("customer_id"),
        AUTHOR("author"),
        TEXT("text"),
        RATING("rating"),
        STATUS("status"),
        DATE_ADDED("date_added"),
        DATE_MODIFIED("date_modified");

        //
        private String field;

        private ReviewDBFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    public static enum ReviewDBQueries {
        // TO DO
        // INSERT with productId ...
        // GET_BY_ID, GET_BY_FIELD, GET_RANGE, GET_ALL, DELETE_BY_CUSTOMER_ID, DELETE_BY_ID

        DELETE_BY_DAY(QueryNames.DELETE_BY_FIELD, "DELETE FROM oc_customer WHERE date_added like '%s%';"),

        GET_ALL_VISIBLE_BY_PRODUCT_ID(QueryNames.GET_BY_FIELD,
                "select * from oc_review where status=1 and product_id = $s;"),

        MAKE_VISIBLE(QueryNames.UPDATE_BY_FIELD,
                "update oc_review set status = 1, date_modified = now() where productId = %s and date_added like '%s%';");


        //
        private QueryNames queryName;
        private String query;

        private ReviewDBQueries(QueryNames queryName, String query) {
        //private AdminUserDBQueries(String query) {
            this.queryName = queryName;
            this.query = query;
        }

        public QueryNames getQueryName() {
            return queryName;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    // class ReviewDB
    private Long reviewId;
    private Long productId;
    private Long customerId;

    private String author;
    private String text;
    private Integer rating;
    private Integer status;
    private String dateAdded;
    private String dateModified;

    // TODO Create Factory, Builder

    public ReviewDB(Long reviewId, Long productId, Long customerId,
                    String author, String text, Integer rating, Integer status,
                    String dateAdded, String dateModified) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.customerId = customerId;
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.status = status;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    // implements IEntity
    
    public Long getId() {
        return getReviewId();
    }

    // getters

    public Long getReviewId() {
        return reviewId;
    }

    public Long getProductId() {
        return productId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public Integer getRating() {
        return rating;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    // setters

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
