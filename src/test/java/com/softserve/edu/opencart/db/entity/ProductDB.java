package com.softserve.edu.opencart.db.entity;

public class ProductDB implements IEntity{

	public static enum ProductDBFields {
        PRODUCT_ID("product_id"),
        PRICE("price");
        //
        private String field;

        private ProductDBFields(String field) {
            this.field = field;
        }

        @Override
        public String toString() {
            return field;
        }
    }
	
	public static enum ProductDBQueries {
        GET_BY_ID(QueryNames.GET_BY_ID, "SELECT product_id, price FROM oc_product WHERE product_id = %s;"),
        GET_BY_FIELD(QueryNames.GET_BY_FIELD, "SELECT product_id, price FROM oc_product WHERE %s = '%s';"),
        GET_ALL(QueryNames.GET_ALL, "SELECT product_id, price FROM oc_product;");
        private QueryNames queryName;
        private String query;

        private ProductDBQueries(QueryNames queryName, String query) {
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
    private Long productId;
    private Double price;
    
    // TODO Create Factory, Builder
    public ProductDB(Long productId, Double price) {
		this.productId = productId;
		this.price = price;
	}

    // implements IEntity
    
    public Long getId() {
        return getProductId();
    }

    // getters
    
	public Long getProductId() {
		return productId;
	}

	public Double getPrice() {
		return price;
	}

	// setters
	
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	

}
