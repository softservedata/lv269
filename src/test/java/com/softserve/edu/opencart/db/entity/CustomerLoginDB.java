package com.softserve.edu.opencart.db.entity;

public class CustomerLoginDB implements IEntity {

    public static enum CustomerLoginDBFields {
        CUSTOMER_LOGIN_ID("customer_login_id"),
        EMAIL("email"),
        IP("ip"),
        TOTAL("total"),
        DATE_ADDED("date_added"),
        DATE_MODIFIED("date_modified");
        //
        private String field;

        private CustomerLoginDBFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    public static enum CustomerLoginDBQueries {
        INSERT(QueryNames.INSERT, "INSERT INTO oc_customer_login (email, ip, total, date_added, date_modified) VALUES ('%s', '%s', %s, '%s', '%s');"),
        GET_BY_ID(QueryNames.GET_BY_ID, "SELECT customer_login_id, email, ip, total, date_added, date_modified FROM oc_customer_login WHERE customer_login_id = %s;"),
        GET_BY_FIELD(QueryNames.GET_BY_FIELD, "SELECT customer_login_id, email, ip, total, date_added, date_modified FROM oc_customer_login WHERE %s = '%s';"),
        // GET_RANGE(QueryNames.GET_ALL, "SELECT id_user, id_role, login, passwd FROM oc_customer_login LIMIT %s, %s;"),
        GET_ALL(QueryNames.GET_ALL, "SELECT customer_login_id, email, ip, total, date_added, date_modified FROM oc_customer_login;"),
        UPDATE_BY_FIELD(QueryNames.UPDATE_BY_FIELD, "UPDATE oc_customer_login SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(QueryNames.DELETE_BY_ID, "DELETE FROM oc_customer_login WHERE customer_login_id = %s;"),
        DELETE_BY_FIELD(QueryNames.DELETE_BY_FIELD, "DELETE FROM oc_customer_login WHERE %s = '%s';");
        // DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE '%s%%';");
        //
        private QueryNames queryName;
        private String query;

        private CustomerLoginDBQueries(QueryNames queryName, String query) {
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

    // class CustomerLoginDB
    private Long customerLoginId;
    private String email;
    private String ip;
    private Long total;
    private String dateAdded;
    private String dateModified;


    // TODO Create Factory, Builder
    public CustomerLoginDB(Long customerLoginId,
            String email, String ip, Long total,
            String dateAdded, String dateModified) {
        this.customerLoginId = customerLoginId;
        this.email = email;
        this.ip = ip;
        this.total = total;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    // implements IEntity
    
    public Long getId() {
        return getCustomerLoginId();
    }

    // getters

    public Long getCustomerLoginId() {
        return customerLoginId;
    }

    public String getEmail() {
        return email;
    }

    public String getIp() {
        return ip;
    }

    public Long getTotal() {
        return total;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public String getDateModified() {
        return dateModified;
    }

    // setters

    public void setCustomerLoginId(Long customerLoginId) {
        this.customerLoginId = customerLoginId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

}
