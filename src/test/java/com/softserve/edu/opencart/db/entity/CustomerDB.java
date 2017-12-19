package com.softserve.edu.opencart.db.entity;

public class CustomerDB implements IEntity {

    public static enum CustomerDBFields {
        CUSTOMER_ID("customer_id"),
        FIRSTNAME("firstname"),
        LASTNAME("lastname"),
        EMAIL("email"),
        TELEPHONE("telephone"),
        ADDRESS_ID("address_id");
        //
        private String field;

        private CustomerDBFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }

    public static enum CustomerDBQueries {
        INSERT(QueryNames.INSERT, "INSERT INTO oc_customer (firstname, lastname, email, telephone, address_id) VALUES ('%s', '%s', '%s', '%s', '%s');"),
        GET_BY_ID(QueryNames.GET_BY_ID, "SELECT customer_id, firstname, lastname, email, telephone, address_id FROM oc_customer WHERE customer_id = %s;"),
        GET_BY_FIELD(QueryNames.GET_BY_FIELD, "SELECT customer_id, firstname, lastname, email, telephone, address_id FROM oc_customer WHERE %s = '%s';"),
        // GET_RANGE(QueryNames.GET_ALL, "SELECT id_user, id_role, login, passwd FROM oc_customer LIMIT %s, %s;"),
        GET_ALL(QueryNames.GET_ALL, "SELECT customer_id, firstname, lastname, email, telephone, address_id FROM oc_customer;"),
        UPDATE_BY_FIELD(QueryNames.UPDATE_BY_FIELD, "UPDATE oc_customer SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(QueryNames.DELETE_BY_ID, "DELETE FROM oc_customer WHERE customer_id = %s;"),
        DELETE_BY_FIELD(QueryNames.DELETE_BY_FIELD, "DELETE FROM oc_customer WHERE %s = '%s';");
        // DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE '%s%%';");
        //
        private QueryNames queryName;
        private String query;

        private CustomerDBQueries(QueryNames queryName, String query) {
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

    // class CustomerDB
    private Long customerId;
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private Long addressId;

    // TODO Create Factory, Builder
    public CustomerDB(Long customerId,
            String firstname, String lastname, String email,
            String telephone, Long addressId) {
        this.customerId = customerId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
        this.addressId = addressId;
    }

    // implements IEntity
    
    public Long getId() {
        return getCustomerId();
    }

    // getters

    public Long getCustomerId() {
        return customerId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public Long getAddressId() {
        return addressId;
    }

    // setters

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

}
