package com.softserve.edu.opencart.pages.user;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.products.IProduct;
import com.softserve.edu.opencart.data.products.Product;
import com.softserve.edu.opencart.tools.ErrorUtils;

public class WishListPage extends AColumnRightUserComponent {

	private class TableRow {
		private class Action {
			private WebElement addToCart;
			private WebElement delete;

			public Action(WebElement rowLocator) {
				addToCart = rowLocator.findElement(By.cssSelector(".btn.btn-primary"));
				delete = rowLocator.findElement(By.cssSelector(".btn.btn-danger"));
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
			image = rowLocator.findElement(By.cssSelector(".text-center > a"));
			productName = rowLocator.findElement(By.cssSelector(".text-left > a"));
			model = rowLocator.findElement(By.xpath(".//td[text()=.]"));
			stock = rowLocator.findElement(By.cssSelector(".text-right"));
			unitPrice = rowLocator.findElement(By.cssSelector(".price"));
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
			image = tableLocator.findElement(By.xpath(".//td[text()='Image']"));
			productName = tableLocator.findElement(By.xpath(".//td[text()='Product Name']"));
			model = tableLocator.findElement(By.xpath(".//td[text()='Model']"));
			stock = tableLocator.findElement(By.xpath(".//td[text()='Stock']"));
			unitPrice = tableLocator.findElement(By.xpath(".//td[text()='Unit Price']"));
			action = tableLocator.findElement(By.xpath(".//td[text()='Action']"));
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

	public WishListPage(WebDriver driver) {
		super(driver);
		textTop = driver.findElement(By.cssSelector("#content > h2"));
		continueButton = driver.findElement(By.cssSelector(".pull-right > .btn.btn-primary"));
		tableBody = new ArrayList<>();
		initWishListTable("#content > p", "thead > tr", "tbody > tr");
	}

	private void initWishListTable(String mainTextLocator, String tableHeadLocator, String tableBodyLocator) {
		if (isWishListEmpty()) {
			contentData = driver.findElement(By.cssSelector(mainTextLocator));
		} else {
			tableHeader = new TableHeader(driver.findElement(By.cssSelector(tableHeadLocator)));
			int tableRowCounter = driver.findElements(By.cssSelector(tableBodyLocator)).size();
			WebElement tablePointer = driver.findElement(By.cssSelector(CSS_TABLE_LOCATOR));
			for (int i = 1; i <= tableRowCounter; i++) {
				tableBody.add(new TableRow(tablePointer.findElement(By.xpath(String.format(CSS_ROW_TABLE_LOCATOR, i)))));
			}
		}
	}

	public boolean isWishListEmpty() {
		return driver.findElement(By.id(ID_CONTENT_LOCATOR)).getText().contains(WISH_LIST_EMPTY);
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
					new WishListPage(driver).clickDeleteProductFromWishList(product);
				}
			}
		}
	}

	public MyAccountPage gotoMyAccountPageByClickContinueButton() {
		clickContinueButton();
		return new MyAccountPage(driver);
	}
	
	public WishListPage clickDeleteProductFromWishList(Product product) {
		clickDeleteButton(product.getName());
		return new WishListPage(driver);
	}
	
	public WishListPage clickDeleteProductFromWishList(String productName) {
		clickDeleteButton(productName);
		return new WishListPage(driver);
	}
	
}