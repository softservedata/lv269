package com.softserve.edu.opencart.db.entity;

public class CurrencyDB implements IEntity{
	
	 public static enum CurrencyDBFields {
	        CURRENCY_ID("currency_id"),
	        TITLE("title"),
	        CODE("code"),
	        SYMBOL_LEFT("symbol_left"),
	        SYMBOL_RIGHT("symbol_right"),
	        VALUE("value");
	        //
	        private String field;

	        private CurrencyDBFields(String field) {
	            this.field = field;
	        }

	        @Override
	        public String toString() {
	            return field;
	        }
	    }
	 public static enum CurrencyDBQueries {
	        GET_BY_ID(QueryNames.GET_BY_ID, "SELECT currency_id, title, code, symbol_left, symbol_right, value FROM oc_currency WHERE currency_id = %s;"),
	        GET_BY_FIELD(QueryNames.GET_BY_FIELD, "SELECT currency_id, title, code, symbol_left, symbol_right, value FROM oc_currency WHERE %s = '%s';"),
	        GET_ALL(QueryNames.GET_ALL, "SELECT currency_id, title, code, symbol_left, symbol_right, value FROM oc_currency;");
	        private QueryNames queryName;
	        private String query;

	        private CurrencyDBQueries(QueryNames queryName, String query) {
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
	    private Long currencyId;
	    private String title;
	    private String code;
	    private String symbolLeft;
	    private String symbolRight;
	    private Double value;
	    
	    // TODO Create Factory, Builder
	    public CurrencyDB(Long currencyId, String title, String code, String symbolLeft, String symbolRight,
				Double value) {
			this.currencyId = currencyId;
			this.title = title;
			this.code = code;
			this.symbolLeft = symbolLeft;
			this.symbolRight = symbolRight;
			this.value = value;
		}

	    // implements IEntity
	    
	    public Long getId() {
	        return getCurrencyId();
	    }

	    // getters
	    
		public Long getCurrencyId() {
			return currencyId;
		}

		public String getTitle() {
			return title;
		}

		public String getCode() {
			return code;
		}

		public String getSymbolLeft() {
			return symbolLeft;
		}

		public String getSymbolRight() {
			return symbolRight;
		}

		public Double getValue() {
			return value;
		}

		// setters
		
		public void setCurrencyId(Long currencyId) {
			this.currencyId = currencyId;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public void setSymbolLeft(String symbolLeft) {
			this.symbolLeft = symbolLeft;
		}

		public void setSymbolRight(String symbolRight) {
			this.symbolRight = symbolRight;
		}

		public void setValue(Double value) {
			this.value = value;
		}
		

}
