package com.softserve.edu.opencart.pages.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.Product;

public class WishListPage extends AColumnRightUserComponent {

	private class TableRow {
		private class Action {
			private WebElement addToCart;
			private WebElement delete;

			public Action(WebElement rowLocator) {
				addToCart = search.cssSelector(".btn.btn-primary", rowLocator);
				delete = search.cssSelector(".btn.btn-danger", rowLocator);
			}

			public WebElement getAddToCart() {
				return addToCart;
			}

			public WebElement getDelete() {
				return delete;
			}

			public void clickAddToCart() {
				getAddToCart().click();
			}

			public void clickDelete() {
				getDelete().click();
			}
		}

		private WebElement image;
		private WebElement productName;
		private WebElement model;
		private WebElement stock;
		private WebElement unitPrice;
		private Action action;

		public TableRow(WebElement rowLocator) {			
			image = search.cssSelector(".text-center > a", rowLocator);
			productName = search.cssSelector(".text-left > a", rowLocator);
			model = search.xpath(".//td[text()=.]", rowLocator);
			stock = search.cssSelector(".text-right", rowLocator);
			unitPrice = search.cssSelector(".price", rowLocator);
			action = new Action(rowLocator);
		}

		// get Data

		public WebElement getImage() {
			return image;
		}

		public WebElement getProductName() {
			return productName;
		}

		public WebElement getModel() {
			return model;
		}

		public WebElement getStock() {
			return stock;
		}

		public WebElement getUnitPrice() {
			return unitPrice;
		}

		public Action getAction() {
			return action;
		}

		// get Functional

		public String getProductNameText() {
			return getProductName().getText();
		}

		public String getModelText() {
			return getModel().getText();
		}

		public String getStockText() {
			return getStock().getText();
		}

		public String getUnitPriceText() {
			return getUnitPrice().getText();
		}

		// set Data

		public void clickImage() {
			getImage().click();
		}

		public void clickProductName() {
			getProductName().click();
		}

		public void clickActionAddToCart() {
			getAction().clickAddToCart();
		}

		public void clickActionDelete() {
			getAction().clickDelete();
		}

	}

	private class TableHeader {
		private WebElement image;
		private WebElement productName;
		private WebElement model;
		private WebElement stock;
		private WebElement unitPrice;
		private WebElement action;

		// tableLocator should have "thead>tr" locator
		public TableHeader(WebElement tableLocator) {
			image = search.xpath(".//td[text()='Image']", tableLocator);
			productName = search.xpath(".//td[text()='Product Name']", tableLocator);
			model = search.xpath(".//td[text()='Model']", tableLocator);
			stock = search.xpath(".//td[text()='Stock']", tableLocator);
			unitPrice = search.xpath(".//td[text()='Unit Price']", tableLocator);
			action = search.xpath(".//td[text()='Action']", tableLocator);
		}

		// get Data

		public WebElement getImage() {
			return image;
		}

		public WebElement getProductName() {
			return productName;
		}

		public WebElement getModel() {
			return model;
		}

		public WebElement getStock() {
			return stock;
		}

		public WebElement getUnitPrice() {
			return unitPrice;
		}

		public WebElement getAction() {
			return action;
		}

		// get Functional

		public String getImageText() {
			return getImage().getText();
		}

		public String getProductNameText() {
			return getProductName().getText();
		}

		public String getModelText() {
			return getModel().getText();
		}

		public String getStockText() {
			return getStock().getText();
		}

		public String getUnitPriceText() {
			return getUnitPrice().getText();
		}

		public String getActionText() {
			return getAction().getText();
		}
	}

	//----------------------------------------------------------------------------
	
	private WebElement textTop;
	private TableHeader tableHeader;
	private List<TableRow> tableBody;
	private WebElement contentData;
	private WebElement continueButton;

	private final static String CSS_TABLE_LOCATOR = ".table.table-bordered.table-hover";
	private final static String CSS_ROW_TABLE_LOCATOR = ".//tbody/tr[%s]";
	private final static String ID_CONTENT_LOCATOR = "content";
	private final static String WISH_LIST_EMPTY = "Your wish list is empty.";

	private final String PRODUCT_NAME_NOT_FOUND_MESSAGE = "Product %s not found in Wish List";

	public WishListPage() {
		super();
		textTop = search.cssSelector("#content > h2");
		continueButton = search.cssSelector(".pull-right > .btn.btn-primary");
		tableBody = new ArrayList<>();
		initWishListTable("#content > p", "thead > tr", "tbody > tr");
	}

	private void initWishListTable(String mainTextLocator, String tableHeadLocator, String tableBodyLocator) {
		if (isWishListEmpty()) {
			contentData = search.cssSelector(mainTextLocator);
		} else {
			tableHeader = new TableHeader(search.cssSelector(tableHeadLocator));
			int tableRowCounter = search.cssSelectors(tableBodyLocator).size();
			WebElement tablePointer = search.cssSelector(CSS_TABLE_LOCATOR);
			for (int i = 1; i <= tableRowCounter; i++) {				
				tableBody.add(new TableRow(search.xpath(String.format(CSS_ROW_TABLE_LOCATOR, i), tablePointer)));
			}
		}
	}

	public boolean isWishListEmpty() {
		return search.id(ID_CONTENT_LOCATOR).getText().contains(WISH_LIST_EMPTY);
	}

	//----------------------------------------------------------------------------
	// get Data
	//----------------------------------------------------------------------------
	
	public WebElement getTextTop() {
		return textTop;
	}
	
	public TableHeader getTableHeader() {
		return tableHeader;
	}
	
	public List<TableRow> getTableBody() {
		return tableBody;
	}
	
	public WebElement getContentData() {
		return contentData;
	}

	public WebElement getContinueButton() {
		return continueButton;
	}
	
	//----------------------------------------------------------------------------
	// get Functional
	//----------------------------------------------------------------------------
	
	public String getTextTopText() {
		return getTextTop().getText();
	}
	
	public String getContentDataText() {
		return getContentData().getText();
	}
	
	//----------------------------------------------------------------------------
	// set Data
	//----------------------------------------------------------------------------
	
	public void clickContinueButton() {
		getContinueButton().click();
	}
	
	//----------------------------------------------------------------------------	
	// set Functional
	//----------------------------------------------------------------------------
	
	private TableRow getProductByName (String productName) {
		TableRow result = null;
		for (TableRow current : getTableBody()) {
			if (current.getProductNameText().equals(productName)) {
				result = current;
			}
		}
        return result;
	}
	
	public void clickDeleteButton(String productName) {
		getProductByName(productName).clickActionDelete();
	}
	
	public void clickAddToCartButton(String productName) {
		getProductByName(productName).clickActionAddToCart();
	}
	
	public List<String> getProductNamesFromWishList() {
		List<String> productNames = new ArrayList<>();
		for(TableRow current : getTableBody()) {
			productNames.add(current.getProductNameText());
		}
		return productNames;
	}

	public boolean checkWhetherProductExistsInWishList(IProduct product) {
		if (getProductByName(product.getName()) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public void doWishListEmpty() {
		if (!isWishListEmpty()) {
			List<String> products = getProductNamesFromWishList();
			if (products.size() > 0) {
				for (String product : products) {
					new WishListPage().clickDeleteProductFromWishList(product);
				}
			}
		}
	}
	
	public MyAccountPage gotoMyAccountPageByClickContinueButton() {
		clickContinueButton();
		return new MyAccountPage();
	}
	
	public WishListPage clickDeleteProductFromWishList(Product product) {
		clickDeleteButton(product.getName());
		return new WishListPage();
	}
	
	public WishListPage clickDeleteProductFromWishList(String productName) {
		clickDeleteButton(productName);
		return new WishListPage();
	}	
}